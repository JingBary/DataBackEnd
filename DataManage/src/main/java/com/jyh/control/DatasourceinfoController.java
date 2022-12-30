package com.jyh.control;

import com.alibaba.fastjson2.JSONObject;
import com.jyh.entity.Dataaccessinfo;
import com.jyh.entity.Datasourceinfo;
import com.jyh.service.DataAccessinfoService;
import com.jyh.service.DatasourceService;
import com.jyh.service.impl.DatasourceServiceImpl;
import com.jyh.utils.DbUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
//增加一个前缀
@RequestMapping("datasource")

public class DatasourceinfoController {
    @Autowired
    private DatasourceServiceImpl datasourceService;

    /**
     * 插入datasourceinfo数据
     * @param datasourceinfo
     */
    @CrossOrigin
    @RequestMapping(value = "insertDatasourceInfo",method = RequestMethod.POST)
    public void insertDatasource(Datasourceinfo datasourceinfo){
        datasourceService.insertDatasourceinfo(datasourceinfo);
    }

    /**
     * 根据类型查找datasourceinfo，查mysql类型还是其他类型
     * @param datasourceinfo
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "listDatasourceByType",method = RequestMethod.POST)
    public List<Datasourceinfo> listDatasourceByType(Datasourceinfo datasourceinfo){
        List<Datasourceinfo> result = datasourceService.findbyType(datasourceinfo);
        return result;
    }

    /**
     * 测试数据库的连接
     * @param datasourceinfo
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "testConnect",method = RequestMethod.POST)
    public String testConnetc(Datasourceinfo datasourceinfo){
        boolean result = datasourceService.testConnect(datasourceinfo);
        String resultstring = result==true?"true":"false";
        return resultstring;
    }

    /**
     * 动态渲染同步功能的临时表
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "findAllDatainfo",method = RequestMethod.POST)
    public List<JSONObject> findAllDatainfo() {
        List<Datasourceinfo> list =  datasourceService.findAll();
        List<JSONObject> resultObject = new ArrayList<JSONObject>();
        for(Datasourceinfo datasourceinfo :list){
            String dName =  datasourceinfo.getDname();
            int id = datasourceinfo.getId();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("key",dName);
            jsonObject.put("value",id);
            resultObject.add(jsonObject);

        }
        return  resultObject;
    }

    /**
     * 找到数据源的所有database
     * @param id
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "findAlldb",method = RequestMethod.POST)
    public List<Map<String, String>> findAlldb(int id) {
        List<Map<String, String>> reusltlist = new ArrayList<Map<String, String>>();
        Datasourceinfo datasourceinfo =  datasourceService.findById(id);
        String dAdress = datasourceinfo.getDadress();
        int dtype = datasourceinfo.getDtype();
        String username = datasourceinfo.getUsername();
        String userpassw = datasourceinfo.getUserpassw();
        String driver = "";
        if(dtype == 0){
            driver = "com.mysql.jdbc.Driver";
            reusltlist = DbUtils.gets(dAdress,username,userpassw,driver);
        }else if(dtype == 1){
            driver = "org.apache.hive.jdbc.HiveDriver";
            reusltlist = DbUtils.gets(dAdress,username,userpassw,driver);
        }else if(dtype == 3){
            driver = "ru.yandex.clickhouse.ClickHouseDriver";
            reusltlist = DbUtils.gets(dAdress,username,userpassw,driver);
        }



        return  reusltlist;
    }

    /**
     * 找到所有的
     * @param
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "findAlltable",method = RequestMethod.POST)
    public List<Map<String, String>> findAlltable(int id,String dbname) {
        List<Map<String, String>> reusltlist = new ArrayList<Map<String, String>>();
        Datasourceinfo datasourceinfo =  datasourceService.findById(id);
        String dAdress = datasourceinfo.getDadress();
        System.out.println(dbname);
        int indexXie = dAdress.lastIndexOf("/");
        String subString = dAdress.substring(0,indexXie);
        dAdress = subString+"/"+dbname;
        int dtype = datasourceinfo.getDtype();
        String username = datasourceinfo.getUsername();
        String userpassw = datasourceinfo.getUserpassw();
        String driver = "";
        if(dtype == 0){
            driver = "com.mysql.jdbc.Driver";
            System.out.println(dAdress);
            System.out.println(username);
            System.out.println(userpassw);
            System.out.println(driver);
            reusltlist = DbUtils.gettableList(dAdress,username,userpassw,driver);
        }else if(dtype == 1){
            driver = "org.apache.hive.jdbc.HiveDriver";
            reusltlist = DbUtils.gettableList(dAdress,username,userpassw,driver);
        }else if(dtype == 3){
            driver = "ru.yandex.clickhouse.ClickHouseDriver";
            reusltlist = DbUtils.gettableList(dAdress,username,userpassw,driver);
        }


        return  reusltlist;
    }
}
