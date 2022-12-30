package com.jyh.service.impl;

import com.jyh.dao.DatasourceDao;
import com.jyh.entity.Datasourceinfo;
import com.jyh.mapper.DatasourceinfoMapper;
import com.jyh.service.DatasourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class DatasourceServiceImpl implements DatasourceService {
    @Autowired//注入的其实是Dao的实现，因为只有dao的实现放入了Spring容器中
    private DatasourceDao datasourceDao;
    @Override
    public void insertDatasourceinfo(Datasourceinfo datasourceinfo) {
        datasourceDao.insertDatasourceinfo(datasourceinfo);
    }

    @Override
    public List<Datasourceinfo> findbyType(Datasourceinfo datasourceinfo) {
        return datasourceDao.findbyType(datasourceinfo);
    }

    @Override
    public boolean testConnect(Datasourceinfo datasourceinfo) {
        Connection connection = datasourceDao.testConnect(datasourceinfo);
        if(connection!=null){
            try {
                connection.close();
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Datasourceinfo> findAll() {
        return datasourceDao.findAll();
    }

    @Override
    public Datasourceinfo findById(Integer id) {
        return datasourceDao.findById(id);
    }
}
