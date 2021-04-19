package bai19_string_regex.bai_tap.validate_class;

public class TestNameClass {
    private static RegexNameClass regexNameClass;
    public static final String[] validNameClass = new String[] { "A0318G" };
    public static final String[] invalidNameClass = new String[] { "M0318G", "P0323A" };

    public static void main(String[] args) {
        regexNameClass = new RegexNameClass();
        for (String vl :validNameClass){
            boolean isValid = regexNameClass.validate(vl);
            System.out.println("Name Class is " + vl +" is valid: "+ isValid);
        }
        for (String vl : invalidNameClass) {
            boolean isvalid = regexNameClass.validate(vl);
            System.out.println("Name Class is " + vl +" is valid: "+ isvalid);
        }
    }
}
