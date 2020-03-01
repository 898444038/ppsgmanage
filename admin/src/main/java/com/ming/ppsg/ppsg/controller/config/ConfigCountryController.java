package com.ming.ppsg.ppsg.controller.config;


import com.ming.ppsg.ppsg.entity.config.ConfigCountry;
import com.ming.ppsg.ppsg.service.config.ConfigCountryService;
import com.ming.ppsg.ppsg.vo.config.ConfigCountryVo;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ppsg/config/country")
public class ConfigCountryController {

    @Resource
    private ConfigCountryService configCountryService;

    /**
     * 查询
     * @author: wang
     * @date: 2020-02-28 18:49:53
     */
    @PostMapping("/select")
    public HttpResult select(@RequestBody ConfigCountryVo configCountryVo){
        List<ConfigCountry> list = configCountryService.select(configCountryVo);
        return HttpResult.ok(list);
    }

    /**
     * 新增
     * @author: wang
     * @date: 2020-02-28 18:49:53
     */
    @PostMapping("/insert")
    public HttpResult insert(@RequestBody ConfigCountryVo configCountryVo){
        int i = configCountryService.insert(configCountryVo);
        return HttpResult.judge(i);
    }

    /**
     * 根据id更新
     * @author: wang
     * @date: 2020-02-28 18:49:53
     */
    @PostMapping("/update")
    public HttpResult update(@RequestBody ConfigCountryVo configCountryVo){
        if(configCountryVo.getId() == null){
            return HttpResult.error();
        }
        int i = configCountryService.update(configCountryVo);
        return HttpResult.judge(i);
    }

    /**
     * 根据id删除
     * @author: wang
     * @date: 2020-02-28 18:49:53
     */
    @PostMapping("/delete")
    public HttpResult delete(@RequestBody ConfigCountryVo configCountryVo){
        if(configCountryVo.getId() == null){
            return HttpResult.error();
        }
        int i = configCountryService.delete(configCountryVo);
        return HttpResult.judge(i);
    }

}
