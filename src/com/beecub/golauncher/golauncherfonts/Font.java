package com.beecub.golauncher.golauncherfonts;

public class Font {
    private String name;
    private String license;
    private String author;
    private String link;
    private String typeface;
    
    public Font(String name, String license, String author, String link, String typeface) {
        setName(name);
        setLicense(license);
        setAuthor(author);
        setLink(link);
        setTypeface(typeface);
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
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
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
    public String getTypeface() {
        return typeface;
    }
    public void setTypeface(String typeface) {
        this.typeface = typeface;
    }
}
