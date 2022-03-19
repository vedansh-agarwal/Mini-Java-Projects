package com.vedansh.passwordgenerator;

public class PasswordGenerator {
    private final String lowerAlphabets = "abcdefghijklmnopqrstuvwxyz";
    private final String upperAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String numbers = "0123456789";
    private final String specialCharacters = "@%+/\\'!#$^?:,(){}[]~-_.";
    private String password;
    private String key;

    public PasswordGenerator(String password, String key) {
        this.password = password;
        this.key = key.toLowerCase();
        lengthAdjust();
    }
    private void lengthAdjust() {
        String adjustedLength = "";
        for (int i = 0; i < password.length(); i++)
            adjustedLength += Character.toString(key.charAt(i % key.length()));
        key = adjustedLength;
    }
    public String encryptPassword() {
        String encryptedPassword = "";
        for(int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            int ascii = lowerAlphabets.indexOf(key.charAt(i));
            if(lowerAlphabets.indexOf(ch) != -1) {
                int x = lowerAlphabets.indexOf(ch);
                encryptedPassword += Character.toString(lowerAlphabets.charAt((x+ascii)%26));
            }
            else if(upperAlphabets.indexOf(ch) != -1) {
                int x = upperAlphabets.indexOf(ch);
                encryptedPassword += Character.toString(upperAlphabets.charAt((x+ascii)%26));
            }
            else if(numbers.indexOf(ch) != -1) {
                int x = numbers.indexOf(ch);
                encryptedPassword += Character.toString(numbers.charAt((x+ascii)%10));
            }
            else {
                int x = specialCharacters.indexOf(ch);
                encryptedPassword += Character.toString(specialCharacters.charAt((x+ascii)%23));
            }
        }
        return encryptedPassword;
    }
}

