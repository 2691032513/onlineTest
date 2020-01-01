package com.dao;

import com.entity.*;
import com.entity.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {
    int register(@Param("teacher") Teacher teacher);

    Teacher searchTeacher(@Param("teacher") Teacher teacher);

    List<Class> searchCreatedClass(@Param("teacher") Teacher teacher);

    Class searchClassmates(@Param("teacher") Teacher teacher,@Param("class") Class clazz);

    List<Exam> searchClassExams(@Param("class") Class c, @Param("teacher") Teacher teacher);

    /*
    *    未解决越权问题 class of teacher?
    * */
    int addStudentToClass(@Param("midList") List<MidClassStudent> mcsList,@Param("teacher") Teacher teacher);

    List<QuestionBank> searchCreatedQuestionBank(@Param("teacher") Teacher teacher);

    int addClass(@Param("class") Class c, @Param("teacher") Teacher teacher);

    int removeQuestionBank(@Param("qb") QuestionBank questionBank, @Param("teacher") Teacher teacher);

    List<Question> searchQuestionsOfQB(@Param("qb") QuestionBank  questionBank, @Param("teacher") Teacher teacher);

    int addQuestions(@Param("questions") List<Question> questions,@Param("teacher") Teacher teacher);

    int removeQuestion(@Param("question") Question question, @Param("teacher") Teacher teacher);

    List<Exam> searchExams(@Param("teacher") Teacher teacher);

    int removeExam(@Param("exam") Exam exam, @Param("teacher") Teacher teacher);

    List<TestPaper> searchTestPapers(@Param("teacher") Teacher teacher);

    int removeTestPaper(@Param("testPaper")TestPaper testPaper, @Param("teacher") Teacher teacher);

    int addExam(@Param("exam") Exam exam, @Param("teacher") Teacher teacher);

    List<QuestionBank> searchQuestionBanksWithType(@Param("qb") QuestionBank questionBank, @Param("teacher") Teacher teacher);

    int bindTpWithQb(@Param("ms") List<MidTpaperQbank> midTpaperQbanks, @Param("teacher") Teacher teacher);

    int bindQbWithQuestion(@Param("ms") List<MidQbankQuestion> midQbankQuestions, @Param("teacher") Teacher teacher);

    int bindExamWithStudent(@Param("ss") List<Student> students, @Param("exam") Exam exam);
}
