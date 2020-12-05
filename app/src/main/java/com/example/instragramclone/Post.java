package com.example.instragramclone;

import android.text.format.DateUtils;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

@ParseClassName("Post")
public class Post extends ParseObject {

    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";
    public static final String KEY_CREATED_KEY = "createdAt";
    public static final String KEY_LIKES = "likes";
    public static final String KEY_COMMENTS = "comments";
    public static final String KEY_PROFILE = "profile";


    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }

    public void setDescription(String description){
        put(KEY_DESCRIPTION, description);
    }

    public String getComments() {
        return getString(KEY_COMMENTS);
    }

    public void setNumComments(String comments){
        put(KEY_COMMENTS, comments);
    }

    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile) {
        put(KEY_IMAGE, parseFile);
    }

    public ParseFile getProImage(){
        return getParseFile(KEY_PROFILE);
    }

    public void setProImage(ParseFile parseFile) {
        put(KEY_PROFILE, parseFile);
    }

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user) {
        put(KEY_USER, user);
    }

    public static String getKeyCreatedKey() {
        return KEY_CREATED_KEY;
    }

    public void setKeyCreatedKey(String createdKey){
        put(KEY_CREATED_KEY, createdKey);
    }

    public JSONArray getLikes() {
        return getJSONArray(KEY_LIKES);
    }

    public int getNumLikes(){
        return getLikes().length();
    }

    public void likePost(ParseUser user){
        add(KEY_LIKES, user);
    }

    public void unlikePost(ParseUser user){
        ArrayList<ParseUser>  list = new ArrayList<>();
        list.add(user);
        removeAll(KEY_LIKES, list);
    }

    public boolean isLike(){
        JSONArray list = getLikes();
        if (list != null){
            for (int i = 0; i < list.length(); i++){
                try {
                    if (list.getJSONObject(i).getString("objectId").equals(ParseUser.getCurrentUser().getObjectId())){
                        return true;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

   /* public static class Query extends ParseQuery<Post>{
        public Query(){
            super(Post.class);
        }

        public Query getTop(){
            setLimit(20);
            return this;
        }

        public Query withUser(){
            include("user");
            return this;
        }
    }*/

    public String getRelativeTimeAgo(String parseDate) {
        String dateFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
        sf.setLenient(true);

        String relativeDate = "";
        try {
            long dateMillis = sf.parse(parseDate).getTime();
            relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
                    System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return relativeDate;
    }
}
