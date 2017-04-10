package demoAnalyzer;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.huaban.analysis.jieba.CharacterUtil;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoTokenFilter extends TokenFilter{
    private JiebaSegmenter segmenter = new JiebaSegmenter();

    private Iterator<SegToken> tokenIterator;
    private List<SegToken> tokenList;
    private String mode;

    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private final OffsetAttribute offsetAtt = addAttribute(OffsetAttribute.class);
    private final TypeAttribute typeAtt = addAttribute(TypeAttribute.class);

    /**
     * Construct a token stream filtering the given input.
     *
     * @param input
     */
    DemoTokenFilter(String mode, TokenStream input) {
        super(input);
        this.mode = mode;
    }

    @Override
    public boolean incrementToken() throws IOException {
        if (tokenIterator == null || !tokenIterator.hasNext()) {
            if (input.incrementToken()) {
                if (null == this.mode || "".equals(this.mode) || this.mode.equalsIgnoreCase("index")) {
                        tokenList = segmenter.process(termAtt.toString(),
                            JiebaSegmenter.SegMode.INDEX);
                } else {
                    tokenList = new ArrayList<SegToken>();
                    String token = termAtt.toString();
                    char[] ctoken = token.toCharArray();
                    for (int i = 0; i < ctoken.length; i++) {
                        ctoken[i] = CharacterUtil.regularize(ctoken[i]);
                    }
                    token = String.valueOf(ctoken);
                    tokenList.add(new SegToken(token, 0, token.length()));
                }

                tokenIterator = tokenList.iterator();
                if (!tokenIterator.hasNext()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        clearAttributes();
        SegToken token = tokenIterator.next();
        offsetAtt.setOffset(token.startOffset, token.endOffset);
        String tokenString = token.word;
        termAtt.copyBuffer(tokenString.toCharArray(), 0, tokenString.length());
        //词性标注暂未实现
        typeAtt.setType("word");
        return true;
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        tokenIterator = null;
    }
}
