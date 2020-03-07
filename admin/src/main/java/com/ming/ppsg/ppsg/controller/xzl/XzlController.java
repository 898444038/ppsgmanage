package com.ming.ppsg.ppsg.controller.xzl;


import com.ming.ppsg.ppsg.controller.xzl.entity.AppointExcludeGenerals;
import com.ming.ppsg.ppsg.controller.xzl.entity.AppointGenerals;
import com.ming.ppsg.ppsg.controller.xzl.entity.AppointSymbols;
import com.ming.ppsg.ppsg.controller.xzl.main.Main;
import com.ming.ppsg.ppsg.controller.xzl.utils.ExcelReaderUtil;
import com.ming.ppsg.ppsg.controller.xzl.utils.jxls.JxlsUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ppsg/xzl/custom")
public class XzlController {

    @PostMapping("/exportExcel")
    public void exportExcel(@RequestBody Map<String,Object> map, HttpServletResponse response){

        List<AppointGenerals> appointGeneralsList = new ArrayList<>();
        List<String> generalsList = (List<String>)map.get("generals");
        for(String generals : generalsList){
            appointGeneralsList.add(new AppointGenerals(generals));
        }

        List<AppointExcludeGenerals> excludeGeneralsList = new ArrayList<>();
        List<Map<String,Object>> generalsCountList = (List<Map<String,Object>>)map.get("generalsCount");
        for(Map<String,Object> maps : generalsCountList){
            excludeGeneralsList.add(new AppointExcludeGenerals(maps.get("name").toString(),Integer.valueOf(maps.get("maxSize").toString())));
        }

        List<AppointSymbols> appointSymbolsList = new ArrayList<>();
        List<String> symbolsList = (List<String>)map.get("symbols");
        for(String symbols : symbolsList){
            appointSymbolsList.add(new AppointSymbols(Integer.valueOf(symbols)));
        }

        Boolean isSkin = (Boolean)map.get("isSkin");
        Map<String,Object> model = Main.start(appointGeneralsList,excludeGeneralsList,appointSymbolsList,isSkin);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            InputStream is = ExcelReaderUtil.class.getResourceAsStream("/excel/result_temp.xlsx");
            OutputStream os = response.getOutputStream();
            JxlsUtil.export2Excel(is,os,model);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
