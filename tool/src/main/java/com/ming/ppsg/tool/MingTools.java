package com.ming.ppsg.tool;

import com.ming.ppsg.tool.maps.MapTools;
import com.ming.ppsg.tool.string.StringTools;

public class MingTools {

    //Maps工具类
    public static MapTools maps(){
        return MapTools.getInstance();
    }

    //字符串工具类
    public static StringTools string(){
        return StringTools.getInstance();
    }

}
