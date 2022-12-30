package com.jyh.mapper;

import com.jyh.entity.Datasourceinfo;

import java.util.List;

public interface DatasourceinfoMapper {
    public void insertDatasourceinfo(Datasourceinfo datasourceinfo);
    public List<Datasourceinfo> findbyType(Datasourceinfo datasourceinfo);
    public List<Datasourceinfo> findAll();
    public Datasourceinfo findById(Integer id);
}
