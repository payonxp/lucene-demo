package demo;

public class Demo {
    public static void main(String[] args) {
        //index();
        search();
    }

    // indexing docs, path hardcoded
    private static void index() {
        String[] arg = new String[2];
        arg[0] = "-docs";
        arg[1] = "/Users/morroc/Downloads/dataset_606647/douban_TV";
        IndexFiles.indexFiles(arg);
    }

    // searching docs, query string hardcoded
    private static void search() {
        String[] arg = new String[2];
        arg[0] = "-query";
        arg[1] = "古装片 动作片";
        try {
            SearchFiles.searchFiles(arg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
