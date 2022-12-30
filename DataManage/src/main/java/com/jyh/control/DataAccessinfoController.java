package com.jyh.control;

import com.jyh.entity.Dataaccessinfo;
import com.jyh.service.DataAccessinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
//增加一个前缀
@RequestMapping("dataAccessinfo")
public class DataAccessinfoController {
    @Autowired
    private DataAccessinfoService dataAccessinfoService;
    @CrossOrigin
    @RequestMapping(value = "insertDataAccessinfo",method = RequestMethod.POST)
    public void insertDatasource(Dataaccessinfo dataaccessinfo){
        dataaccessinfo.setCreatetime(new Date());
        System.out.println(dataaccessinfo.getCreatetime());
        System.out.println(dataaccessinfo.getExtractType());
        System.out.println(dataaccessinfo.getSourcedb());
        System.out.println(dataaccessinfo.getTargetable());
        dataAccessinfoService.insertDataaccessinfo(dataaccessinfo);
    }
}
