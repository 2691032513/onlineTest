package com.service.serviceImply;

import com.dao.TeacherDao;
import com.entity.*;
import com.entity.Class;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImply implements TeacherService {

    @Autowired
    TeacherDao teacherDao;

    @Override
    public boolean register(Teacher teacher) {
        return teacherDao.register(teacher) == 1;
    }

    @Override
    public Teacher searchTeacher(Teacher teacher) {
        return teacherDao.searchTeacher(teacher);
    }

    @Override
    public List<Class> searchCreatedClass(Teacher teacher) {
        return teacherDao.searchCreatedClass(teacher);
    }

    @Override
    public Class searchClassmates(Teacher teacher, Class clazz) {
        return teacherDao.searchClassmates(teacher,clazz);
    }

    @Override
    public List<Exam> searchClassExams(Class c, Teacher teacher) {
        return teacherDao.searchClassExams(c,teacher);
    }

    @Override
    public boolean joinStuToClass(List<MidClassStudent> mcsList, Teacher teacher) {
        try {
            return teacherDao.addStudentToClass(mcsList,teacher)!=0;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<QuestionBank> searchCreatedQuestionBank(Teacher teacher) {
        return teacherDao.searchCreatedQuestionBank(teacher);
    }

    @Override
    public boolean addClass(Class c, Teacher teacher) {
        return teacherDao.addClass(c,teacher)==1;
    }

    @Override
    public boolean removeQuestionBank(QuestionBank questionBank, Teacher teacher) {
        try {
            return teacherDao.removeQuestionBank(questionBank,teacher) > 0;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public List<Question> searchQuestionsOfBQ(QuestionBank questionBank, Teacher teacher) {
        return teacherDao.searchQuestionsOfQB(questionBank,teacher);
    }

    @Override
    public boolean addQuestions(List<Question> question, Teacher teacher) {
        try {
            return teacherDao.addQuestions(question,teacher)>0;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean removeQuestion(Question question, Teacher teacher) {
        return teacherDao.removeQuestion(question,teacher)>0;
    }

    @Override
    public List<Exam> searchExams(Teacher teacher) {

        return teacherDao.searchExams(teacher);
    }

    @Override
    public boolean removeExam(Exam exam, Teacher teacher) {
        try {
            return teacherDao.removeExam(exam,teacher)>0;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public List<TestPaper> searchTestPapers(Teacher teacher) {
        return teacherDao.searchTestPapers(teacher);
    }

    @Override
    public boolean removeTestPaper(TestPaper testPaper, Teacher teacher) {
        return teacherDao.removeTestPaper(testPaper,teacher)>0;
    }

    /*
    * 发布exam同时,bind->Exam*Student
    * */
    @Override
    public boolean addExam(Exam exam, Teacher teacher) {
        Class c = new Class();
        c.setId(exam.getCid());
        List<Student> students = teacherDao.searchClassmates(teacher,c).getStudentList();
        return teacherDao.addExam(exam,teacher)>0 && teacherDao.bindExamWithStudent(students,exam)>0;
    }

    @Override
    public List<QuestionBank> searchQuestionBanksWithType(QuestionBank questionBank, Teacher teacher) {
        return teacherDao.searchQuestionBanksWithType(questionBank,teacher);
    }

    @Override
    public boolean bindTpWithQb(List<MidTpaperQbank> midTpaperQbanks, Teacher teacher) {
        try {
            return teacherDao.bindTpWithQb(midTpaperQbanks,teacher)>0;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean bindQbWithQuestions(List<MidQbankQuestion> midQbankQuestions, Teacher teacher) {
        return teacherDao.bindQbWithQuestion(midQbankQuestions,teacher)>0;
    }

    @Override
    public boolean addTestPaper(TestPaper testPaper, Teacher teacher) {
        return teacherDao.addTestPaper(testPaper,teacher)>0;
    }

    @Override
    public boolean addQuestionBank(QuestionBank questionBank, Teacher teacher) {
        return teacherDao.addQuestionBank(questionBank,teacher)>0;
    }

}
