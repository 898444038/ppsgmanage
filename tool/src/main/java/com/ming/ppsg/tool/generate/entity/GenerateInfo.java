package com.ming.ppsg.tool.generate.entity;

import com.ming.ppsg.tool.generate.utils.GenerateUtil;

public class GenerateInfo {

    private String basePath = "D:\\my\\ppsg\\ppsgmanage\\admin\\src\\main\\java\\com\\ming\\ppsg\\ppsg\\";
    private String baseXmlPath = "D:\\my\\ppsg\\ppsgmanage\\admin\\src\\main\\resources\\mapping\\";
    private String baseSqlPath = "D:\\my\\ppsg\\ppsgmanage\\admin\\src\\main\\resources\\sql\\";
    private String baseClientPath = "D:\\my\\ppsg\\ppsgmanage\\client\\src\\main\\java\\com\\ming\\ppsg\\client\\ppsg\\";
    private String voAbsolutePath;
    private String controllerAbsolutePath;
    private String serviceAbsolutePath;
    private String serviceImplAbsolutePath;
    private String mapperAbsolutePath;
    private String mapperXmlAbsolutePath;
    private String sqlAbsolutePath;

    private String clientControllerAbsolutePath;
    private String clientServiceAbsolutePath;
    private String clientServiceHystrixAbsolutePath;

    private String basePackage;//基础包路径
    private String baseClientPackage = "com.ming.ppsg.client.ppsg";//基础包路径
    private String voPackage = "vo";
    private String entityPackage = "entity";
    private String controllerPackage = "controller";
    private String servicePackage = "service";
    private String serviceImplPackage = "impl";
    private String mapperPackage = "mapper";
    private String sqlPackage = "sql";

    private String voPackagePath;
    private String entityPackagePath;
    private String controllerPackagePath;
    private String servicePackagePath;
    private String serviceImplPackagePath;
    private String mapperPackagePath;

    private String baseUrl;//分类文件夹

    private String tableName;
    private String classMapping;

    private String entityName;
    private String entityLowerName;

    private String controllerName;
    private String controllerLowerName;

    private String serviceName;
    private String serviceLowerName;

    private String serviceImplName;
    private String serviceImplLowerName;

    private String mapperName;
    private String mapperLowerName;

    private String voName;
    private String voLowerName;

    private Class cls;
    private Comment comment;

    public GenerateInfo() {
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
        this.voPackagePath = basePackage+"."+voPackage+"."+baseUrl;
        this.entityPackagePath = basePackage+"."+entityPackage+"."+baseUrl;
        this.controllerPackagePath = basePackage+"."+controllerPackage+"."+baseUrl;
        this.servicePackagePath = basePackage+"."+servicePackage+"."+baseUrl;
        this.serviceImplPackagePath = basePackage+"."+servicePackage+"."+serviceImplPackage+"."+baseUrl;
        this.mapperPackagePath = basePackage+"."+mapperPackage+"."+baseUrl;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
        this.voName = entityName + GenerateUtil.firstUpperCase(this.voPackage);
        this.controllerName = entityName + GenerateUtil.firstUpperCase(this.controllerPackage);
        this.serviceName = entityName + GenerateUtil.firstUpperCase(this.servicePackage);
        this.serviceImplName = entityName + GenerateUtil.firstUpperCase(this.servicePackage) + GenerateUtil.firstUpperCase(this.serviceImplPackage);
        this.mapperName = entityName + GenerateUtil.firstUpperCase(this.mapperPackage);

        this.voAbsolutePath = this.basePath+""+voPackage+"\\"+baseUrl+"\\"+this.voName+".java";
        this.controllerAbsolutePath = this.basePath+""+controllerPackage+"\\"+baseUrl+"\\"+this.controllerName+".java";
        this.serviceAbsolutePath = this.basePath+""+servicePackage+"\\"+baseUrl+"\\"+this.serviceName+".java";
        this.serviceImplAbsolutePath = this.basePath+""+servicePackage+"\\"+serviceImplPackage+"\\"+baseUrl+"\\"+this.serviceImplName+".java";
        this.mapperAbsolutePath = this.basePath+""+mapperPackage+"\\"+baseUrl+"\\"+this.mapperName+".java";
        this.mapperXmlAbsolutePath = this.baseXmlPath+""+this.mapperName+".xml";
        this.sqlAbsolutePath = this.baseSqlPath+""+baseUrl+"\\"+this.entityName+".sql";
        this.clientControllerAbsolutePath = this.baseClientPath+""+controllerPackage+"\\"+baseUrl+"\\"+this.controllerName+".java";
        this.clientServiceAbsolutePath = this.baseClientPath+""+servicePackage+"\\"+baseUrl+"\\"+this.serviceName+".java";
        this.clientServiceHystrixAbsolutePath = this.baseClientPath+""+servicePackage+"\\"+serviceImplPackage+"\\"+baseUrl+"\\"+this.serviceImplName+".java";
    }

    public void setEntityLowerName(String entityLowerName) {
        this.entityLowerName = entityLowerName;
        this.voLowerName = entityLowerName + GenerateUtil.firstUpperCase(this.voPackage);
        this.controllerLowerName = entityLowerName + GenerateUtil.firstUpperCase(this.controllerPackage);
        this.serviceLowerName = entityLowerName + GenerateUtil.firstUpperCase(this.servicePackage);
        this.serviceImplLowerName = entityLowerName + GenerateUtil.firstUpperCase(this.servicePackage) + GenerateUtil.firstUpperCase(this.serviceImplPackage);
        this.mapperLowerName = entityLowerName + GenerateUtil.firstUpperCase(this.mapperPackage);
    }

    public String getBaseSqlPath() {
        return baseSqlPath;
    }

    public void setBaseSqlPath(String baseSqlPath) {
        this.baseSqlPath = baseSqlPath;
    }

    public String getClientControllerAbsolutePath() {
        return clientControllerAbsolutePath;
    }

    public void setClientControllerAbsolutePath(String clientControllerAbsolutePath) {
        this.clientControllerAbsolutePath = clientControllerAbsolutePath;
    }

    public String getClientServiceAbsolutePath() {
        return clientServiceAbsolutePath;
    }

    public void setClientServiceAbsolutePath(String clientServiceAbsolutePath) {
        this.clientServiceAbsolutePath = clientServiceAbsolutePath;
    }

    public String getClientServiceHystrixAbsolutePath() {
        return clientServiceHystrixAbsolutePath;
    }

    public void setClientServiceHystrixAbsolutePath(String clientServiceHystrixAbsolutePath) {
        this.clientServiceHystrixAbsolutePath = clientServiceHystrixAbsolutePath;
    }

    public String getBaseClientPackage() {
        return baseClientPackage;
    }

    public void setBaseClientPackage(String baseClientPackage) {
        this.baseClientPackage = baseClientPackage;
    }

    public String getBaseXmlPath() {
        return baseXmlPath;
    }

    public void setBaseXmlPath(String baseXmlPath) {
        this.baseXmlPath = baseXmlPath;
    }

    public String getVoAbsolutePath() {
        return voAbsolutePath;
    }

    public void setVoAbsolutePath(String voAbsolutePath) {
        this.voAbsolutePath = voAbsolutePath;
    }

    public String getControllerAbsolutePath() {
        return controllerAbsolutePath;
    }

    public void setControllerAbsolutePath(String controllerAbsolutePath) {
        this.controllerAbsolutePath = controllerAbsolutePath;
    }

    public String getServiceAbsolutePath() {
        return serviceAbsolutePath;
    }

    public void setServiceAbsolutePath(String serviceAbsolutePath) {
        this.serviceAbsolutePath = serviceAbsolutePath;
    }

    public String getServiceImplAbsolutePath() {
        return serviceImplAbsolutePath;
    }

    public void setServiceImplAbsolutePath(String serviceImplAbsolutePath) {
        this.serviceImplAbsolutePath = serviceImplAbsolutePath;
    }

    public String getMapperAbsolutePath() {
        return mapperAbsolutePath;
    }

    public void setMapperAbsolutePath(String mapperAbsolutePath) {
        this.mapperAbsolutePath = mapperAbsolutePath;
    }

    public String getMapperXmlAbsolutePath() {
        return mapperXmlAbsolutePath;
    }

    public void setMapperXmlAbsolutePath(String mapperXmlAbsolutePath) {
        this.mapperXmlAbsolutePath = mapperXmlAbsolutePath;
    }

    public String getSqlAbsolutePath() {
        return sqlAbsolutePath;
    }

    public void setSqlAbsolutePath(String sqlAbsolutePath) {
        this.sqlAbsolutePath = sqlAbsolutePath;
    }

    public String getSqlPackage() {
        return sqlPackage;
    }

    public void setSqlPackage(String sqlPackage) {
        this.sqlPackage = sqlPackage;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getVoPackagePath() {
        return voPackagePath;
    }

    public void setVoPackagePath(String voPackagePath) {
        this.voPackagePath = voPackagePath;
    }

    public String getControllerPackagePath() {
        return controllerPackagePath;
    }

    public void setControllerPackagePath(String controllerPackagePath) {
        this.controllerPackagePath = controllerPackagePath;
    }

    public String getServicePackagePath() {
        return servicePackagePath;
    }

    public void setServicePackagePath(String servicePackagePath) {
        this.servicePackagePath = servicePackagePath;
    }

    public String getServiceImplPackagePath() {
        return serviceImplPackagePath;
    }

    public void setServiceImplPackagePath(String serviceImplPackagePath) {
        this.serviceImplPackagePath = serviceImplPackagePath;
    }

    public String getMapperPackagePath() {
        return mapperPackagePath;
    }

    public void setMapperPackagePath(String mapperPackagePath) {
        this.mapperPackagePath = mapperPackagePath;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    public String getClassMapping() {
        return classMapping;
    }

    public void setClassMapping(String classMapping) {
        this.classMapping = classMapping;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getServiceImplPackage() {
        return serviceImplPackage;
    }

    public void setServiceImplPackage(String serviceImplPackage) {
        this.serviceImplPackage = serviceImplPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public String getVoPackage() {
        return voPackage;
    }

    public void setVoPackage(String voPackage) {
        this.voPackage = voPackage;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public String getVoName() {
        return voName;
    }

    public void setVoName(String voName) {
        this.voName = voName;
    }

    public String getVoLowerName() {
        return voLowerName;
    }

    public void setVoLowerName(String voLowerName) {
        this.voLowerName = voLowerName;
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getEntityName() {
        return entityName;
    }


    public String getEntityLowerName() {
        return entityLowerName;
    }



    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getControllerLowerName() {
        return controllerLowerName;
    }

    public void setControllerLowerName(String controllerLowerName) {
        this.controllerLowerName = controllerLowerName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceLowerName() {
        return serviceLowerName;
    }

    public void setServiceLowerName(String serviceLowerName) {
        this.serviceLowerName = serviceLowerName;
    }

    public String getServiceImplName() {
        return serviceImplName;
    }

    public void setServiceImplName(String serviceImplName) {
        this.serviceImplName = serviceImplName;
    }

    public String getServiceImplLowerName() {
        return serviceImplLowerName;
    }

    public void setServiceImplLowerName(String serviceImplLowerName) {
        this.serviceImplLowerName = serviceImplLowerName;
    }

    public String getMapperName() {
        return mapperName;
    }

    public void setMapperName(String mapperName) {
        this.mapperName = mapperName;
    }

    public String getMapperLowerName() {
        return mapperLowerName;
    }

    public void setMapperLowerName(String mapperLowerName) {
        this.mapperLowerName = mapperLowerName;
    }

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public String getEntityPackagePath() {
        return entityPackagePath;
    }

    public void setEntityPackagePath(String entityPackagePath) {
        this.entityPackagePath = entityPackagePath;
    }

    @Override
    public String toString() {
        return "{" +
                "basePackage='" + basePackage + '\'' +
                ", voPackage='" + voPackage + '\'' +
                ", baseUrl='" + baseUrl + '\'' +
                ", tableName='" + tableName + '\'' +
                ", entityName='" + entityName + '\'' +
                ", entityLowerName='" + entityLowerName + '\'' +
                ", controllerName='" + controllerName + '\'' +
                ", controllerLowerName='" + controllerLowerName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceLowerName='" + serviceLowerName + '\'' +
                ", serviceImplName='" + serviceImplName + '\'' +
                ", serviceImplLowerName='" + serviceImplLowerName + '\'' +
                ", mapperName='" + mapperName + '\'' +
                ", mapperLowerName='" + mapperLowerName + '\'' +
                ", voName='" + voName + '\'' +
                ", voLowerName='" + voLowerName + '\'' +
                ", cls=" + cls +
                ", comment=" + comment +
                '}';
    }
}
