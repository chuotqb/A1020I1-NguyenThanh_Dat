package bai19_string_regex.bai_tap.validate_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexNameClass {
private static final String NAME_CLASS_REGEX="^[CAP]\\d{4}[GHIKLM]$";

    public RegexNameClass() {
    }
    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(NAME_CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
