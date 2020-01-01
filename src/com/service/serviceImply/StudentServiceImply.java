package com.service.serviceImply;

import com.dao.StudentDao;
import com.entity.*;
import com.entity.Class;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImply implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public Student searchStudent(Student student) {
        return studentDao.searchStudent(student);
    }

    @Override
    public boolean addStudent(Student student) {
        return studentDao.addStudent(student)==1;
    }

    @Override
    public List<Class> searchJointClass(Student student) {
        return studentDao.searchJointClass(student);
    }

    @Override
    public List<Exam> searchCurrentExams(Student student) {
        return studentDao.searchCurrentExams(student);
    }

    @Override
    public List<Exam> searchHistoryExams(Student student) {
        return studentDao.searchHistoryExams(student);
    }

    @Override
    public List<Exam> searchWrongQuestionLists(Student student) {
        return studentDao.searchWrongQuestionLists(student);
    }

    @Override
    public boolean markExamStart(Exam exam, Student student) {
        return studentDao.markExamStart(exam,student) == 1;
    }

    @Override
    public TestPaper searchExamInfo(Exam exam) {
        return studentDao.searchExamInfo(exam);
    }

    @Override
    public boolean judgeQuestions(MidExamStudent midExamStudent, Student student) {
        try {
            Exam exam = new Exam();
            exam.setId(midExamStudent.getEid());
            exam = studentDao.searchExamWithId(exam);
            TestPaper testPaper = studentDao.judgement(exam);
            double sum = 0.0;
            for (QuestionBank qb : testPaper.getQuestionBanks()) {
                for (Question q : qb.getQuestions()) {
                    sum += getScoreRate(midExamStudent.getAnswers(), q) * qb.getQuestionsScore();
                }
            }
            midExamStudent.setScore(sum);
            studentDao.markExamStudentScore(midExamStudent);
            studentDao.removeExamQuestion(midExamStudent);
            studentDao.addExamQuestion(midExamStudent.getAnswers());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private double getScoreRate(List<MidExamStudentQuestion> ms, Question q){

        String answers = null;

        for (MidExamStudentQuestion m: ms){
            if (m.getQid() == q.getId()){
                answers = m.getAnswers();
                break;
            }
        }

        if (q.getType().equals("单选题") ||q.getType().equals("判断题") ){
               return answers.equals(q.getAnswers())?0:1;
        }

        return 0;

    }

    @Override
    public List<Exam> searchTestedExams(Student student) {
        return studentDao.searchTestedExams(student);
    }

    @Override
    public TestPaper searchWrongQuestionList(Exam exam, Student student) {
        return studentDao.searchWrongQuestionList(exam,student);
    }

}
