package com.jyh.service.impl;

import com.jyh.dao.DataAccessinfoDao;
import com.jyh.entity.Dataaccessinfo;
import com.jyh.service.DataAccessinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DataAccessinfoServiceImpl implements DataAccessinfoService {
    @Autowired
    private DataAccessinfoDao dataAccessinfoDao;
    @Override
    public void insertDataaccessinfo(Dataaccessinfo dataaccessinfo) {
        dataaccessinfo.setCreatetime(new Date());
        dataAccessinfoDao.insertDataaccessinfo(dataaccessinfo);
    }
}
