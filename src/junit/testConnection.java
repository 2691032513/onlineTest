package junit;

import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.entity.*;
import com.entity.Class;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class testConnection {

    @Test
    public void testConnection(){

        ApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
        System.out.println(app);
        Student student = new Student();
        student.setId(1);
        StudentDao studentDao = app.getBean(StudentDao.class);
        Exam exam = new Exam();
        exam.setId(2);
        exam.setTpid(3);
        System.out.println(studentDao.searchWrongQuestionList(exam,student));

    }

    @Test
    public void teacherTest(){
        ApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
        Teacher teacher = new Teacher();
        TeacherDao dao = app.getBean(TeacherDao.class);
        Class c = new Class();
        Exam exam = new Exam();
        QuestionBank qb = new QuestionBank();
        c.setId(1);
        teacher.setAccount("123456");
        teacher.setPassword("123456");
        teacher.setRealName("handsomeRed");
        teacher.setSex("人妖");
        teacher.setId(1);

        List<Question> ql = new ArrayList<>();
        qb.setId(2);

        Question q1 = new Question();
        q1.setStem("树上骑个猴,地上一个monkey");
        q1.setAnswers("1");
        q1.setOptions("[1,2,3,4,5,6,7,8]");
        q1.setSjid(1);
        q1.setExplain("卖拐三部曲");
        q1.setType("选择题");
        ql.add(q1);

        List<MidClassStudent> midList = new ArrayList<>();
        MidClassStudent m1 = new MidClassStudent();
        m1.setCid(1);
        m1.setSid(2);
        midList.add(m1);
        q1.setId(4);
        c.setName("testCreateClass");
        c.setClassCode("231321321");
        exam.setId(3);

        TestPaper tp = new TestPaper();
        tp.setId(3);
        System.out.println(dao.removeTestPaper(tp,teacher));
    }



}
