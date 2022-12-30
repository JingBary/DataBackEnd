package com.jyh.entity;

public class Datasourceinfo {
    private int id;
    private String dname;
    private int dtype; //0Mysql、1Hive、2Hbase、3ClickHouse;
    private String username;
    private String userpassw;
    private String dadress;

    public Datasourceinfo(int id, String dname, int dtype, String username, String userpassw, String dadress) {
        this.id = id;
        this.dname = dname;
        this.dtype = dtype;
        this.username = username;
        this.userpassw = userpassw;
        this.dadress = dadress;
    }

    public Datasourceinfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getDtype() {
        return dtype;
    }

    public void setDtype(int dtype) {
        this.dtype = dtype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassw() {
        return userpassw;
    }

    public void setUserpassw(String userpassw) {
        this.userpassw = userpassw;
    }

    public String getDadress() {
        return dadress;
    }

    public void setDadress(String dadress) {
        this.dadress = dadress;
    }
}
