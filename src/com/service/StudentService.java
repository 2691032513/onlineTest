package com.service;

import com.entity.*;
import com.entity.Class;

import java.util.List;

public interface StudentService {
    Student searchStudent(Student student);

    boolean addStudent(Student student);

    List<Class> searchJointClass(Student student);

    List<Exam> searchCurrentExams(Student student);

    List<Exam> searchHistoryExams(Student student);

    List<Exam> searchWrongQuestionLists(Student student);

    boolean markExamStart(Exam exam, Student student);

    TestPaper searchExamInfo(Exam exam);

    boolean judgeQuestions(MidExamStudent midExamStudent, Student student);

    List<Exam> searchTestedExams(Student student);

    TestPaper searchWrongQuestionList(Exam exam, Student student);
}
