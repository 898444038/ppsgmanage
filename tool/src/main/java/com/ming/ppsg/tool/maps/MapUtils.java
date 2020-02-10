package com.ming.ppsg.tool.maps;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    private Map<String, Object> map = null;

    public MapUtils createHashMap() {
        map = new HashMap<String,Object>();
        return this;
    }

    public MapUtils put(String key,Object val) {
        map.put(key,val);
        return this;
    }

    public Map<String, Object> getMap() {
        return map;
    }
}
