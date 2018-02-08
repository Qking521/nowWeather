package com.king.weather;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

/**
 * Created by wangqiang on 2018/1/25.
 */

public class ResolvedInfo {
    private String title;
    private String summary;
    private Drawable icon;
    private Class clazz;
    private Bundle bundle;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
