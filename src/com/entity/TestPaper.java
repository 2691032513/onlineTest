package com.entity;


import java.util.List;

public class TestPaper {

  private long id;
  private String name;
  private long sjid;
  private long tid;
  private List<QuestionBank> questionBanks;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getSjid() {
    return sjid;
  }

  public void setSjid(long sjid) {
    this.sjid = sjid;
  }

  public List<QuestionBank> getQuestionBanks() {
    return questionBanks;
  }

  public void setQuestionBanks(List<QuestionBank> questionBanks) {
    this.questionBanks = questionBanks;
  }

  public long getTid() {
    return tid;
  }

  public void setTid(long tid) {
    this.tid = tid;
  }

  @Override
  public String toString() {
    return "TestPaper{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", sjid=" + sjid +
            ", tid=" + tid +
            ", questionBanks=" + questionBanks +
            '}';
  }
}
