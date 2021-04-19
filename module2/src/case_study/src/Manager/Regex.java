package Manager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    // Regex Services
    public static final String ID_REGEX = "^SV(VL|HO|RO)-\\d{4}$";
    public static final String NAMESERVICES_REGEX = "^[A-Z][a-z]*$";
    public static final String STANDARROOM_REGEX = "^[A-Z][a-z]*$";
    public static final String TYPERENT_REGEX = "^[A-Z][a-z]*$";
    public static final String DESCRIPTIONSOTHER_REGEX = "^(massage|karaoke|food|drink|car)$";
    // Regex Customer
    public static final String NAMECUSTOMER_REGEX = "^([A-Z][a-z]*\\s)+[A-Z][a-z]*$";
    public static final String EMAILCUSTOMER_REGEX = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static final String GENDERCUSTOMER_REGEX = "^(Male|Female|Unknow)$";
    public static final String IDCARDCUSTOMER_REGEX = "^[0-9]{3}\\s[0-9]{3}\\s[0-9]{3}$";
    public static final String DAYOFBIRTHCUSTOMER_REGEX = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/(\\d{4})$";

    public static boolean validateServices(String data, String typeCheck){
        switch (typeCheck){
            case "id":
                return data.matches(ID_REGEX);
            case "nameServices":
                return data.matches(NAMESERVICES_REGEX);
            case "typeRent":
                return data.matches(TYPERENT_REGEX);
            case "standarRoom":
                return data.matches(STANDARROOM_REGEX);
            case "decriptionOthers":
                return data.matches(DESCRIPTIONSOTHER_REGEX);
            default:
                return false;

        }

    }
    public static boolean validateCustomer(String data, String typeCheck){
        switch (typeCheck){
            case "nameCustomer":
                return data.matches(NAMECUSTOMER_REGEX);
            case "emailCustomer":
                return data.matches(EMAILCUSTOMER_REGEX);
            case "genderCustomer":
                return data.matches(GENDERCUSTOMER_REGEX);
            case "idCardCustomer":
                return data.matches(IDCARDCUSTOMER_REGEX);
            case "birthdayCustomer":
                return data.matches(DAYOFBIRTHCUSTOMER_REGEX);
            default:
                return false;
        }
    }

}
