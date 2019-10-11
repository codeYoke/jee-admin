package com.fjh.admin.manual.controller;

import com.fjh.admin.auto.model.SysConfig;
import com.fjh.admin.manual.service.SysConfigService;
import com.fjh.core.http.HttpResult;
import com.fjh.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 系统配置控制器
 */
@RestController
@RequestMapping("config")
public class SysConfigController {

    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 保存配置
     * @param record
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysConfig record) {
        return HttpResult.ok(sysConfigService.save(record));
    }

    /**
     * 删除配置
     * @param records
     * @return
     */
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysConfig> records) {
        return HttpResult.ok(sysConfigService.delete(records));
    }

    /**
     * 分页查询
     * @param pageRequest
     * @return
     */
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysConfigService.findPage(pageRequest));
    }

    /**
     * 根据标签查询
     * @param lable
     * @return
     */
    @GetMapping(value = "/findByLable")
    public HttpResult findByLable(@RequestParam String lable) {
        return HttpResult.ok(sysConfigService.findByLable(lable));
    }
}
