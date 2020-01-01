package com.entity;


public class MidTpaperQbank {

  private long tpid;
  private long qbid;
  private double questionScore;
  private long judgeType;


  public long getTpid() {
    return tpid;
  }

  public void setTpid(long tpid) {
    this.tpid = tpid;
  }


  public long getQbid() {
    return qbid;
  }

  public void setQbid(long qbid) {
    this.qbid = qbid;
  }


  public double getQuestionScore() {
    return questionScore;
  }

  public void setQuestionScore(double questionScore) {
    this.questionScore = questionScore;
  }


  public long getJudgeType() {
    return judgeType;
  }

  public void setJudgeType(long judgeType) {
    this.judgeType = judgeType;
  }

}
