package com.ming.ppsg.tool.maps;

import com.ming.ppsg.tool.string.StringUtils;

import java.util.Map;

public class MapTools {

    private volatile static MapTools instance = null;

    private MapTools(){}

    public static MapTools getInstance(){
        if (instance==null){
            synchronized (MapTools.class){
                if (instance==null){
                    instance = new MapTools();
                }
            }
        }
        return instance;
    }

    public MapUtils createHashMap(){
        MapUtils mapUtils = new MapUtils();
        return mapUtils.createHashMap();
    }
}
