package com.napodev.crashtracking;

import android.app.Application;
import android.util.Log;

import com.napodev.crashtracking.utils.Crash;
import com.napodev.crashtracking.utils.CrashTrackingHelper;
import com.napodev.crashtracking.utils.TrackingListener;

import org.json.JSONObject;

/**
 * Created by opannapo on 8/18/17.
 */
public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //init CrashTracking

        /*Callback option 1 , return JSON object
        new CrashTrackingHelper().init(this, new TrackingListener() {
            @Override
            public void onCrash(JSONObject object) {
                super.onCrash(object);
                Log.e("APP", "Error " + object.toString());
            }
        });*/


        /*Callback option 2 , return Crash object
        new CrashTrackingHelper().init(this, new TrackingListener() {
            @Override
            public void onCrash(Crash c) {
                super.onCrash(c);
                Log.e("APP", "Error " + c.getCodeStack());
            }
        });*/

        //Callback option 3 , multiple return
        new CrashTrackingHelper().init(this, new TrackingListener() {
            @Override
            public void onCrash(JSONObject object) {
                super.onCrash(object);
                // TODO: 8/18/17  save to local / send to restfull api

                Log.e("APP", "Error JSON " + object.toString());
            }

            @Override
            public void onCrash(Crash c) {
                super.onCrash(c);
                // TODO: 8/18/17  save to local / send to restfull api

                Log.e("APP", "Error Crash Object getThrowableClass " + c.getThrowableClass());
                Log.e("APP", "Error Crash Object getCauseClass " + c.getCauseClass());
                Log.e("APP", "Error Crash Object getLineStack " + c.getLineStack());
            }
        });
    }
}
