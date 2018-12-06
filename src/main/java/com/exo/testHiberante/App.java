package com.exo.testHiberante;

import java.util.List;

import com.exo.testHiberante.dao.StudentDao;
import com.exo.testHiberante.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {       
            StudentDao studentDao = new StudentDao();

            Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");

            studentDao.saveStudent(student);

            List < Student > students = studentDao.getStudents();

            students.forEach(s -> System.out.println(s.getFirstName()));

        
    }
}
