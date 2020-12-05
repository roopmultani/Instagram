package com.example.instragramclone;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

import java.io.Serializable;

@ParseClassName("User")
public class User extends ParseObject {

    public static final String KEY_PROFILE = "profile";

    public ParseFile getProImage(){
        return getParseFile(KEY_PROFILE);
    }

    public void setProImage(ParseFile parseFile) {
        put(KEY_PROFILE, parseFile);
    }
}
