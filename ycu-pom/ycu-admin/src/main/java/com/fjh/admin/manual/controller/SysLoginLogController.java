package com.fjh.admin.manual.controller;


import com.fjh.admin.auto.model.SysLoginLog;
import com.fjh.admin.manual.service.SysLoginLogService;
import com.fjh.core.http.HttpResult;
import com.fjh.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 登录日志控制器
 */
@RestController
@RequestMapping("loginlog")
public class SysLoginLogController {

    @Autowired
    private SysLoginLogService sysLoginLogService;

    /**
     * 分页查询
     * @param pageRequest
     * @return
     */
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLoginLogService.findPage(pageRequest));
    }

    /**
     * 删除日志
     * @param records
     * @return
     */
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysLoginLog> records) {
        return HttpResult.ok(sysLoginLogService.delete(records));
    }
}
