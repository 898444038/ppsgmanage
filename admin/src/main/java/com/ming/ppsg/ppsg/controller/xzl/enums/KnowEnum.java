package com.ming.ppsg.ppsg.controller.xzl.enums;

public enum KnowEnum {
    jiangJun("将魂");

    private String groupName;

    private KnowEnum(String groupName) {
        this.groupName = groupName;
    }
    String getGroupName() {
        return this.groupName;
    }

    //将魂
    public enum JiangJun implements KnowEnumInterface {
        //白卡+15 黑卡+20 银卡+60 金卡+300
        //1-18 (1250-5500) 递增250
        //19-30 （5700）

        //白卡+15 黑卡+20 银卡+60 金卡+300
        //将魂1-18级 (需要经验1250-5500) 每级递增250
        //将魂19-30级 （固定经验5700）
        Force(1,"武力"),
        Intellect(2,"智力"),
        Troops(3,"兵力");
        private Integer code;
        private String name;
        JiangJun(){}
        JiangJun(Integer code,String name) {
            this.code = code;
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public Integer getCode() {
            return this.code;
        }
        public Integer getCount(){
            int total = 123450;
            return total/300;//411.5
        }
    }

    //战意
    public enum ZhanYi implements KnowEnumInterface {
        level1(1,null),
        level2(2,1000),
        level3(3,3200),
        level4(4,7600),
        level5(5,15000),
        level6(6,null),
        level7(7,null),
        level8(8,60000),
        level9(9,90000),
        ;
        private Integer code;
        private Integer name;
        ZhanYi(){}
        ZhanYi(Integer code,Integer name) {
            this.code = code;
            this.name = name;
        }
        public Integer getName() {
            return this.name;
        }
        public Integer getCode() {
            return this.code;
        }
    }

    //战阵
    /*
    0-1阶：500战功券开启
    1-2阶（金）：(每次消耗100战功券，+10战纹，X1)190战纹，上阵三维+1%，国战额外兵力+50
    2-3阶（木）：(每次消耗100战功券，+10战纹，X1、X2)820战纹，上阵三维+2%，国战额外兵力+100
    3-4阶（水）：(每次消耗100战功券，+10战纹，X1、X2、X5)1780战纹，上阵三维+3%，国战额外兵力+150
    4-5阶（）：(每次消耗100战功券，+10战纹，)3460战纹，上阵三维+4%，国战额外兵力+200
    5-6阶（）：(每次消耗100战功券，+10战纹，)5950战纹，上阵三维+5%，国战额外兵力+250
    6-7阶（）：(每次消耗100战功券，+10战纹，)9410战纹，上阵三维+6%，国战额外兵力+300
    7-8阶（雷）：(每次消耗100战功券，+10战纹，)13260战纹，上阵三维+7%，国战额外兵力+350
    8-9阶（）：(每次消耗100战功券，+10战纹，)21950战纹，上阵三维+8%，国战额外兵力+400
    9-10阶（天）：(每次消耗100战功券，+10战纹，)32100战纹，上阵三维+9%，国战额外兵力+450


    */



    //兵符
    /*
    250000
    500000
    750000
    1000000
    1500000
    2250000
    3250000
    4250000
    5740000
    7750000
    10000000
    13250000
    17250000
    22750000
    30000000

     */

}
