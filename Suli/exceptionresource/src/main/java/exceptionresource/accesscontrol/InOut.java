package exceptionresource.accesscontrol;

public enum InOut {
    IN("IN"), OUT("OUT");

    String param;

    InOut(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }
}
