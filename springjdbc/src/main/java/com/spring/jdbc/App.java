package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.Studentdao;
import com.spring.jdbc.entites.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program Strated ............." );
        // Spring jdbc=> JdbcTemplate
//        ApplicationContext context= new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml"); 
        ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
          Studentdao studentdao= context.getBean("studentdao",Studentdao.class);
          // INSERT
//          Student student=new Student();
//          student.setId(66);
//          student.setName("Krishna");
//          student.setCity("Jaipur");
//         int result= studentdao.insert(student);
//         System.out.println("Student Added:"+result);
          
          //Update
          
//          Student student =new Student();
//          student.setId(467);
//          student.setName("Raju");
//          student.setCity("Agra");
//          int result=studentdao.change(student);
//          System.out.println("Data Changed"+ result);
          
         // DELETE
//          int result=studentdao.delete(245);
//          System.out.println("Deleted"+"result");
          
//          Student student = studentdao.getStudent(467);
//          System.out.println(student);
          
          List<Student> students = studentdao.getAllStudents();
          System.out.println(students);
          for(Student s :students)
          {
        	  System.out.println(s);
          }
    }
}
