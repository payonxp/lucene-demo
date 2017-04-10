package demo;

import com.huaban.analysis.jieba.JiebaSegmenter;

import java.util.List;

public class Demo {
    public static void main(String[] args) throws Exception {
        //index("C:\\Users\\tpeng\\Downloads\\douban_TV");
        search("古装片和动作片");
    }

    // indexing docs, path hardcoded
    public static List index(String path) {
        String[] arg = new String[2];
        arg[0] = "-docs";
        arg[1] = path;
        IndexFiles.indexFiles(arg);
        return null;
    }

    // searching docs, query string hardcoded
    public static List search(String keyword) throws Exception {
        String[] arg = new String[2];
        arg[0] = "-query";
        arg[1] = keyword;
        SearchFiles.searchFiles(arg);
        return null;
    }
}
