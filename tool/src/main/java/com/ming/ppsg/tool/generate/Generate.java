package com.ming.ppsg.tool.generate;

import com.ming.ppsg.tool.generate.entity.ClassField;
import com.ming.ppsg.tool.generate.entity.Comment;
import com.ming.ppsg.tool.generate.entity.GenerateInfo;
import com.ming.ppsg.tool.generate.enums.DescType;
import com.ming.ppsg.tool.generate.utils.GenerateString;
import com.ming.ppsg.tool.generate.utils.GenerateUtil;
import com.ming.ppsg.tool.generate.utils.Scanner;
import com.ming.ppsg.tool.io.FileUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2019/9/5 0005.
 */
public class Generate {
    private volatile static Generate generate = null;
    private Generate(){}
    public static Generate getInstance()   {
        if (generate == null)  {
            synchronized (Generate.class) {
                if (generate== null)  {
                    generate= new Generate();
                }
            }
        }
        return generate;
    }

    private static final String rn = "\r\n";
    private static final String t1 = "\t";
    private static final String t2 = "\t\t";
    private static final String blank_space1 = " ";


    public void generateVo(GenerateInfo info){
        GenerateString gs = GenerateString.build();
        gs.appendPackage(info.getBasePackage(),info.getVoPackage(),info.getBaseUrl()).appendRN();
        gs.appendImport(info.getCls()).appendRN();
        gs.append("public class "+info.getVoName()+" extends "+info.getEntityName()+" {").appendRN().appendRN();
        gs.append("}");
        createFile(info.getVoAbsolutePath(),gs.toString());
    }

    public void generateController(GenerateInfo info){
        GenerateString gs = GenerateString.build();
        gs.appendPackage(info.getBasePackage(),info.getControllerPackage(),info.getBaseUrl()).appendRN();

        gs.appendImport(List.class,Resource.class);
        gs.appendImport("com.ming.ppsg.tool.http.HttpResult");
        gs.appendImport("org.springframework.web.bind.annotation.PostMapping");
        gs.appendImport("org.springframework.web.bind.annotation.RequestBody");
        gs.appendImport("org.springframework.web.bind.annotation.RequestMapping");
        gs.appendImport("org.springframework.web.bind.annotation.RestController");
        gs.appendImport(info.getEntityPackagePath()+"."+info.getEntityName());
        gs.appendImport(info.getServicePackagePath()+"."+info.getServiceName());
        gs.appendImport(info.getVoPackagePath()+"."+info.getVoName());
        gs.appendRN();

        gs.appendDesc(info.getComment(), DescType.CLASS,0);
        gs.append("@RestController").appendRN();
        gs.append("@RequestMapping(\""+info.getClassMapping()+"\")").appendRN();
        gs.append("public class ").append(info.getControllerName()).append(" {").appendRN().appendRN();

        gs.appendT(1).append("@Resource").appendRN();
        gs.appendT(1).append("private "+info.getServiceName()+" "+info.getServiceLowerName()+";").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.SELECT,1);
        gs.appendT(1).append("@PostMapping(\"/select\")").appendRN();
        gs.appendT(1).append("public HttpResult select(").append("@RequestBody "+info.getVoName()+" "+info.getVoLowerName()).append("){").appendRN();
        gs.appendT(2).append("List<"+info.getEntityName()+"> list = "+ info.getServiceLowerName()+".select("+ info.getVoLowerName()+")").appendSRN();
        gs.appendT(2).append("return HttpResult.ok(list)").appendSRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.INSERT,1);
        gs.appendT(1).append("@PostMapping(\"/insert\")").appendRN();
        gs.appendT(1).append("public HttpResult insert(").append("@RequestBody "+info.getVoName()+" "+info.getVoLowerName()).append("){").appendRN();
        gs.appendT(2).append("int i = "+ info.getServiceLowerName()+".insert("+ info.getVoLowerName()+")").appendSRN();
        gs.appendT(2).append("return HttpResult.judge(i)").appendSRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.UPDATE,1);
        gs.appendT(1).append("@PostMapping(\"/update\")").appendRN();
        gs.appendT(1).append("public HttpResult update(").append("@RequestBody "+info.getVoName()+" "+info.getVoLowerName()).append("){").appendRN();
        gs.appendT(2).append("if("+info.getVoLowerName()+".getId() == null){").appendRN();
        gs.appendT(3).append("return HttpResult.error();").appendRN();
        gs.appendT(2).append("}").appendRN();
        gs.appendT(2).append("int i = "+ info.getServiceLowerName()+".update("+ info.getVoLowerName()+")").appendSRN();
        gs.appendT(2).append("return HttpResult.judge(i)").appendSRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.DELETE,1);
        gs.appendT(1).append("@PostMapping(\"/delete\")").appendRN();
        gs.appendT(1).append("public HttpResult delete(").append("@RequestBody "+info.getVoName()+" "+info.getVoLowerName()).append("){").appendRN();
        gs.appendT(2).append("if("+info.getVoLowerName()+".getId() == null){").appendRN();
        gs.appendT(3).append("return HttpResult.error();").appendRN();
        gs.appendT(2).append("}").appendRN();
        gs.appendT(2).append("int i = "+ info.getServiceLowerName()+".delete("+ info.getVoLowerName()+")").appendSRN();
        gs.appendT(2).append("return HttpResult.judge(i)").appendSRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.append("}");

        createFile(info.getControllerAbsolutePath(),gs.toString());
    }

    public void generateService(GenerateInfo info){
        GenerateString gs = GenerateString.build();
        gs.appendPackage(info.getBasePackage(),info.getServicePackage(),info.getBaseUrl()).appendRN();

        gs.appendImport(List.class);
        gs.appendImport(info.getEntityPackagePath()+"."+info.getEntityName());
        gs.appendImport(info.getVoPackagePath()+"."+info.getVoName());
        gs.appendRN();

        gs.appendDesc(info.getComment(), DescType.CLASS,0);
        gs.append("public interface ").append(info.getServiceName()).append(" {").appendRN().appendRN();;
        gs.appendDesc(info.getComment(), DescType.SELECT,1);
        gs.appendT(1).append("List<").append(info.getEntityName()).append("> select(").append(info.getVoName()+" "+info.getVoLowerName()).append(")").appendSRN().appendRN();;
        gs.appendDesc(info.getComment(), DescType.INSERT,1);
        gs.appendT(1).append("int insert(").append(info.getVoName()+" "+info.getVoLowerName()).append(")").appendSRN().appendRN();;
        gs.appendDesc(info.getComment(), DescType.UPDATE,1);
        gs.appendT(1).append("int update(").append(info.getVoName()+" "+info.getVoLowerName()).append(")").appendSRN().appendRN();;
        gs.appendDesc(info.getComment(), DescType.DELETE,1);
        gs.appendT(1).append("int delete(").append(info.getVoName()+" "+info.getVoLowerName()).append(")").appendSRN().appendRN();;
        gs.append("}");

        createFile(info.getServiceAbsolutePath(),gs.toString());
    }

    public void generateServiceImpl(GenerateInfo info){
        GenerateString gs = GenerateString.build();
        gs.appendPackage(info.getBasePackage(),info.getServicePackage()+"."+info.getServiceImplPackage(),info.getBaseUrl()).appendRN();

        gs.appendImport(List.class, Resource.class);
        gs.appendImport(info.getEntityPackagePath()+"."+info.getEntityName());
        gs.appendImport(info.getVoPackagePath()+"."+info.getVoName());
        gs.appendImport(info.getServicePackagePath()+"."+info.getServiceName());
        gs.appendImport(info.getMapperPackagePath()+"."+info.getMapperName());
        gs.appendImport("org.springframework.stereotype.Service");
        gs.appendRN();

        gs.appendDesc(info.getComment(), DescType.CLASS,0);
        gs.append("@Service").appendRN();
        gs.append("public class ").append(info.getServiceImplName()).append(" implements ").append(info.getServiceName()).append(" {").appendRN().appendRN();

        gs.appendT(1).append("@Resource").appendRN();
        gs.appendT(1).append("private ").append(info.getMapperName()).append(" ").append(info.getMapperLowerName()).append(";").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.SELECT,1);
        gs.appendT(1).append("@Override").appendRN();
        gs.appendT(1).append("public List<").append(info.getEntityName()).append("> select(").append(info.getVoName()+" "+info.getVoLowerName()).append("){").appendRN();
        gs.appendT(2).append("return ").append(info.getMapperLowerName()).append(".select("+info.getVoLowerName()+");").appendRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.INSERT,1);
        gs.appendT(1).append("@Override").appendRN();
        gs.appendT(1).append("public int insert(").append(info.getVoName()+" "+info.getVoLowerName()).append("){").appendRN();
        gs.appendT(2).append("return ").append(info.getMapperLowerName()).append(".insert("+info.getVoLowerName()+");").appendRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.UPDATE,1);
        gs.appendT(1).append("@Override").appendRN();
        gs.appendT(1).append("public int update(").append(info.getVoName()+" "+info.getVoLowerName()).append("){").appendRN();
        gs.appendT(2).append("return ").append(info.getMapperLowerName()).append(".update("+info.getVoLowerName()+");").appendRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.DELETE,1);
        gs.appendT(1).append("@Override").appendRN();
        gs.appendT(1).append("public int delete(").append(info.getVoName()+" "+info.getVoLowerName()).append("){").appendRN();
        gs.appendT(2).append("return ").append(info.getMapperLowerName()).append(".delete("+info.getVoLowerName()+");").appendRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.append("}");

        createFile(info.getServiceImplAbsolutePath(),gs.toString());
    }

    public void generateEntity(String entityName, List<ClassField> list, Comment comment){
        /*GenerateString gs = GenerateString.build();
        gs.appendImport(Serializable.class);
        gs.appendDesc(comment, DescType.CLASS,0);

        gs.append("public class ").append(entityName).append(" implements Serializable {").appendRN();
        gs.appendT(1).append("private static final long serialVersionUID = 1L;").appendRN();

        for(ClassField classField : list){
            String field = classField.getFieldName();
            String fieldUp = GenerateUtil.firstUpperCase(field);
            String type = classField.getFieldType();
            gs.appendT(1).append("private ").append(type).append(" "+field).appendSRN();
            gs.appendT(1).append("private "+type+" get"+fieldUp+"(){return "+field+";}").appendRN();
            gs.appendT(1).append("private void set"+fieldUp+"("+type+" "+field+"){this."+field+"="+field+";}").appendRN();
        }*/
    }

    public void generateMapper(GenerateInfo info){
        GenerateString gs = GenerateString.build();
        gs.appendPackage(info.getBasePackage(),info.getMapperPackage(),info.getBaseUrl()).appendRN();

        gs.appendImport(List.class);
        gs.appendImport("org.apache.ibatis.annotations.Mapper");
        gs.appendImport(info.getEntityPackagePath()+"."+info.getEntityName());
        gs.appendImport(info.getVoPackagePath()+"."+info.getVoName());
        gs.appendRN();

        gs.appendDesc(info.getComment(), DescType.CLASS,0);
        gs.append("@Mapper").appendRN();
        gs.append("public interface ").append(info.getMapperName()).append(" {").appendRN().appendRN();
        gs.appendDesc(info.getComment(), DescType.SELECT,1);
        gs.appendT(1).append("List<").append(info.getEntityName()).append("> select(").append(info.getVoName()+" "+info.getVoLowerName()+")").appendSRN().appendRN();
        gs.appendDesc(info.getComment(), DescType.INSERT,1);
        gs.appendT(1).append("int insert("+info.getVoName()+" "+info.getVoLowerName()+")").appendSRN().appendRN();
        gs.appendDesc(info.getComment(), DescType.UPDATE,1);
        gs.appendT(1).append("int update("+info.getVoName()+" "+info.getVoLowerName()+")").appendSRN().appendRN();
        gs.appendDesc(info.getComment(), DescType.DELETE,1);
        gs.appendT(1).append("int delete("+info.getVoName()+" "+info.getVoLowerName()+")").appendSRN().appendRN();
        gs.append("}").appendRN();
        createFile(info.getMapperAbsolutePath(),gs.toString());
    }

    public void generateMapperXml(GenerateInfo info){
        String entityClassName = info.getEntityPackagePath()+"."+info.getEntityName();
        String tableName = info.getTableName();
        String mapperClassName = info.getMapperPackagePath()+"."+info.getMapperName();
        List<ClassField> classFieldList = GenerateUtil.getFieldList(info.getCls());
        List<String> columnList = new ArrayList<String>();

        GenerateString gs = GenerateString.build();
        gs.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").appendRN();
        gs.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">").appendRN();
        gs.append("<mapper namespace=\""+mapperClassName+"\">").appendRN().appendRN();

        gs.appendT(1).append("<resultMap id=\"baseResultMap\" type=\""+entityClassName+"\">").appendRN();
        for(ClassField classField : classFieldList){
            String column = classField.getFieldColumn();
            columnList.add(column);
            gs.appendT(2).append("<result column=\""+column+"\" property=\""+classField.getFieldName()+"\" jdbcType=\"" + classField.getJdbcType() + "\" />").appendRN();
        }
        gs.appendT(1).append("</resultMap>").appendRN().appendRN();

        gs.appendT(1).append("<sql id=\"baseColumn\">").appendRN();
        for(int i=0;i<columnList.size();i++){
            gs.appendT(2).append(columnList.get(i));
            if(i!=columnList.size()-1){
                gs.append(",");
            }
            gs.appendRN();
        }
        gs.appendT(1).append("</sql>").appendRN().appendRN();

        gs.appendT(1).append("<sql id=\"baseCondition\">").appendRN();
        gs.appendT(2).append("<where>").appendRN();
        for(ClassField classField : classFieldList){
            String column = classField.getFieldColumn();
            String fieldName = classField.getFieldName();
            gs.appendT(3).append("<if test=\""+fieldName+" != null\">and "+column+" = #{"+fieldName+"}</if>").appendRN();
        }
        gs.appendT(2).append("</where>").appendRN();
        gs.appendT(1).append("</sql>").appendRN().appendRN();

        // select
        gs.appendT(1).append("<select id=\"select\" resultMap=\"baseResultMap\" parameterType=\""+entityClassName+"\">").appendRN();
        gs.appendT(2).append("SELECT <include refid=\"baseColumn\"></include> ").appendRN();
        gs.appendT(2).append("from ").append(tableName).appendRN();
        gs.appendT(2).append("<include refid=\"baseCondition\"></include>").appendRN();
        gs.appendT(1).append("</select>").appendRN().appendRN();

        // insert
        gs.appendT(1).append("<insert id=\"insert\" parameterType=\""+entityClassName+"\">").appendRN();
        gs.appendT(2).append("insert into ").append(tableName).appendRN();
        gs.appendT(2).append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" >").appendRN();
        for(ClassField classField : classFieldList) {
            gs.appendT(3).append("<if test=\""+classField.getFieldName()+" != null\">"+classField.getFieldColumn()+",</if>").appendRN();
        }
        gs.appendT(2).append("</trim>").appendRN();

        gs.appendT(2).append("<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >").appendRN();
        for(ClassField classField : classFieldList) {
            gs.appendT(3).append("<if test=\""+classField.getFieldName()+" != null\">#{"+classField.getFieldName()+"},</if>").appendRN();
        }
        gs.appendT(2).append("</trim>").appendRN();
        gs.appendT(1).append("</insert>").appendRN().appendRN();

        //update
        gs.appendT(1).append("<update id=\"update\" parameterType=\""+entityClassName+"\">").appendRN();
        gs.appendT(2).append("update ").append(tableName).appendRN();
        gs.appendT(2).append("<set>").appendRN();
        for(ClassField classField : classFieldList){
            String property = classField.getFieldName();
            String column = classField.getFieldColumn();
            gs.appendT(3).append("<if test=\""+property+" != null\">"+column+" = #{"+property+"},</if>").appendRN();
        }
        gs.appendT(2).append("</set>").appendRN();
        gs.appendT(2).append("where id = #{id}").appendRN();
        gs.appendT(1).append("</update>").appendRN().appendRN();

        //delete
        gs.appendT(1).append("<delete id=\"delete\" parameterType=\""+entityClassName+"\">").appendRN();
        gs.appendT(2).append("delete from ").append(tableName).appendRN();
        gs.appendT(2).append("where id = #{id} ").appendRN();
        gs.appendT(1).append("</delete>").appendRN().appendRN();

        gs.append("</mapper>").appendRN();

        createFile(info.getMapperXmlAbsolutePath(),gs.toString());
    }

    /**
     CREATE TABLE `s_permission` (
     `id` bigint(11) NOT NULL AUTO_INCREMENT,
     `url` varchar(255) NOT NULL,
     `name` varchar(64) NOT NULL,
     `description` varchar(64) DEFAULT NULL,
     `pid` bigint(11) NOT NULL,
     `icon` varchar(64) DEFAULT NULL,
     `is_open` tinyint(1) DEFAULT '0' COMMENT '1:打开 0：关闭',
     `type` tinyint(1) DEFAULT NULL COMMENT '0:菜单 1：功能',
     PRIMARY KEY (`id`)
     ) ENGINE=MyISAM AUTO_INCREMENT=20003 DEFAULT CHARSET=utf8;
     */
    public void generateCreateSql(GenerateInfo info){
        String tableName = info.getTableName();
        Class clazz = info.getCls();

        GenerateString gs = GenerateString.build();
        gs.append("CREATE TABLE `").append(tableName).append("` (").appendRN();
        List<ClassField> classFieldList = GenerateUtil.getFieldList(clazz);
        for(ClassField field : classFieldList){
            gs.append("`"+field.getFieldColumn()+"` ").append(field.getJdbcType())
                    .append(field.getLength()+" ");
            if(field.getPrimaryKey()){
                gs.append(" NOT NULL AUTO_INCREMENT ");
            }else{
                gs.append(" DEFAULT NULL ");
            }
            if(field.getComment()!=null){
                gs.append(" COMMENT '").append(field.getComment()).append("'");
            }
            gs.append(",").appendRN();
        }
        for(ClassField field : classFieldList) {
            if(field.getPrimaryKey()){
                gs.append("PRIMARY KEY (`").append(field.getFieldColumn()).append("`)").appendRN();
            }
        }
        gs.append(")").append("ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8").appendSRN();
        createFile(info.getSqlAbsolutePath(),gs.toString());
    }

    private void createFile(String filePath,String content){
        String filedo = FileUtils.fileLinesWrite(filePath,content,false,false);
        System.out.println(filedo+" ["+filePath + "] success!");
    }

    public void create(String[] paths) throws Exception {
        Scanner scanner = new Scanner();
        Set<Class<?>> classSet = new HashSet<>();
        for (String path : paths){
            classSet.addAll(scanner.getGenerateMybatis(path));
        }
        for (Class<?> cls : classSet) {
            GenerateInfo info = new GenerateInfo();
            info.setComment(GenerateUtil.getComment(cls));
            info.setCls(cls);
            info.setClassMapping(GenerateUtil.getClassMapping(cls));
            info.setTableName(GenerateUtil.getTableName(cls));
            info.setBaseUrl(GenerateUtil.getBaseUrl(cls));
            info.setBasePackage(paths[0]);
            String entityClassName = GenerateUtil.getClassName(cls);
            info.setEntityName(entityClassName);
            String lowerEntityClassName = GenerateUtil.firstLowerCase(entityClassName);
            info.setEntityLowerName(lowerEntityClassName);

            generateVo(info);
            generateController(info);
            generateService(info);
            generateServiceImpl(info);
            generateMapper(info);
            generateMapperXml(info);
            generateCreateSql(info);

            generateClientController(info);
            generateClientService(info);
            generateClientServiceHystrix(info);
        }
        System.out.println("create");
    }

    private void generateClientController(GenerateInfo info) {
        GenerateString gs = GenerateString.build();
        gs.appendPackage(info.getBaseClientPackage(),info.getControllerPackage(),info.getBaseUrl()).appendRN();

        gs.appendImport(Map.class,Resource.class);
        gs.appendImport("com.ming.ppsg.tool.http.HttpResult");
        gs.appendImport("org.springframework.web.bind.annotation.PostMapping");
        gs.appendImport("org.springframework.web.bind.annotation.RequestBody");
        gs.appendImport("org.springframework.web.bind.annotation.RequestMapping");
        gs.appendImport("org.springframework.web.bind.annotation.RestController");
        gs.appendImport(info.getBaseClientPackage()+"."+info.getServicePackage()+"."+info.getBaseUrl()+"."+info.getServiceName());
        gs.appendRN();

        gs.appendDesc(info.getComment(), DescType.CLASS,0);
        gs.append("@RestController").appendRN();
        gs.append("@RequestMapping(\""+info.getClassMapping()+"\")").appendRN();
        gs.append("public class ").append(info.getControllerName()).append(" {").appendRN().appendRN();

        gs.appendT(1).append("@Resource").appendRN();
        gs.appendT(1).append("private "+info.getServiceName()+" "+info.getServiceLowerName()+";").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.SELECT,1);
        gs.appendT(1).append("@PostMapping(\"/select\")").appendRN();
        gs.appendT(1).append("public HttpResult select(").append("@RequestBody Map<String,Object> map){").appendRN();
        gs.appendT(2).append("return "+ info.getServiceLowerName()+".select(map)").appendSRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.INSERT,1);
        gs.appendT(1).append("@PostMapping(\"/insert\")").appendRN();
        gs.appendT(1).append("public HttpResult insert(").append("@RequestBody Map<String,Object> map){").appendRN();
        gs.appendT(2).append("return "+ info.getServiceLowerName()+".insert(map)").appendSRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.UPDATE,1);
        gs.appendT(1).append("@PostMapping(\"/update\")").appendRN();
        gs.appendT(1).append("public HttpResult update(").append("@RequestBody Map<String,Object> map){").appendRN();
        gs.appendT(2).append("return "+ info.getServiceLowerName()+".update(map)").appendSRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.DELETE,1);
        gs.appendT(1).append("@PostMapping(\"/delete\")").appendRN();
        gs.appendT(1).append("public HttpResult delete(").append("@RequestBody Map<String,Object> map){").appendRN();
        gs.appendT(2).append("return "+ info.getServiceLowerName()+".delete(map)").appendSRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.append("}");
        createFile(info.getClientControllerAbsolutePath(),gs.toString());
    }

    private void generateClientService(GenerateInfo info) {
        GenerateString gs = GenerateString.build();
        gs.appendPackage(info.getBaseClientPackage(),info.getServicePackage(),info.getBaseUrl()).appendRN();

        gs.appendImport(Map.class);
        gs.appendImport("com.ming.ppsg.tool.http.HttpResult");
        gs.appendImport("org.springframework.web.bind.annotation.PostMapping");
        gs.appendImport("org.springframework.web.bind.annotation.RequestBody");
        gs.appendImport("org.springframework.cloud.openfeign.FeignClient");
        gs.appendImport(info.getBaseClientPackage()+"."+info.getServicePackage()+"."+info.getServiceImplPackage()+"."+info.getBaseUrl()+"."+info.getServiceImplName());
        gs.appendRN();

        gs.append("@FeignClient(name = \"ppsg-server\",fallback = "+info.getServiceImplName()+".class)").appendRN();
        gs.append("public interface "+ info.getServiceName() +" {").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.SELECT,1);
        gs.appendT(1).append("@PostMapping(\""+info.getClassMapping()+"/select\")").appendRN();
        gs.appendT(1).append("public HttpResult select(").append("@RequestBody Map<String,Object> map);").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.INSERT,1);
        gs.appendT(1).append("@PostMapping(\""+info.getClassMapping()+"/insert\")").appendRN();
        gs.appendT(1).append("public HttpResult insert(").append("@RequestBody Map<String,Object> map);").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.UPDATE,1);
        gs.appendT(1).append("@PostMapping(\""+info.getClassMapping()+"/update\")").appendRN();
        gs.appendT(1).append("public HttpResult update(").append("@RequestBody Map<String,Object> map);").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.DELETE,1);
        gs.appendT(1).append("@PostMapping(\""+info.getClassMapping()+"/delete\")").appendRN();
        gs.appendT(1).append("public HttpResult delete(").append("@RequestBody Map<String,Object> map);").appendRN().appendRN();

        gs.append("}").appendRN();
        createFile(info.getClientServiceAbsolutePath(),gs.toString());
    }

    private void generateClientServiceHystrix(GenerateInfo info) {
        GenerateString gs = GenerateString.build();
        gs.appendPackage(info.getBaseClientPackage(),info.getServicePackage()+"."+info.getServiceImplPackage(),info.getBaseUrl()).appendRN();

        gs.appendImport(Map.class);
        gs.appendImport("com.ming.ppsg.tool.http.HttpResult");
        gs.appendImport("org.springframework.web.bind.annotation.PostMapping");
        gs.appendImport("org.springframework.web.bind.annotation.RequestBody");
        gs.appendImport("org.springframework.stereotype.Component");
        gs.appendImport(info.getBaseClientPackage()+"."+info.getServicePackage()+"."+info.getBaseUrl()+"."+info.getServiceName());
        gs.appendRN();

        gs.append("@Component").appendRN();
        gs.append("public class "+ info.getServiceImplName() +" implements "+info.getServiceName()+" {").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.SELECT,1);
        gs.appendT(1).append("@Override").appendRN();
        gs.appendT(1).append("@PostMapping(\""+info.getClassMapping()+"/select\")").appendRN();
        gs.appendT(1).append("public HttpResult select(").append("@RequestBody Map<String,Object> map){").appendRN();
        gs.appendT(2).append("return HttpResult.error(\"sorry, this service call failed.\")").appendSRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.INSERT,1);
        gs.appendT(1).append("@Override").appendRN();
        gs.appendT(1).append("@PostMapping(\""+info.getClassMapping()+"/insert\")").appendRN();
        gs.appendT(1).append("public HttpResult insert(").append("@RequestBody Map<String,Object> map){").appendRN();
        gs.appendT(2).append("return HttpResult.error(\"sorry, this service call failed.\")").appendSRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.UPDATE,1);
        gs.appendT(1).append("@Override").appendRN();
        gs.appendT(1).append("@PostMapping(\""+info.getClassMapping()+"/update\")").appendRN();
        gs.appendT(1).append("public HttpResult update(").append("@RequestBody Map<String,Object> map){").appendRN();
        gs.appendT(2).append("return HttpResult.error(\"sorry, this service call failed.\")").appendSRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.appendDesc(info.getComment(), DescType.DELETE,1);
        gs.appendT(1).append("@Override").appendRN();
        gs.appendT(1).append("@PostMapping(\""+info.getClassMapping()+"/delete\")").appendRN();
        gs.appendT(1).append("public HttpResult delete(").append("@RequestBody Map<String,Object> map){").appendRN();
        gs.appendT(2).append("return HttpResult.error(\"sorry, this service call failed.\")").appendSRN();
        gs.appendT(1).append("}").appendRN().appendRN();

        gs.append("}").appendRN();
        createFile(info.getClientServiceHystrixAbsolutePath(),gs.toString());
    }
}
