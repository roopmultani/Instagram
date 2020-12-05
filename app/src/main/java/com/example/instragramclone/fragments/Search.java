package com.example.instragramclone.fragments;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Search implements Serializable {

    public String tag;
    public int count;

    public static Search fromJson(JSONObject jsonObject){
        if (jsonObject == null){
            return null;
        }

        Search search = new Search();

        try {
            search.tag = jsonObject.getString("name");
            search.count = jsonObject.getInt("count");

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return search;
    }

    public static List<Search> fromJson(JSONArray jsonArray){
        if (jsonArray == null){
            return null;
        }

        List<Search> searches = new ArrayList<>();
        for (int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObject;

            try {
                jsonObject = jsonArray.getJSONObject(i);

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            Search search = Search.fromJson(jsonObject);
            if (search != null){
                searches.add(search);
            }
        }
        return searches;
    }
}
