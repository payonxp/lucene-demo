package demo;

import java.util.List;

public class RestResult {

    public int retCode;
    public List<String> results;

    public RestResult(int retCode, List<String> results) {
        this.retCode = retCode;
        this.results = results;
    }
}
