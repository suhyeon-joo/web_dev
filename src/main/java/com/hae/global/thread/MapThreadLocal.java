package com.hae.global.thread;

import java.util.HashMap;

public class MapThreadLocal extends ThreadLocal<HashMap<String, Object>> {

    @Override
    protected HashMap<String, Object> initialValue() {
        return new HashMap<String, Object>();
    }

    public HashMap<String, Object> getHashMap() {
        return this.get();
    }
}
