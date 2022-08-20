package com.benginio.codepath_instagram;

import android.app.Application;

import com.parse.Parse;

public class ParsesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // set applicationId, and server server based on the values in the back4app settings.
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("72ORMh5LqV6xHHon1N8CXop0emlemSJQeBKULEv2") // should correspond to Application Id env variable
                .clientKey("svnmX29vT1dF2ecZ2RsYoH2e2Kdk2xWc3yXbs1fV")  // should correspond to Client key env variable
                .server("https://parseapi.back4app.com").build());
    }

}
