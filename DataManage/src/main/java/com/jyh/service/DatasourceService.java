package com.jyh.service;

import com.jyh.entity.Datasourceinfo;

import java.sql.Connection;
import java.util.List;

public interface DatasourceService {
    public void insertDatasourceinfo(Datasourceinfo datasourceinfo);
    public List<Datasourceinfo> findbyType(Datasourceinfo datasourceinfo);
    public boolean testConnect(Datasourceinfo datasourceinfo);
    public List<Datasourceinfo> findAll();
    public Datasourceinfo findById(Integer id);
}
