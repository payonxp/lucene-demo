package demo;

public enum RetCode {
    SUCCESS(0),
    ERROR(1);

    int code;
    private RetCode(int code) {
        this.code = code;
    }
}
