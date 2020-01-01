package com.entity;


import java.util.List;

public class QuestionBank {

  private long id;
  private String name;
  private String type;
  private long sjid;
  private long tid;
  private List<Question> questions;
  private double questionsScore;
  private boolean judgeType;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public boolean isJudgeType() {
    return judgeType;
  }

  public void setJudgeType(boolean judgeType) {
    this.judgeType = judgeType;
  }

  public long getTid() {
    return tid;
  }

  public void setTid(long tid) {
    this.tid = tid;
  }

  public double getQuestionsScore() {
    return questionsScore;
  }

  public void setQuestionsScore(double questionsScore) {
    this.questionsScore = questionsScore;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public long getSjid() {
    return sjid;
  }

  public void setSjid(long sjid) {
    this.sjid = sjid;
  }

  @Override
  public String toString() {
    return "QuestionBank{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", sjid=" + sjid +
            ", questions=" + questions +
            '}';
  }
}
