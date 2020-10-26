package com.mrep.utils;


public class ValidationRules {

    //validation for mobilenumber
    public static boolean isValidMobileNumber(String number) {
        if (number != null) {
            if (number.startsWith("+91")) {
                number = number.substring(3);
                Debugger.logD("validating number", number);
            }
            if (number.startsWith("0")) {
                number = number.substring(1);
                Debugger.logD("validating number", number);
            }
            if (number.matches("^[1-9]\\d{9}$")) return true;

        }
        return false;
    }

    public static boolean isValidString(String string) {
        if (string != null) {
            string = string.trim();
            if (string.length()==0) {
                return false;
            }else {
                return true;
            }
        }
        return false;
    }



    public  static String NormalizeString(String x,String defaultValue){
        if(x==null){
            return defaultValue;
        }
        return x.trim();
    }

    public static String NormalizeIntegerToString(Integer x, String defaultValue) {
        if (x == null) {
            return defaultValue;
        }
        return x + "";
    }

    public static String correctIndiaNumber(String number) {
        if (!ValidationRules.isValidMobileNumber(number)) {
            return "";
        }
        number = number.replaceAll(" ","");
        if(number.startsWith("0")&& number.length()==11){
            number = number.substring(1);
        }
        if (number.startsWith("+91")) {

        } else {
            number = "+91" + number;
        }
        return number;
    }

    public static int validatePrice(String value, int maxvalue) {
        int price = 0;

        if (isValidString(value)) {
            value = value.trim();
            try {
                price = Integer.parseInt(value);
            } catch (Exception e) {
            } finally {
                if (price > maxvalue) {
                    price = 0;
                }
                return price;
            }
        }
        return price;
    }

    public static Integer validateInteger(String value, Integer defValue) {
        Integer price = defValue;

        if (isValidString(value)) {
            value = value.trim();
            try {
                price = Integer.parseInt(value);
            } catch (Exception e) {
            } finally {

                return price;
            }
        }
        return price;
    }

    public static boolean isValidInteger(Integer value) {
        if (value != null) {
            if (value==0) {
                return false;
            }else {
                return true;
            }
        }
        return false;
    }

    public static Double validateDouble(String value, Double defValue) {
        Double price = defValue;

        if (isValidString(value)) {
            value = value.trim();
            try {
                price = Double.parseDouble(value);
            } catch (Exception e) {
            } finally {

                return price;
            }
        }
        return price;
    }



    public static boolean isValidDouble(Double value) {
        if (value != null) {
            if (value==0.0) {
                return false;
            }else {
                return true;
            }
        }
        return false;
    }

    public static boolean iSValidEmail(String mEmail) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (mEmail != null) {
            if (mEmail.matches(emailPattern))
                return true;
        }
        return false;
    }


    public static boolean isValidLong(Long value) {
        if (value != null) {
            if (value > 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static String NormalizeDoubleToString(Double x, String defaultValue) {
        if (x == null) {
            return defaultValue;
        }
        return x + "";
    }
}
