package statemachine;

public enum Button {


    HEATING3{
        Button nextLevel(){
            return Button.HEATING2;
        }
    },
    HEATING2{
        Button nextLevel(){
            return Button.HEATING1;
        }
    },
    HEATING1{
        Button nextLevel(){
            return Button.TURNOFF_ON;
        }
    },
    TURNOFF_ON{
        Button nextLevel(){
            return Button.HEATING3;
        }
    };
    abstract Button nextLevel();
}
