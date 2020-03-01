package com.ming.ppsg.tool.generate.utils;

import com.ming.ppsg.tool.generate.entity.Comment;
import com.ming.ppsg.tool.generate.enums.DescType;

import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2019/9/9 0009.
 */
public class GenerateString {

    private static StringBuffer sb = null;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final String semicolon = ";";
    private static final String rn = "\r\n";
    private static final String t1 = "\t";
    private static final String t2 = "\t\t";
    private static final String blank_space1 = " ";

    public GenerateString(){}

    public static GenerateString build(){
        sb = new StringBuffer();
        return new GenerateString();
    }

    public GenerateString append(String str){
        sb.append(str);
        return this;
    }

    public GenerateString appendT(int i){
        for(int j=0;j<i;j++){
            sb.append(t1);
        }
        return this;
    }

    public GenerateString appendRN(){
        sb.append(rn);
        return this;
    }

    public GenerateString appendSRN(){
        sb.append(semicolon+rn);
        return this;
    }

    public GenerateString appendDesc(Comment comment, DescType type, int i){
        appendT(i).append("/**").appendRN();
        appendT(i).append(" * ");
        if(DescType.CLASS.equals(type)){
            append(comment.getDesc());
        }else if(DescType.SELECT.equals(type)){
            append(type.getName());
        }else if(DescType.INSERT.equals(type)){
            append(type.getName());
        }else if(DescType.INSERTBATCH.equals(type)){
            append(type.getName());
        }else if(DescType.UPDATE.equals(type)){
            append(type.getName());
        }else if(DescType.DELETE.equals(type)){
            append(type.getName());
        }
        appendRN();
        appendT(i).append(" * @author: ").append(comment.getAuthor()).appendRN();
        appendT(i).append(" * @date: ").append(sdf.format(comment.getCreateTime())).appendRN();
        appendT(i).append(" */").appendRN();
        return this;
    }

    public GenerateString appendImport(Class... clazzs){
        for(Class clazz : clazzs){
            append("import ").append(clazz.getName()).appendSRN();
        }
        return this;
    }

    public GenerateString appendImport(String... names){
        for(String name : names){
            append("import ").append(name).appendSRN();
        }
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }

    public GenerateString appendPackage(String basePackage,String pack,String baseUrl) {
        append("package ").append(basePackage).append(".").append(pack).append(".").append(baseUrl).appendSRN();
        return this;
    }
}
