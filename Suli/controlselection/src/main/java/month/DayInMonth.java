package month;

public class DayInMonth {
    public int numberOfDays(int year, String month) {
        int a = 0;

        String[] months = {"január", "február", "március", "április", "május", "június", "július", "augusztus", "szeptember", "október", "november", "december"};

        switch (month.toLowerCase()) {
            case "január":
                a = 31;
                break;
            case "február":
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    a = 29;
                } else {
                    a = 28;
                }
                break;
            case "március":
                a = 31;
                break;
            case "április":
                a = 30;
                break;
            case "május":
                a = 31;
                break;
            case "június":
                a = 30;
                break;
            case "júlis":
                a = 31;
                break;
            case "augusztus":
                a = 31;
                break;
            case "szeptember":
                a = 30;
                break;
            case "október":
                a = 31;
                break;
            case "november":
                a = 30;
                break;
            case "december":
                a = 31;
                break;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }

//        for (int i = 0; i < months.length; i++) {
//            if (month.toLowerCase() != months[i]) {
//                throw new IllegalArgumentException("Invalid month: " + month);
//            }
//        }


        return a;
    }

    public static void main(String[] args) {
        DayInMonth dim = new DayInMonth();
    }

}
