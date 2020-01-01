package com.entity;


public class Exam {

  private long id;
  private String name;
  private long sjid;
  private long tid;
  private long cid;
  private long tpid;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp releaseTime;
  private java.sql.Time duration;
  private long maxSubmit;
  private TestPaper testPaper;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getTid() {
    return tid;
  }

  public void setTid(long tid) {
    this.tid = tid;
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


  public long getCid() {
    return cid;
  }

  public void setCid(long cid) {
    this.cid = cid;
  }


  public long getTpid() {
    return tpid;
  }

  public void setTpid(long tpid) {
    this.tpid = tpid;
  }


  public java.sql.Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Timestamp startTime) {
    this.startTime = startTime;
  }


  public java.sql.Timestamp getReleaseTime() {
    return releaseTime;
  }

  public void setReleaseTime(java.sql.Timestamp releaseTime) {
    this.releaseTime = releaseTime;
  }


  public java.sql.Time getDuration() {
    return duration;
  }

  public void setDuration(java.sql.Time duration) {
    this.duration = duration;
  }


  public long getMaxSubmit() {
    return maxSubmit;
  }

  public void setMaxSubmit(long maxSubmit) {
    this.maxSubmit = maxSubmit;
  }

  public TestPaper getTestPaper() {
    return testPaper;
  }

  public void setTestPaper(TestPaper testPaper) {
    this.testPaper = testPaper;
  }

  @Override
  public String toString() {
    return "Exam{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", sjid=" + sjid +
            ", cid=" + cid +
            ", tpid=" + tpid +
            ", startTime=" + startTime +
            ", releaseTime=" + releaseTime +
            ", duration=" + duration +
            ", maxSubmit=" + maxSubmit +
            '}';
  }
}
