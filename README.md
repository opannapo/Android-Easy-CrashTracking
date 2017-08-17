# Android-Easy-CrashTracking
Easy to tracking details of errors

## Init (Application Class)
```java
public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();  
        new CrashTrackingHelper().init(this, new TrackingListener() {
            @Override
            public void onCrash(JSONObject object) {
                super.onCrash(object);
                Log.e("APP", "Error " + object.toString());
            }
        }); 
}
```
## callback options
```java
//Multiple Callback
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
```

```java
//POJO
new CrashTrackingHelper().init(this, new TrackingListener() {
            @Override
            public void onCrash(Crash c) {
                super.onCrash(c);
                Log.e("APP", "Error " + c.getCodeStack());
            }
        });
```

```java
//JSON Object
new CrashTrackingHelper().init(this, new TrackingListener() {
            @Override
            public void onCrash(JSONObject object) {
                super.onCrash(object);
                Log.e("APP", "Error " + object.toString());
            }
        });
```



## Result (JSON Callback)
```JSON
{
  "app": "com.napodev.crashtracking",
  "appCodeVersion": "1",
  "appNameVersion": "1.0",
  "deviceManufacture": "samsung",
  "deviceModel": "SM-N9208",
  "osVersion": "6.0.1",
  "throwableClass": "RuntimeException",
  "causeClass": "NullPointerException",
  "executorClass": "MainActivity.java",
  "executorMethod": "onCreate",
  "executorLine": 17,
  "lineStack": "com.napodev.crashtracking.MainActivity.onCreate(MainActivity.java:17)",
  "codeTraceCause": "java.lang.NullPointerException: Attempt to invoke virtual method 'void android.view.View.setVisibility(int)' on a null object reference - com.napodev.crashtracking.MainActivity.onCreate(MainActivity.java:17)",
  "fullTrace": "android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3254)\nandroid.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3350)\nandroid.app.ActivityThread.access$1100(ActivityThread.java:222)\nandroid.app.ActivityThread$H.handleMessage(ActivityThread.java:1795)\nandroid.os.Handler.dispatchMessage(Handler.java:102)\nandroid.os.Looper.loop(Looper.java:158)\nandroid.app.ActivityThread.main(ActivityThread.java:7229)\njava.lang.reflect.Method.invoke(Native Method)\ncom.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1230)\ncom.android.internal.os.ZygoteInit.main(ZygoteInit.java:1120)\njava.lang.NullPointerException: Attempt to invoke virtual method 'void android.view.View.setVisibility(int)' on a null object reference\ncom.napodev.crashtracking.MainActivity.onCreate(MainActivity.java:17)\nandroid.app.Activity.performCreate(Activity.java:6876)\nandroid.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1135)\nandroid.app.ActivityThread.performLaunchActivity(ActivityThread.java:3207)\nandroid.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3350)\nandroid.app.ActivityThread.access$1100(ActivityThread.java:222)\nandroid.app.ActivityThread$H.handleMessage(ActivityThread.java:1795)\nandroid.os.Handler.dispatchMessage(Handler.java:102)\nandroid.os.Looper.loop(Looper.java:158)\nandroid.app.ActivityThread.main(ActivityThread.java:7229)\njava.lang.reflect.Method.invoke(Native Method)\ncom.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1230)\ncom.android.internal.os.ZygoteInit.main(ZygoteInit.java:1120)\n",
  "timestamp": 1503010424
}
```
