package epam.enums;

public enum Language {

    GLOBAL_ENGLISH("Global");

    private String language;

    Language(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
