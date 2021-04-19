package bai19_string_regex.bai_tap.validate_so_dien_thoai;

public class TestPhoneNumberRegex {
    private static PhoneNumberRegex phoneNumberRegex;
    public static final String[] validPhoneNumber = new String[] { "(84)-(0978889648)" };
    public static final String[] invalidPhoneNumber = new String[] { "(a8)-(22222222)" };

    public static void main(String[] args) {
        phoneNumberRegex = new PhoneNumberRegex();
        for (String vl:validPhoneNumber){
            boolean isValid = phoneNumberRegex.validate(vl);
            System.out.println("Phone Number is " + vl +" is valid: "+ isValid);
        }
        for (String vl:invalidPhoneNumber){
            boolean isValid = phoneNumberRegex.validate(vl);
            System.out.println("Phone Number is " + vl +" is valid: "+ isValid);
        }
    }
}
