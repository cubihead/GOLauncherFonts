package com.android.golauncher.golauncherfonts;

public class Font {
    private String name;
    private String license;
    private String author;
    
    public Font(String name, String license, String author) {
        setName(name);
        setLicense(license);
        setAuthor(author);
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
