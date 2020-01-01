package com.dao;

import com.entity.*;
import com.entity.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

    Student searchStudent(@Param("student") Student student);

    int addStudent(@Param("student") Student student);

    List<Class> searchJointClass(@Param("student") Student student);

    List<Exam> searchCurrentExams(@Param("student") Student student);

    List<Exam> searchHistoryExams(@Param("student") Student student);

    List<Exam> searchWrongQuestionLists(@Param("student") Student student);

    int markExamStart(@Param("exam") Exam exam, @Param("student") Student student);

    TestPaper searchExamInfo(@Param("exam") Exam exam);

    TestPaper judgement(@Param("exam") Exam exam);

    List<Exam> searchTestedExams(@Param("student") Student student);

    Exam searchExamWithId(@Param("exam") Exam exam);

    TestPaper searchWrongQuestionList(@Param("exam") Exam exam, @Param("student") Student student);

    int markExamStudentScore(@Param("m") MidExamStudent midExamStudent);

    int removeExamQuestion(@Param("mid") MidExamStudent midExamStudent);

    int addExamQuestion(@Param("ms") List<MidExamStudentQuestion> answers);
}
