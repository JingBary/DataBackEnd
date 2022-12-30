package com.jyh.dao.impl;

import com.jyh.dao.DatasourceDao;
import com.jyh.entity.Datasourceinfo;
import com.jyh.mapper.DatasourceinfoMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

@Component
public class DatasourceDaoImpl implements DatasourceDao {

    @Autowired //因为已经将mapper层放到mapperscan里面去了，所以此处直接从容器里拿
    private DatasourceinfoMapper datasourceinfoMapper;
    @Override
    public void insertDatasourceinfo(Datasourceinfo datasourceinfo) {
        datasourceinfoMapper.insertDatasourceinfo(datasourceinfo);
    }

    @Override
    public List<Datasourceinfo> findbyType(Datasourceinfo datasourceinfo) {
        return datasourceinfoMapper.findbyType(datasourceinfo);
    }

    /**
     * mysql、click house、jdbc可以直接链接他们
     * @param datasourceinfo
     * @return
     */
    @Override
    public Connection testConnect(Datasourceinfo datasourceinfo) {
        Connection conn = null;
        //定义Driver
        String driver="";
        int dtype=datasourceinfo.getDtype();
        if(dtype==0){
            driver="com.mysql.jdbc.Driver";
        }
        else if(dtype==3){
            driver="ru.yandex.clickhouse.ClickHouseDriver";
        }
        else if(dtype==1){
            driver="org.apache.hive.jdbc.HiveDriver";
        }
        try {
            Class.forName(driver);
            String adress=datasourceinfo.getDadress();
            if (StringUtils.isBlank(datasourceinfo.getUsername())){
                System.out.println(driver);
                System.out.println(adress);
//                String dadress="jdbc:hive2://192.168.111.207:10000/aliyun_pro";
                conn = DriverManager.getConnection(adress);
                }
            else{
                conn = DriverManager.getConnection(datasourceinfo.getDadress(), datasourceinfo.getUsername(), datasourceinfo.getUserpassw());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接失败");
            return null;
        }
        return conn;
    }

    @Override
    public List<Datasourceinfo> findAll() {
        return datasourceinfoMapper.findAll();
    }

    @Override
    public Datasourceinfo findById(Integer id) {
        return datasourceinfoMapper.findById(id);
    }

//    public static void main(String[] args) throws Exception {
//        String driver="org.apache.hive.jdbc.HiveDriver";
//        Class.forName(driver);
//        String dadress="jdbc:hive2://192.168.111.207:10000/aliyun_pro";
//        Connection connection = DriverManager.getConnection(dadress);
//    }

}
