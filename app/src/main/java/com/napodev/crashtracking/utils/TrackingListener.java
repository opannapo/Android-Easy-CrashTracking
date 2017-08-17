package com.napodev.crashtracking.utils;

import org.json.JSONObject;

/**
 * Created by opannapo on 8/18/17.
 */
public abstract class TrackingListener {
    public void onCrash(JSONObject object) {
    }

    public void onCrash(Crash c) {
    }
}
