package bai19_string_regex.bai_tap.validate_so_dien_thoai;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberRegex {
    private static final String PHONE_NUMBER_REGEX="^\\(\\d{2}\\)\\-\\([0]\\d{9}\\)$";

    public PhoneNumberRegex() {
    }
    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
