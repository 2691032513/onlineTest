package com.entity;


public class Teacher {

  private long id;
  private String account;
  private String password;
  private String realName;
  private String sex;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  @Override
  public String toString() {
    return "Teacher{" +
            "id=" + id +
            ", account='" + account + '\'' +
            ", password='" + password + '\'' +
            ", realName='" + realName + '\'' +
            ", sex='" + sex + '\'' +
            '}';
  }
}
