package com.exo.testHiberante.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.exo.testHiberante.entity.User;
import com.exo.testHiberante.util.HibernateUtil;

public class UserDao {
  
  

  public User getUserByLoginAndPassword(String login, String password) {
    try {

      Session session = HibernateUtil.getSessionFactory().openSession();
      Query query = session.createQuery("from User where login=:login and password=:password");
      query.setParameter("login", login);
      query.setParameter("password", password);
      return (User) query.getSingleResult();
    } catch (Exception e) {

      e.printStackTrace();
      

    }
    return null;
  }
  
  public List<User> getAllUsers() {
    try {

      Session session = HibernateUtil.getSessionFactory().openSession();
      Query query = session.createQuery("from User");
      return query.getResultList();
    } catch (Exception e) {

      e.printStackTrace();

    }
    return null;
  }
  
  public void saveUser(User user)
  {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      session.save(user);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
  }
  
  public void deleteUser(User user)
  {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      session.delete(user);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
  }
  
  public void updateUser(User user)
  {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      session.update(user);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
  }
}
