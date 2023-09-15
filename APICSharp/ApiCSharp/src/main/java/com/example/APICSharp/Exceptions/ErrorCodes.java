package com.example.APICSharp.Exceptions;

public enum ErrorCodes {

    PERSONNE_NOT_FOUND(1000),
    PERSONNE_NOT_VALID(1001),
    ARTICLE_NOT_FOUND(2000),
    ARTICLE_NOT_VALID(2001),
    CONFERENCE_NOT_FOUND(3000),
    CONFERENCE_NOT_VALID(3001)
    ;

    private int id;
    ErrorCodes(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }
}
