package demoAnalyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;

/*
* Custom Analyzer Using jieba
* */

public class DemoAnalyzer extends Analyzer{

    private String mode;

    public DemoAnalyzer(String mode) {
        this.mode = mode;
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {

        Tokenizer tokenizer = new DemoTokenizer();
        TokenStream tokenFilter = new DemoTokenFilter(mode, tokenizer);
        return new TokenStreamComponents(tokenizer, tokenFilter);

    }
}

