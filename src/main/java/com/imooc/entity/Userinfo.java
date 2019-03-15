package com.imooc.entity;

import javax.persistence.*;

@Entity //加入这个注解，就会进行持久化了
@Table(name="userinfo") //对应数据库的表名字
public class Userinfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="male")
    private  Integer male;   //性别
    @Column(name="age")
    private  Integer age;   //年龄
    @Column(name="hobit")
    private  String hobit;  //爱好
    @Column(name = "remark")
    private String remark;  //备注

    public Userinfo() {
    }

    public Userinfo(String name, Integer age, Integer male, String hobit) {
        this.name = name;
        this.male = male;
        this.hobit = hobit;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMale() {
        return male;
    }

    public void setMale(Integer male) {
        this.male = male;
    }

    public String getHobit() {
        return hobit;
    }

    public void setHobit(String hobit) {
        this.hobit = hobit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

