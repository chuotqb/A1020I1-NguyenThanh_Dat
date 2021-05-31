package common;

public class Validate {
    public static final String ID_CARD_CUSTOMER_REGEX = "^KH-[0-9]{4}";
    public static final String ID_CARD_SERVICE_REGEX = "^DV-[0-9]{4}";
    public static final String PHONE_NUMBER_REGEX = "^((\\(84\\)\\+)|(0))((91)|(90))[\\d]{7}$";
    public static final String CMND_REGEX = "^[0-9]{9}|[0-9]{12}";
    public static final String EMAIL_CUSTOMER_REGEX = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public static String validateIdCard(String idCard) {
        String message = null;

        if (!idCard.matches(ID_CARD_CUSTOMER_REGEX)) {
            message = "Not OK. Id Card invalid";
        }
        return message;
    }

    public static String validatePhone(String phone) {
        String message = null;

        if (!phone.matches(PHONE_NUMBER_REGEX)) {
            message = "Not OK. Phone invalid";
        }
        return message;
    }

    public static String validateCmnd(String cmnd) {
        String message = null;

        if (!cmnd.matches(CMND_REGEX)) {
            message = "Not OK. Cmnd invalid";
        }
        return message;
    }

    public static String validateEmail(String email) {
        String message = null;

        if (!email.matches(EMAIL_CUSTOMER_REGEX)) {
            message = "Not OK. Email invalid";
        }
        return message;
    }
}
