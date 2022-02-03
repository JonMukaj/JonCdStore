package com.example.joncdstore.model;


public enum GENDER {

    MALE("M", "Male"), FEMALE("F", "Female"),UNSPECIFIED("N","Not Specified");
    private String code;
    private String text;

    GENDER(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public static GENDER getGenderByCode(String code) {
        for (GENDER gender : GENDER.values()) {
            if (gender.code.equals(code)) {
                return gender;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
