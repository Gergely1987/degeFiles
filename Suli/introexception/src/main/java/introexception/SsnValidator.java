package introexception;

public class SsnValidator {
    // private boolean ValidSsn;

    public boolean isValidSsn(String a) {

        int szam = 0;
        int sum = 0;

        boolean result = true;
        try {
            if (a.length() != 9) {
                throw new IllegalArgumentException("Not valid socialSecurityNumber: " + a);

            }
            for (int i = 0; i < a.length() - 1; i++) {
                int b = Integer.parseInt(String.valueOf(a.charAt(i)));
                if (b % 2 == 0) {
                    b = b * 7;
                    sum += b;
                } else {
                    b = b * 3;
                    sum += b;
                }

            }
            szam = sum;
            if (Integer.parseInt(String.valueOf(a.charAt(8))) == sum % 10) {
                result = true;
            } else {
                throw new IllegalArgumentException("Not valid socialSecurityNumber: " + a);

            }

        } catch (IllegalArgumentException iae) {
            result = false;
        } catch (Exception ex) {

        }

        return result;
    }
}
