package com.hae.global.thread;

import java.util.HashMap;

public class GlobalMapThreadLocal {
    private static final MapThreadLocal MAPTHREADLOCAL = new MapThreadLocal();

    public static Object get(String key) {
        return MAPTHREADLOCAL.getHashMap().get(key);
    }

    public static void set(String key, Object value) {
        MAPTHREADLOCAL.getHashMap().put(key, value);
    }

    public static HashMap<String, Object> getHashMap() {
        return MAPTHREADLOCAL.getHashMap();
    }

    public static MapThreadLocal getMapThreadLocal() {
        return MAPTHREADLOCAL;
    }

    public static void remove(String key) {
        MAPTHREADLOCAL.getHashMap().remove(key);
    }

    public static void removeAll() {
        MAPTHREADLOCAL.remove();
    }
}
