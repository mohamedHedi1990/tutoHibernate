package com.exo.testHiberante.services;

import com.exo.testHiberante.dao.UserDao;
import com.exo.testHiberante.entity.User;

public class UserService {

  private UserDao userDao;

  public UserService() {
    userDao = new UserDao();
  }

  public boolean isAuthentified(String login, String password) {
    User user = userDao.getUserByLoginAndPassword(login, password);
    if (user != null) {
      return true;
    } else {
      return false;
    }
  }
}
