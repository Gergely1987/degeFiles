package stringbuilder;

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
    DR{
        String stringify(){
            return "Dr.";
        }
    },
    PROF{
        String stringify(){
            return "Prof.";
        }
    },
    EMPTY
            {
                String stringify() {
                    return "";
                }
            };
abstract String stringify();
}

