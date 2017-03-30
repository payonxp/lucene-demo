package demo;

public class Demo {
    public static void main(String[] args) {
        search();
    }

    // indexing docs, path hardcoded
    private static void index() {
        String[] arg = new String[2];
        arg[0] = "-docs";
        arg[1] = "/Users/morroc/lucene-6.4.2/docs";
        IndexFiles.indexFiles(arg);
    }

    // searching docs, query string hardcoded
    private static void search() {
        String[] arg = new String[2];
        arg[0] = "-query";
        arg[1] = "demo";
        try {
            SearchFiles.searchFiles(arg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
