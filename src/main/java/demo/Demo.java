package demo;

import com.huaban.analysis.jieba.JiebaSegmenter;
import org.junit.jupiter.api.Test;

import java.util.List;

class Demo {

    @Test
    public static void main(String[] args) throws Exception {
        index("C:\\Users\\tpeng\\Downloads\\douban_TV");
        search("古装片和动作片");
    }

    // indexing docs
    static List index(String path) {
        String[] arg = new String[2];
        arg[0] = "-docs";
        arg[1] = path;
        return IndexFiles.indexFiles(arg);
    }

    // searching docs
    static List search(String keyword) throws Exception {
        String[] arg = new String[2];
        arg[0] = "-query";
        arg[1] = keyword;

        return SearchFiles.searchFiles(arg);
    }
}
