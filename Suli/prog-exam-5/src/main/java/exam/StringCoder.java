package exam;

public class StringCoder {

    public String encode(String s) {
        if (s == null) {
            throw new NullPointerException();
        }

        if (s.length()==0) {
            return "";
        }

        int counter = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length()-1 ; i++) {
            if (s.charAt(i) == s.charAt(i +1)) {
                counter++;
            } else {
                sb.append(counter);
                sb.append(s.charAt(i));
                counter=1;
            }
        }
        sb.append(counter);
        sb.append(s.charAt(s.length()-1));
        String result = sb.toString();
        return result;
    }

    public static void main(String[] args) {
        StringCoder sc = new StringCoder();
        System.out.println(sc.encode("aalma"));
    }
}
