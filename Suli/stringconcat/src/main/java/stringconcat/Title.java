package stringconcat;

public enum Title {
    MR {
        String stringify() {
            return "Mr.";
        }
    },
    MS {
        String stringify() {
            return "Ms.";
        }
    },
    EMPTY {
        String stringify() {
            return "";
        }
    };

    abstract String stringify();
}
