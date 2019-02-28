package com.exo.testHiberante.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShowIP {
  public static void main(String []args)throws Exception  
  {    
      
     // checkHosts("192.168.3");
      
    /*long start = host2long("192.168.1.164");
      long end = host2long("192.168.1.172");
      for (long i=start; i<=end; i++) {
          System.out.println(long2dotted(i));
      }*/
    checkHosts("192.168.3.15" , "192.168.3.100");
  }
  
  public static void checkHosts(String subnet) throws UnknownHostException, IOException{
    int timeout=1000;
    for (int i=1;i<255;i++){
        String host=subnet + "." + i;
        if (InetAddress.getByName(host).isReachable(timeout)){
            System.out.println(host + " is reachable");
        }
    }
 }
  
  public static void checkHosts(String address1 , String address2) throws UnknownHostException, IOException{
    int timeout=1000;
    String [] arrOfaddress1  = address1.split("\\."); 
    String [] arrOfaddress2  = address2.split("\\."); 
    System.out.println("length   "+arrOfaddress1.length);
    Integer lastNumberOfAddress1= Integer.parseInt(arrOfaddress1[3]);
    Integer lastNumberOfAddress2= Integer.parseInt(arrOfaddress2[3]);
    
    for (int i=lastNumberOfAddress1;i<lastNumberOfAddress2;i++){
        String host= arrOfaddress1[0]+ "."+arrOfaddress1[1]+ "."+arrOfaddress1[2]+ "."+ + i;
        if (InetAddress.getByName(host).isReachable(timeout)){
            System.out.println(host + " is reachable");
        }
    }
 }
  
  public static long ip2long(InetAddress ip) {
    long l=0;
    byte[] addr = ip.getAddress();
    if (addr.length == 4) { //IPV4
        for (int i=0;i<4;++i) {
            l += (((long)addr[i] &0xFF) << 8*(3-i));
        }
    } else { //IPV6
        return 0;  // I dont know how to deal with these
    }
    return l;
}


public static long host2long(String host) {
    long ip=0;
    if (!Character.isDigit(host.charAt(0))) return -1;
    int[] addr = ip2intarray(host);
    if (addr == null) return -1;
    for (int i=0;i<addr.length;++i) {
        ip += ((long)(addr[i]>=0 ? addr[i] : 0)) << 8*(3-i);
    }
    return ip;
}

public static int[] ip2intarray(String host) {
    int[] address = {-1,-1,-1,-1};
    int i=0;
    StringTokenizer tokens = new StringTokenizer(host,".");
    if (tokens.countTokens() > 4) return null;
    while (tokens.hasMoreTokens()) {
        try {
            address[i++] = Integer.parseInt(tokens.nextToken()) & 0xFF;
        } catch(NumberFormatException nfe) {
            return null;
        }
    }
    return address;
}

public static String long2dotted(long address) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0, shift = 24; i < 4; i++, shift -= 8) {
        long value = (address >> shift) & 0xff;
        sb.append(value);
        if (i != 3) {
            sb.append('.');
        }
    }
    return sb.toString();
}
  
  public static void showIpAddress() throws IOException
  {

    // Create operating system process from arpe.bat file command
    ProcessBuilder pb = new ProcessBuilder("/home/exo/Desktop/folder/tutoHibernate/arp.sh");  

    pb.redirectErrorStream();
    // Starts a new process using the attributes of this process builder                            
    Process p = pb.start();       
       
    BufferedReader br = new BufferedReader (new InputStreamReader(p.getInputStream()));

    // String out is used to store output of this command(process)
    String out="";                                                             

    while(true)
    {
      String l=null;
      try 
      {
        l = br.readLine();
      } 
      catch (IOException ex) {}
      if(l==null)
        break;
      out+="\n"+l;
    }

    // A compiled representation of a regular expression
    Pattern pattern = 
Pattern.compile(".*\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b"); 

    /* An engine that performs match operations on a character sequence by interpreting a Pattern */
    Matcher match = pattern.matcher(out);     

    out="";
    String prev="",pLoc;

    if(!(match.find()))        // In case no IP address Found in out
      out="No IP found!";

    else
    {

      /* Returns the input subsequence matched by the previous match in this case IP of our interface */
      pLoc = match.group();  
                  
      out+=pLoc+"\nOther Hosts'(In Same Network) IP addresses:\n";
      while(match.find())  
      {
        pLoc = match.group(); // Returns the IP of other hosts
        out+=pLoc+"\n";
      }
      try 
      {
        br.close();
      } 
      catch (IOException ex) {}
    }

    // Printing IP Addresses of all computers in our network
    System.out.println(out);  
  }
}
