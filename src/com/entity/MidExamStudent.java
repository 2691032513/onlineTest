package com.entity;


import java.util.List;

public class MidExamStudent {

  private long id;
  private long eid;
  private long sid;
  private double score;
  private java.sql.Timestamp startExamTime;
  private long submitted;
  private java.sql.Timestamp latestSubmitTime;
  private List<MidExamStudentQuestion> answers;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getEid() {
    return eid;
  }

  public void setEid(long eid) {
    this.eid = eid;
  }


  public long getSid() {
    return sid;
  }

  public void setSid(long sid) {
    this.sid = sid;
  }


  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }


  public java.sql.Timestamp getStartExamTime() {
    return startExamTime;
  }

  public void setStartExamTime(java.sql.Timestamp startExamTime) {
    this.startExamTime = startExamTime;
  }


  public long getSubmitted() {
    return submitted;
  }

  public void setSubmitted(long submitted) {
    this.submitted = submitted;
  }


  public java.sql.Timestamp getLatestSubmitTime() {
    return latestSubmitTime;
  }

  public void setLatestSubmitTime(java.sql.Timestamp latestSubmitTime) {
    this.latestSubmitTime = latestSubmitTime;
  }

  public List<MidExamStudentQuestion> getAnswers() {
    return answers;
  }

  public void setAnswers(List<MidExamStudentQuestion> answers) {
    this.answers = answers;
  }
}
