package com.jyh.dao;

import com.jyh.entity.Datasourceinfo;

import java.sql.Connection;
import java.util.List;

public interface DatasourceDao {
    public void insertDatasourceinfo(Datasourceinfo datasourceinfo);
    public List<Datasourceinfo> findbyType(Datasourceinfo datasourceinfo);
    public Connection testConnect(Datasourceinfo datasourceinfo);
    public List<Datasourceinfo> findAll();
    public Datasourceinfo findById(Integer id);
}
