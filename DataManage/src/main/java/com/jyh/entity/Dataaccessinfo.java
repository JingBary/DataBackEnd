package com.jyh.entity;

import java.util.Date;

/**
 * 临时结果Bean，用来对数据抽取的信息进行保存的
 */
public class Dataaccessinfo {

    private int id;
    private int sourceinfoid;
    private String sourcedb;
    private String sourcetable;
    private int extractType;//1是全量2是增量
    private int targetinfoid;
    private String targetdb;
    private String targetable;
    private Date createtime;
    private Date updatetime;

    public Dataaccessinfo(int id, int sourceinfoid, String sourcedb, String sourcetable, int extractType, int targetinfoid, String targetdb, String targetable, Date createtime, Date updatetime) {
        this.id = id;
        this.sourceinfoid = sourceinfoid;
        this.sourcedb = sourcedb;
        this.sourcetable = sourcetable;
        this.extractType = extractType;
        this.targetinfoid = targetinfoid;
        this.targetdb = targetdb;
        this.targetable = targetable;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Dataaccessinfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSourceinfoid() {
        return sourceinfoid;
    }

    public void setSourceinfoid(int sourceinfoid) {
        this.sourceinfoid = sourceinfoid;
    }

    public String getSourcedb() {
        return sourcedb;
    }

    public void setSourcedb(String sourcedb) {
        this.sourcedb = sourcedb;
    }

    public String getSourcetable() {
        return sourcetable;
    }

    public void setSourcetable(String sourcetable) {
        this.sourcetable = sourcetable;
    }

    public int getExtractType() {
        return extractType;
    }

    public void setExtractType(int extractType) {
        this.extractType = extractType;
    }

    public int getTargetinfoid() {
        return targetinfoid;
    }

    public void setTargetinfoid(int targetinfoid) {
        this.targetinfoid = targetinfoid;
    }

    public String getTargetdb() {
        return targetdb;
    }

    public void setTargetdb(String targetdb) {
        this.targetdb = targetdb;
    }

    public String getTargetable() {
        return targetable;
    }

    public void setTargetable(String targetable) {
        this.targetable = targetable;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
