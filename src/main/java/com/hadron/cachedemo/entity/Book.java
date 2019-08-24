package com.hadron.cachedemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author Hadron
 * @date 2019/8/21 11:38
 */
public class Book implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long bookId;
    private Double price;
    private String name;
    private Timestamp createTime;
    private Integer status;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}
