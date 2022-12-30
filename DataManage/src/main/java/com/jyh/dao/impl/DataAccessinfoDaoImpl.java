package com.jyh.dao.impl;

import com.jyh.dao.DataAccessinfoDao;
import com.jyh.entity.Dataaccessinfo;
import com.jyh.mapper.DataaccesssinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataAccessinfoDaoImpl implements DataAccessinfoDao {
    @Autowired
    private DataaccesssinfoMapper dataaccesssinfoMapper;
    @Override
    public void insertDataaccessinfo(Dataaccessinfo dataaccessinfo) {
        dataaccesssinfoMapper.insertDataaccessinfo(dataaccessinfo);
    }
}
