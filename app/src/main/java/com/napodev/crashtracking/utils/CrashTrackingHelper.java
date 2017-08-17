package com.napodev.crashtracking.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Log;

import org.json.JSONObject;

/**
 * Created by opannapo on 8/18/17.
 */
public class CrashTrackingHelper {
    private static final String TAG = "CrashTrackingHelper";
    private Context context;
    private Thread.UncaughtExceptionHandler androidDefaultUEH;
    private TrackingListener listener;

    private Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(Thread thread, Throwable throwable) {
            JSONObject json = new JSONObject();
            Crash c = new Crash();

            String app = context.getPackageName();
            String name = "";
            String manufacture = "";
            String model = "";
            String version = "";
            String throwableClass = throwable.getClass().getSimpleName();
            String causeClass = throwable.getCause().getClass().getSimpleName();
            String trace = "";
            String traceCause = "";
            String code = "";
            String executorClass = "";
            String executorMethod = "";
            int executorLine = -1;
            StringBuilder stack = new StringBuilder();

            if (throwable.getStackTrace() != null) {
                for (StackTraceElement se : throwable.getStackTrace()) {
                    String s = se.toString();
                    stack.append(s);
                    stack.append("\n");
                    if ("".equals(trace) && s.contains(app)) {
                        trace = s;
                    }
                }
            }
            if (throwable.getCause() != null) {

                executorClass = throwable.getCause().getStackTrace()[0].getFileName();
                executorMethod = throwable.getCause().getStackTrace()[0].getMethodName();
                executorLine = throwable.getCause().getStackTrace()[0].getLineNumber();

                stack.append(throwable.getCause().toString());
                stack.append("\n");
                if (throwable.getCause().getStackTrace() != null) {
                    int i = 0;
                    for (StackTraceElement se : throwable.getCause().getStackTrace()) {
                        Log.i(TAG, i + " " + se.getClassName());

                        String s = se.toString();
                        stack.append(s);
                        stack.append("\n");
                        if ("".equals(trace) && s.contains(app)) {
                            trace = s;
                        }
                        i++;
                    }
                }

                traceCause = throwable.getCause().toString() + " - " + trace;
            }

            try {
                PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                code = "" + info.versionCode;
                name = info.versionName;
                manufacture = Build.MANUFACTURER;
                model = Build.MODEL;
                version = Build.VERSION.RELEASE;
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                json.put("app", app);
                json.put("appCodeVersion", code);
                json.put("appNameVersion", name);
                json.put("deviceManufacture", manufacture);
                json.put("deviceModel", model);
                json.put("osVersion", version);
                json.put("throwableClass", throwableClass);
                json.put("causeClass", causeClass);
                json.put("executorClass", executorClass);
                json.put("executorMethod", executorMethod);
                json.put("executorLine", executorLine);
                json.put("lineStack", trace);
                json.put("codeTraceCause", traceCause);
                json.put("fullTrace", stack.toString());
                json.put("timestamp", System.currentTimeMillis() / 1000);

                c.parse(json);

            } catch (Exception e) {
                e.printStackTrace();
            }

            listener.onCrash(json);
            listener.onCrash(c);
            androidDefaultUEH.uncaughtException(thread, throwable);
        }
    };


    public void init(Context context, TrackingListener listener) {
        this.context = context;
        this.listener = listener;
        androidDefaultUEH = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(handler);
    }
}
