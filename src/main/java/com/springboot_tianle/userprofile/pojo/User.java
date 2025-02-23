package com.springboot_tianle.userprofile.pojo;

import jakarta.persistence.*;

//@table（可选）：指定 数据库表的名称。如果不加 @Table，JPA 会默认使用类名作为表名。
//@Entity标识该类是 JPA 实体（Entity），表明它应该映射到数据库中的一张表。
// 如果不加 @Entity，Spring Boot 不会将 User 类识别为数据库表，导致 Hibernate/JPA 抛出错误

@Table(name="tb_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;
    @Column(name="user_name")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;

    /*
    @Entity（假设省略了） → 该类应该是 JPA 实体类，映射到数据库表
    @Id → userId 作为 主键。
    @GeneratedValue(strategy = GenerationType.AUTO)：
    作用：指定主键 userId 如何自动生成。
    GenerationType.AUTO：让 JPA 选择合适的主键生成策略（由数据库驱动或 JPA 提供者决定）。
    实际行为：
    在 MySQL 中通常等同于 IDENTITY。
    在 PostgreSQL 和 Oracle 可能使用 SEQUENCE。

    GenerationType.AUTO（默认，自动选择策略）
    GenerationType.IDENTITY（数据库自增）通常是 AUTO_INCREMENT
    GenerationType.SEQUENCE（使用数据库序列）依赖数据库的 SEQUENCE 生成 ID。适用于 PostgreSQL、Oracle（MySQL 不支持）。
    GenerationType.TABLE（使用一张表存 ID）（适用早期数据库）
     */
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
