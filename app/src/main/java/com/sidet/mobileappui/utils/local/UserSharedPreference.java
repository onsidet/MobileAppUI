package com.sidet.mobileappui.utils.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.sidet.mobileappui.models.User;

public class UserSharedPreference {
    public static void setUser(Context context, User user){
        SharedPreferences.Editor editor = context.getSharedPreferences("USER",Context.MODE_PRIVATE).edit();
        editor.putInt("ID",user.getId());
        editor.putString("USERNAME",user.getUsername());
        editor.putString("PASSWORD",user.getPassword());
        editor.apply();
    }

    public static User getUser(Context context){
        SharedPreferences preferences = context.getSharedPreferences(
                "USER",Context.MODE_PRIVATE
        );
        int id = preferences.getInt("ID",0);
        String username = preferences.getString("USERNAME", "");
        String password = preferences.getString("PASSWORD", "");
        if (!username.equals("")){
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            return user;
        }

        return null;
    }
}
