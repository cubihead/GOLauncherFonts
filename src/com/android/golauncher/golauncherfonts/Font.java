package com.android.golauncher.golauncherfonts;

import android.graphics.Typeface;

public class Font {
    private String name;
    private String license;
    private String author;
    private Typeface typeface;
    
    public Font(String name, String license, String author, Typeface typeface) {
        setName(name);
        setLicense(license);
        setAuthor(author);
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
    public void setLicense(String license) {
        this.license = license;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Typeface getTypeface() {
        return typeface;
    }
    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }
}
