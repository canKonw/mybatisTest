package com.hh.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by huhao on 15-9-16.
 */
public class Orders {
    private int id;
    private int userId;
    private int number;
    private Date createTime;
    private String note;
    private User user;
    private List<Orderdetail> orderdetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Orderdetail> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(List<Orderdetail> orderdetails) {
        this.orderdetails = orderdetails;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userId=" + userId +
                ", number=" + number +
                ", createTime=" + createTime +
                ", note='" + note + '\'' +
                ", user=" + user +
                ", orderdetails=" + orderdetails +
                '}';
    }
}
