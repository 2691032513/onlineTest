package com.controller;

import com.entity.*;
import com.entity.Class;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "register", method=RequestMethod.POST)
    @ResponseBody
    public boolean register(Student student){
        return studentService.addStudent(student);
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    @ResponseBody
    public boolean login(Student student, HttpSession session){
        System.out.println(student.getAccount());
        System.out.println(student.getPassword());
        student = studentService.searchStudent(student);
         if (student==null)
            return false;
         else{
             session.setAttribute("student",student);
             return true;
         }
    }

    @RequestMapping(value = "info")
    @ResponseBody
    public Student info(HttpSession session){
        Student student = (Student) session.getAttribute("student");
        return student;
    }

    @RequestMapping("showJointClass")
    @ResponseBody
    public List<Class> showJointClass(HttpSession session){
        Student student = (Student) session.getAttribute("student");
        return studentService.searchJointClass(student);
    }

    @RequestMapping("getCurrentExams")
    @ResponseBody
    public List<Exam> getCurrentExams(HttpSession session){
        Student student = (Student) session.getAttribute("student");
        return studentService.searchCurrentExams(student);
    }

    @RequestMapping("getHistoryExams")
    @ResponseBody
    public List<Exam> getHistoryExams(HttpSession session){
        Student student = (Student) session.getAttribute("student");
        return studentService.searchHistoryExams(student);
    }


    /*
    *   不完整,待优化,需求不明确的锅
    * */
    @RequestMapping("getWrongQuestionLists")
    @ResponseBody
    public List<Exam> getWrongQuestionLists(HttpSession session){
        Student student = (Student) session.getAttribute("student");
        return studentService.searchWrongQuestionLists(student);
    }

    @RequestMapping("startExam")
    @ResponseBody
    public boolean startExam(Exam exam, HttpSession session){
        Student student = (Student) session.getAttribute("student");
        return studentService.markExamStart(exam,student);
    }

    @RequestMapping("getExamInfo")
    @ResponseBody
    public TestPaper getExamInfo(Exam exam){
        return studentService.searchExamInfo(exam);
    }


    /*
    *  judgeQuestion module is incomplete
    * */
    @RequestMapping("submitExamAnswers")
    @ResponseBody
    public boolean submitExamAnswers(MidExamStudent midExamStudent, HttpSession session){
        Student student = (Student) session.getAttribute("student");
        return studentService.judgeQuestions(midExamStudent,student);
    }

    @RequestMapping("getTestedExams")
    @ResponseBody
    public List<Exam> geyTestedExam(HttpSession session){
        Student student = (Student) session.getAttribute("student");
        return studentService.searchTestedExams(student);
    }

    @RequestMapping("getWrongQuestionList")
    @ResponseBody
    public TestPaper getWrongQuestionList(Exam exam,HttpSession session){
        Student student = (Student) session.getAttribute("student");
        return studentService.searchWrongQuestionList(exam,student);
    }

}
