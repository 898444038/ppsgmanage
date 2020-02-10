package com.ming.ppsg.tool.string;

public class StringTools {
    private volatile static StringTools instance = null;

    private StringTools(){}

    public static StringTools getInstance(){
        if (instance==null){
            synchronized (StringTools.class){
                if (instance==null){
                    instance = new StringTools();
                }
            }
        }
        return instance;
    }

    public boolean isEmpty(String str){
        return StringUtils.isEmpty(str);
    }

    public boolean isNotEmpty(String str){
        return isEmpty(str);
    }
}
