package com.exo.testHiberante.services;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerService {

  
  public static void executeTask() {
    
    TimerTask repeatedTask = new TimerTask() {
      public void run() {
          System.out.println("Task performed on " + new Date());
      }
  };
  Timer timer = new Timer("Timer");
   
  long delay = 1000L;
 // long period = 1000L * 60L * 60L * 24L;
  long period=1000L;
  timer.scheduleAtFixedRate(repeatedTask, delay, period);
    
  }
}
