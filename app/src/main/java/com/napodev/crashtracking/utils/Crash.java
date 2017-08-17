package com.napodev.crashtracking.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by opannapo on 8/18/17.
 */
public class Crash {
    private String app;
    private String appCodeVersion;
    private String appNameVersion;
    private String deviceManufacture;
    private String deviceModel;
    private String osVersion;
    private String throwableClass;
    private String causeClass;
    private String executorClass;
    private String executorMethod;
    private int executorLine;
    private int timestamp;
    private String lineStack;
    private String codeTraceCause;
    private String fullTrace;


    public Crash parse(JSONObject o) throws JSONException {
        setApp(o.getString("app"));
        setAppCodeVersion(o.getString("appCodeVersion"));
        setAppNameVersion(o.getString("appNameVersion"));
        setDeviceManufacture(o.getString("deviceManufacture"));
        setDeviceModel(o.getString("deviceModel"));
        setOsVersion(o.getString("osVersion"));
        setThrowableClass(o.getString("throwableClass"));
        setCauseClass(o.getString("causeClass"));
        setLineStack(o.getString("lineStack"));
        setCodeTraceCause(o.getString("codeTraceCause"));
        setExecutorClass(o.getString("executorClass"));
        setExecutorMethod(o.getString("executorMethod"));
        setExecutorLine(o.getInt("executorLine"));
        setTimestamp(o.getInt("timestamp"));
        return this;
    }


    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getAppCodeVersion() {
        return appCodeVersion;
    }

    public void setAppCodeVersion(String appCodeVersion) {
        this.appCodeVersion = appCodeVersion;
    }

    public String getAppNameVersion() {
        return appNameVersion;
    }

    public void setAppNameVersion(String appNameVersion) {
        this.appNameVersion = appNameVersion;
    }

    public String getDeviceManufacture() {
        return deviceManufacture;
    }

    public void setDeviceManufacture(String deviceManufacture) {
        this.deviceManufacture = deviceManufacture;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getThrowableClass() {
        return throwableClass;
    }

    public void setThrowableClass(String throwableClass) {
        this.throwableClass = throwableClass;
    }

    public String getCauseClass() {
        return causeClass;
    }

    public void setCauseClass(String causeClass) {
        this.causeClass = causeClass;
    }

    public String getLineStack() {
        return lineStack;
    }

    public void setLineStack(String lineStack) {
        this.lineStack = lineStack;
    }

    public String getCodeTraceCause() {
        return codeTraceCause;
    }

    public void setCodeTraceCause(String codeTraceCause) {
        this.codeTraceCause = codeTraceCause;
    }

    public String getFullTrace() {
        return fullTrace;
    }

    public void setFullTrace(String fullTrace) {
        this.fullTrace = fullTrace;
    }

    public String getExecutorClass() {
        return executorClass;
    }

    public void setExecutorClass(String executorClass) {
        this.executorClass = executorClass;
    }

    public String getExecutorMethod() {
        return executorMethod;
    }

    public void setExecutorMethod(String executorMethod) {
        this.executorMethod = executorMethod;
    }

    public int getExecutorLine() {
        return executorLine;
    }

    public void setExecutorLine(int executorLine) {
        this.executorLine = executorLine;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}
