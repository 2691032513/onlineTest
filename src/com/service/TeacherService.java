package com.service;

import com.entity.*;
import com.entity.Class;

import java.util.List;

public interface TeacherService {
    boolean register(Teacher teacher);

    Teacher searchTeacher(Teacher teacher);

    List<Class> searchCreatedClass(Teacher teacher);

    Class searchClassmates(Teacher teacher, Class clazz);

    List<Exam> searchClassExams(Class c, Teacher teacher);

    boolean joinStuToClass(List<MidClassStudent> mcsList, Teacher teacher);

    List<QuestionBank> searchCreatedQuestionBank(Teacher teacher);

    boolean addClass(Class c, Teacher teacher);

    boolean removeQuestionBank(QuestionBank questionBank, Teacher teacher);

    List<Question> searchQuestionsOfBQ(QuestionBank questionBank, Teacher teacher);

    boolean addQuestions(List<Question> questions, Teacher teacher);

    boolean removeQuestion(Question question, Teacher teacher);

    List<Exam> searchExams(Teacher teacher);

    boolean removeExam(Exam exam, Teacher teacher);

    List<TestPaper> searchTestPapers(Teacher teacher);

    boolean removeTestPaper(TestPaper testPaper, Teacher teacher);

    boolean addExam(Exam exam, Teacher teacher);

    List<QuestionBank> searchQuestionBanksWithType(QuestionBank questionBank, Teacher teacher);

    boolean bindTpWithQb(List<MidTpaperQbank> midTpaperQbanks, Teacher teacher);

    boolean bindQbWithQuestions(List<MidQbankQuestion> midQbankQuestions, Teacher teacher);

    boolean addTestPaper(TestPaper testPaper, Teacher teacher);

    boolean addQuestionBank(QuestionBank questionBank, Teacher teacher);
}
