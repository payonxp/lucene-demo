package demo;

import java.util.List;

public class RestResult {

    public int retCode;
    public List results;

    public RestResult(int retCode, List results) {
        this.retCode = retCode;
        this.results = results;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public List getResults() {
        return results;
    }

    public void setResults(List results) {
        this.results = results;
    }
}
