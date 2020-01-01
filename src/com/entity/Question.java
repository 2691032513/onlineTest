package com.entity;


public class Question {

  private long id;
  private String stem;
  private String explain;
  private String type;
  private long sjid;
  private String options;
  private String answers;
  private long tid;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getStem() {
    return stem;
  }

  public void setStem(String stem) {
    this.stem = stem;
  }


  public String getExplain() {
    return explain;
  }

  public void setExplain(String explain) {
    this.explain = explain;
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


  public String getOptions() {
    return options;
  }

  public void setOptions(String options) {
    this.options = options;
  }


  public String getAnswers() {
    return answers;
  }

  public void setAnswers(String answers) {
    this.answers = answers;
  }


  public long getTid() {
    return tid;
  }

  public void setTid(long tid) {
    this.tid = tid;
  }

  @Override
  public String toString() {
    return "Question{" +
            "id=" + id +
            ", stem='" + stem + '\'' +
            ", explain='" + explain + '\'' +
            ", type='" + type + '\'' +
            ", sjid=" + sjid +
            ", options='" + options + '\'' +
            ", answers='" + answers + '\'' +
            ", tid=" + tid +
            '}';
  }
}
