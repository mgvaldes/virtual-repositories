package com.tek3.restaurant.models.enums;

/**
 * Created by gaby on 4/17/15.
 */
public enum LanguageOption {
    spanish("Español"),
    english("Inglés");

    private String languageOption;

    private LanguageOption(String languageOption) {
        this.languageOption = languageOption;
    }

    @Override
    public String toString() {
        return languageOption;
    }
}
