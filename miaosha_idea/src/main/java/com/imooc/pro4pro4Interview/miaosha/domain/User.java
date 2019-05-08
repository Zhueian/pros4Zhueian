package com.imooc.pro4pro4Interview.miaosha.domain;

/**
 * @Auther: qiucy
 * @Date: 2019-05-07 12:55
 * @Description:
 */
public class User {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
