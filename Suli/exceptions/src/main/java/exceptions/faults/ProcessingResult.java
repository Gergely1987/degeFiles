package exceptions.faults;

public enum ProcessingResult {

    NO_ERROR("NO_ERROR"),

    COMMENT("COMMENT"),

    WORD_COUNT_ERROR("WORD_COUNT_ERROR"),

    VALUE_ERROR("VALUE_ERROR"),

    DATE_ERROR("DATE_ERROR"),

    VALUE_AND_DATE_ERROR("VALUE_AND_DATE_ERROR");

    private String code;

    private ProcessingResult(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
