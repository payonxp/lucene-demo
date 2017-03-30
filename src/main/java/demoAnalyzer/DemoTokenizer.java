package demoAnalyzer;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene.util.AttributeFactory;

import java.io.IOException;

public class DemoTokenizer extends Tokenizer{

    private final StringBuilder buffer = new StringBuilder();
    private int tokenStart = 0;
    private int tokenEnd = 0;

    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private final OffsetAttribute offsetAtt = addAttribute(OffsetAttribute.class);
    private final TypeAttribute typeAtt = addAttribute(TypeAttribute.class);

    /**标点符号*/
    private final static String PUNCTION = ".。,，、:：·\"“'‘!！;；?？";
    /**空白字符*/
    private final static String SPACES = " 　\t\r\n";

    public DemoTokenizer() {
        super();
    }

    public DemoTokenizer(AttributeFactory factory) {
        super(factory);
    }

    @Override
    public boolean incrementToken() throws IOException {
        clearAttributes();
        buffer.setLength(0);
        int ci;
        char ch, pch;
        boolean atBegin = true;
        tokenStart = tokenEnd;
        ci = input.read();
        ch = (char) ci;

        while (true) {
            if (ci == -1) {
                break;
            } else if (isPunction(ch)) {
                buffer.append(ch);
                tokenEnd++;
                break;
            } else if (atBegin && isSpace(ch)) {
                tokenStart++;
                tokenEnd++;
                ci = input.read();
                ch = (char) ci;
            } else {
                buffer.append(ch);
                atBegin = false;
                tokenEnd++;
                pch = ch;
                ci = input.read();
                ch = (char) ci;
                if (isTwoSpace(ch,pch)) {
                    tokenEnd++;
                    break;
                }
            }
        }
        if (buffer.length() == 0) {
            return false;
        }
        termAtt.setEmpty().append(buffer);
        offsetAtt.setOffset(correctOffset(tokenStart),
                correctOffset(tokenEnd));
        typeAtt.setType("sentence");
        return true;
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        tokenStart = tokenEnd = 0;
    }

    @Override
    public void end() {
        final int finalOffset = correctOffset(tokenEnd);
        offsetAtt.setOffset(finalOffset, finalOffset);
    }

    public static boolean isPunction(char ch) {
        return PUNCTION.indexOf(ch) != -1;
    }

    /**
     * 判断是否为空白字符
     * @param ch
     * @return
     */
    public static boolean isSpace(char ch) {
        return SPACES.indexOf(ch) != -1;
    }

    /**
     * 判断是否为双空白字符
     * @param ch
     * @param pch
     * @return
     */
    public static boolean isTwoSpace(char ch,char pch) {
        return SPACES.indexOf(ch) != -1 && SPACES.indexOf(pch) != -1;
    }
}
