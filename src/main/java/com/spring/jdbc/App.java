package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Starting" );
        
        // Using the XML configuration
        
        /*
        		ApplicationContext con = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        */
        
        // Using the JAVA File Configuration
        
        
        ApplicationContext con = new AnnotationConfigApplicationContext(JdbcConfig.class);
        
        
        // By normal method of Inserting Data -> not a good practice
        
        /*
        
		        JdbcTemplate template = (JdbcTemplate) con.getBean("jdbctemplate");
		        
		        //insert query
		        
		        String query = "INSERT into student(id,name,city) values(?,?,?)";
		        
		        //firing the query
		        
		        int result = template.update(query, 2, "Anuradha", "London");
		        
		        System.out.println("Records inserted = " + result);
        
        */
        
        // -----------------------------------------------------------------------------------------
        
        // Good Practice
        
        // Insertion of Data
        
        
        /*
		        StudentDao st = (StudentDao) con.getBean("studentDao");
		        
		        Student student = new Student();
		        student.setId(4);
		        student.setName("Raj");
		        student.setCity("Punjab");
		        
		        
		        int result = st.insert(student);
		        System.out.println("Student added" + result);
        
        */
        
        // Updating the data
        
        /*
        
		        StudentDao st = (StudentDao) con.getBean("studentDao");
		        
		        Student student = new Student();
		        
		        student.setId(10);
		        student.setName("Peter");
		        student.setCity("Amsterdam");
		        
		        int result = st.change(student);
		        System.out.println("Student changed " + result);
        
        */
        
        
        // Deleting the data
        
        /*
        
		        StudentDao st = (StudentDao) con.getBean("studentDao");
		        
		        int result = st.delete(10);
		        
		        System.out.println("Deleted rows " + result);
        
        */
        
        
        // Selecting a single row from the database
        
        /*
        
        StudentDao st = (StudentDao) con.getBean("studentDao");
        
        Student student = st.getStudent(2);
        
        System.out.println(student);
        
        */
        
        
        // Selecting multiple rows from database
        
        StudentDao st = (StudentDao) con.getBean("studentDao");
        
        List<Student> students = st.getAllStudents();
        
        for(Student s:students) {
        	System.out.println(s);
        }
        
        
    }
}
