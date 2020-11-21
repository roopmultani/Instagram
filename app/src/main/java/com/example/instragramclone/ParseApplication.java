package com.example.instragramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        super.onCreate();
        /*Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("qndWKcJTNNLGNHpg10XVe49lZSuq1CHroHZrn7ox")
                .clientKey("a6PRsyqB2RbSeplB5kw6HAwCl4xs4GonfmL1a426")
                .server("https://parseapi.back4app.com")
                .build()*/

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("qs0TAvpULGhnAoLdswRelQj1RjItW18gjzM8MrVM")
                .clientKey("grzlZI6zetqxEDV9ajT1Brv8XQl0uppTJeHPcnz4")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
