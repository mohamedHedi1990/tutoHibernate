package com.exo.testHiberante;

import java.util.List;

import com.exo.testHiberante.dao.StudentDao;
import com.exo.testHiberante.dao.UserDao;
import com.exo.testHiberante.entity.Student;
import com.exo.testHiberante.entity.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {       
            /*StudentDao studentDao = new StudentDao();

            Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");

            studentDao.saveStudent(student);

            List < Student > students = studentDao.getStudents();

            students.forEach(s -> System.out.println(s.getFirstName()));*/
      UserDao userDao = new UserDao();
      /*User user = new User();
      user.setLogin("admin");
      user.setPassword("admin123");
     
      userDao.saveUser(user);*/
      
      User user1 = userDao.getUserByLoginAndPassword("admin", "admin123");
      System.out.println("user1 :"+user1.getId());
      user1.setEmail("admin@leoni.tn");
      userDao.updateUser(user1);

        
    }
}
