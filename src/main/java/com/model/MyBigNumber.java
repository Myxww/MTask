package com.model;

public class MyBigNumber {

    public static String sum(String stn1, String stn2) {
        stn1 = stn1.replaceAll("\\s", "");
        stn2 = stn2.replaceAll("\\s", "");

        if ((isNumber(stn1, stn2) == true) || (stn1.isEmpty()) || (stn2.isEmpty())) {
            boolean neg1 = false;
            boolean neg2 = false;
            String forresutlt = "";
            StringBuilder result = new StringBuilder();

            if (stn1.startsWith("-")) {
                neg1 = true;
            }
            if (stn2.startsWith("-")) {
                neg2 = true;
            }
            if (stn1.isEmpty()) {
                stn1 = "0";
            }

            if (stn2.isEmpty()) {
                stn2 = "0";
            }
            if (neg1 == true) {
                stn1 = stn1.substring(1);
            }
            if (neg2 == true) {

                stn2 = stn2.substring(1);

            }

            if ((neg1 == neg2)) {
                result = Samesym(stn1, stn2, neg1, neg2);

                String tostrresult = result.toString();
                forresutlt = FoString(tostrresult);

            } else {
                boolean isNegResult = false;

                if (stn1.length() > stn2.length()) {
                    if (neg1 == true) {
                        isNegResult = true;
                    }
                    result = Stn1BStn2(stn1, stn2, neg1, neg2);

                    String tostrresult = result.toString();
                    forresutlt = FoString(tostrresult);
                    if (isNegResult == true) {
                        forresutlt = "-" + forresutlt;
                    }

                } else if (stn2.length() > stn1.length()) {
                    if (neg2 == true) {
                        isNegResult = true;
                    }
                    result = Stn2BStn1(stn1, stn2, neg1, neg2);

                    String tostrresult = result.toString();
                    forresutlt = FoString(tostrresult);
                    if (isNegResult == true) {
                        forresutlt = "-" + forresutlt;
                    }
                } else {
                    if (stn1.compareTo(stn2) > 0) {
                        result = Stn1SBStn2(stn1, stn2, neg1, neg2);

                        String tostrresult = result.toString();
                        forresutlt = FoString(tostrresult);
                        if (neg1 == true) {
                            forresutlt = "-" + forresutlt;
                        }

                    } else if (stn1.compareTo(stn2) < 0) {
                        result = Stn2SBStn1(stn1, stn2, neg1, neg2);

                        String tostrresult = result.toString();
                        forresutlt = FoString(tostrresult);
                        if (neg2 == true) {

                            forresutlt = "-" + forresutlt;

                        }

                    } else {
                        forresutlt = "0";

                    }
                }

            }

            neg1 = false;
            neg2 = false;

            if (forresutlt.isEmpty() || forresutlt == "-" || forresutlt == "+") {
                return "0";
            }
            return forresutlt;
        } else {
            return "Invalid Input";
        }
    }

    private static String FoString(String resultF) {
        return resultF.replaceFirst("^0+", "");
    }

    private static StringBuilder Samesym(String stn1, String stn2, Boolean neg1, Boolean neg2) {
        StringBuilder result = new StringBuilder();
        int length1 = stn1.length();
        int length2 = stn2.length();
        int maxLength = Math.max(length1, length2);
        int carry = 0;

        for (int i = 0; i < maxLength; i++) {
            int digit1 = getDigit(stn1, length1 - i - 1);
            int digit2 = getDigit(stn2, length2 - i - 1);

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            int digitSum = sum % 10;

            result.insert(0, digitSum);

        }

        if (neg1 == false) {
            result.insert(0, carry);
        } else {
            result.insert(0, "-");
        }
        return result;
    }

    private static StringBuilder Stn1BStn2(String stn1, String stn2, Boolean neg1, Boolean neg2) {
        StringBuilder result = new StringBuilder();

        boolean borrow = false;

        for (int i = 0; i < stn1.length(); i++) {
            int digit1 = getDigit(stn1, stn1.length() - i - 1);
            int digit2 = getDigit(stn2, stn2.length() - i - 1);
            if (borrow == true) {
                digit1 = digit1 - 1;

            }
            borrow = false;
            if (digit1 < digit2) {
                result.insert(0, digit1 + 10 - digit2);
                borrow = true;

            } else {
                result.insert(0, digit1 - digit2);
            }

        }
        return result;
    }

    private static StringBuilder Stn2BStn1(String stn1, String stn2, Boolean neg1, Boolean neg2) {
        StringBuilder result = new StringBuilder();

        boolean borrow = false;

        for (int i = 0; i < stn2.length(); i++) {
            int digit1 = getDigit(stn1, stn1.length() - i - 1);
            int digit2 = getDigit(stn2, stn2.length() - i - 1);
            if (borrow == true) {
                digit2 = digit2 - 1;
            }
            borrow = false;
            if (digit2 < digit1) {
                result.insert(0, digit2 + 10 - digit1);
                borrow = true;

            } else {
                result.insert(0, digit2 - digit1);
            }

        }
        return result;

    }

    private static StringBuilder Stn1SBStn2(String stn1, String stn2, Boolean neg1, Boolean neg2) {
        StringBuilder result = new StringBuilder();
        boolean borrow = false;

        for (int i = 0; i < stn1.length(); i++) {
            int digit1 = getDigit(stn1, stn1.length() - i - 1);
            int digit2 = getDigit(stn2, stn2.length() - i - 1);
            if (borrow == true) {
                digit1 = digit1 - 1;

            }
            borrow = false;
            if (digit1 < digit2) {
                result.insert(0, digit1 + 10 - digit2);
                borrow = true;

            } else {
                result.insert(0, digit1 - digit2);
            }

        }
        return result;
    }

    private static StringBuilder Stn2SBStn1(String stn1, String stn2, Boolean neg1, Boolean neg2) {
        StringBuilder result = new StringBuilder();
        boolean borrow = false;
        for (int i = 0; i < stn1.length(); i++) {
            int digit1 = getDigit(stn1, stn1.length() - i - 1);
            int digit2 = getDigit(stn2, stn2.length() - i - 1);
            if (borrow == true) {
                digit2 = digit2 - 1;

            }
            borrow = false;
            if (digit2 < digit1) {
                result.insert(0, digit2 + 10 - digit1);
                borrow = true;

            } else {
                result.insert(0, digit2 - digit1);
            }

        }
        return result;

    }

    private static int getDigit(String number, int index) {
        if (index >= 0 && index < number.length()) {
            char ch = number.charAt(index);
            if (Character.isDigit(ch)) {
                return Character.getNumericValue(ch);
            }
        }
        return 0;
    }

    private static boolean isNumber(String st1, String st2) {

        if (st1.matches("[+-]?[0-9]+") && st2.matches("[+-]?[0-9]+")) {
            return true;
        }
        return false;
    }

}
