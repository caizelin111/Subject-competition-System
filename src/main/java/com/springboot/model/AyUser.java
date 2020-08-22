package com.springboot.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="ay_user")
public class AyUser {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY )//自增
    private Integer id;
//    @NotBlank(message = "用户名不能为空")//非空校验
    private String name;
//    @NotBlank(message = "密码不能为空")//密码非空校验
//    @Length(max = 20,min = 6)
    private String password;
    @Email
    private String email;
    @Length(max = 11,min = 11,message = "手机号码格式不正确")
    private String phoneNumber;
    private String secondSchool;
    private String jobNumber;

    public String getSecondSchool() {
        return secondSchool;
    }

    public void setSecondSchool(String secondSchool) {
        this.secondSchool = secondSchool;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AyUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
