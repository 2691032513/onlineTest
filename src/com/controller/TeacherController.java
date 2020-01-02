package com.controller;

import com.entity.*;
import com.entity.Class;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public boolean register(Teacher teacher){
        return teacherService.register(teacher);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public boolean login(Teacher teacher, HttpSession session){
        Teacher te = teacherService.searchTeacher(teacher);
        if (te==null) return false;
        session.setAttribute("teacher",te);
        return true;

    }

    @RequestMapping("Info")
    @ResponseBody
    public Teacher getTeacherInfo(HttpSession session){
        return (Teacher) session.getAttribute("teacher");
    }

    @RequestMapping("getCreatedClass")
    @ResponseBody
    public List<Class> getCreatedClass(HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.searchCreatedClass(teacher);
    }

    @RequestMapping("getClassmates")
    @ResponseBody
    public Class getClassmates(Class clazz, HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.searchClassmates(teacher,clazz);
    }

    @RequestMapping(value = "getClassExams")
    @ResponseBody
    public List<Exam> getClassExams(Class c,HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.searchClassExams(c,teacher);
    }

    @RequestMapping("joinStudentToClass")
    @ResponseBody
    public boolean joinClassToClass(List<MidClassStudent> mcsList,HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.joinStuToClass(mcsList,teacher);
    }

    @RequestMapping(value = "createClass", method = RequestMethod.POST)
    @ResponseBody
    public boolean createClass(Class c, HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.addClass(c,teacher);
    }

    @RequestMapping("getCreatedQuestionBank")
    @ResponseBody
    public List<QuestionBank> getCreatedQuestionBank(HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.searchCreatedQuestionBank(teacher);
    }

    @RequestMapping("deleteQuestionBank")
    @ResponseBody
    public boolean deleteQuestionBank(QuestionBank questionBank, HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.removeQuestionBank(questionBank,teacher);
    }

    @RequestMapping("getQuestionsOfQB")
    @ResponseBody
    public List<Question> getQuestionsOfQB(QuestionBank questionBank,HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.searchQuestionsOfBQ(questionBank,teacher);
    }


    @RequestMapping("createQuestion")
    @ResponseBody
    public boolean createQuestion(List<Question> questions, HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.addQuestions(questions,teacher);
    }

    @RequestMapping("deleteQuestion")
    @ResponseBody
    public boolean deleteQuestion(Question question,HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.removeQuestion(question,teacher);
    }

    @RequestMapping("getExams")
    @ResponseBody
    public List<Exam> getExams(HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.searchExams(teacher);
    }

    @RequestMapping("deleteExam")
    @ResponseBody
    public boolean deleteExam(Exam exam, HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.removeExam(exam,teacher);
    }

    @RequestMapping("getTestPapers")
    @ResponseBody
    public List<TestPaper> getTestPapers(HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.searchTestPapers(teacher);
    }

    @RequestMapping("deleteTestPaper")
    @ResponseBody
    public boolean deleteTestPaper(TestPaper testPaper, HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.removeTestPaper(testPaper,teacher);
    }

    @RequestMapping("createExam")
    @ResponseBody
    public boolean createExam(Exam exam, HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.addExam(exam,teacher);
    }

    @RequestMapping("getQuestionBanksWithType")
    @ResponseBody
    public List<QuestionBank> getQuestionBanksWithType(QuestionBank questionBank, HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.searchQuestionBanksWithType(questionBank,teacher);
    }

    @RequestMapping("bindTpWithQb")
    @ResponseBody
    public boolean bindTpWithQb(List<MidTpaperQbank> midTpaperQbanks, HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.bindTpWithQb(midTpaperQbanks,teacher);
    }

    @RequestMapping("bindQbWithQuestion")
    @ResponseBody
    public boolean bindQbWithQuestion(List<MidQbankQuestion> midQbankQuestions, HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.bindQbWithQuestions(midQbankQuestions,teacher);
    }


    @RequestMapping("createTestPaper")
    @ResponseBody
    public boolean createTestPaper(TestPaper testPaper, HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.addTestPaper(testPaper,teacher);
    }

    @RequestMapping("createQuestionBank")
    @ResponseBody
    public boolean createQuestionBank(QuestionBank questionBank,HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherService.addQuestionBank(questionBank,teacher);
    }

}
