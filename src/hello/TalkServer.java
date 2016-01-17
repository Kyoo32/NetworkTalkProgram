//package hello;

import java.net.*;
import java.nio.CharBuffer;
import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.*;
import java.util.regex.Pattern;;


public class TalkServer implements Runnable {
	
	private static final int BUFSIZE = 32; // Size of receive buffer

	  private Socket connection;
	  private String TimeStamp;
	  private int ID;
	  public static void main(String[] args) {
		 int port = 1234;
		 int count = 0;
		  
		 try{
		      ServerSocket socket1 = new ServerSocket(port);
		      System.out.println("MultipleSocketServer Initialized");
		      
		      while (true) {
		    	System.out.println("log1");
		        Socket connection = socket1.accept();
		        Runnable runnable = new TalkServer(connection, ++count);
		        Thread thread = new Thread(runnable);
		        thread.start();
		       }
		 } catch (Exception e) {}
		  
	  }
		  
		  
	TalkServer(Socket s, int i) {
		  this.connection = s;
		  this.ID = i;
	}
	
		public void run() {
			
			System.out.println("log2");
		    try {
		      BufferedInputStream is = new BufferedInputStream(connection.getInputStream());
		      InputStreamReader isr = new InputStreamReader(is);
		      int character;
		      StringBuffer process = new StringBuffer();
		     
		      while((character = isr.read()) != 13) {
		        process.append((char)character);
		      }
		      System.out.println(process);
		      //need to wait 10 seconds to pretend that we're processing something
		      try {
		        Thread.sleep(50);
		      } catch (Exception e){}
		      TimeStamp = new java.util.Date().toString();
		      String forName = process.toString();
		      String requestWord[] = forName.split(" ");
		      Thread.currentThread().setName(requestWord[0]);
		      System.out.println("!!!!" + Thread.currentThread().getName());
		      Thread[] whosIn = this.getAllThreads();
		      int howMany = Thread.activeCount();
		     
		      System.out.println(howMany);
		   	      
		      String greeting =  requestWord[0] + " enters at "+ TimeStamp ;
		      for(int i=1; i < howMany ; i++){
		    	  greeting = greeting + whosIn[i].getName();
		      }
		      greeting = greeting + (char) 13;
		      BufferedOutputStream os = new BufferedOutputStream(connection.getOutputStream());
		      OutputStreamWriter osw = new OutputStreamWriter(os, "US-ASCII");
		      System.out.println("log3");
		      osw.write(greeting);
		      osw.flush();
		    
		      
		      
//		      try {
//			        Thread.sleep(1000);
//			      } catch (Exception e){} 
//		      int character2;
//		      StringBuffer userInput = new StringBuffer();
//		      System.out.println("log4");
//		      for(;;){
//		    	  System.out.println("lla");
//			      is.reset();
//			      is.mark(32);
//		    	  
//			      while((character2 = is.read())!=-1){
//			    	  while((character2 = isr.read()) != 13 && character2 != -1) {
//				    	  System.out.println("sw");
//				        userInput.append((char)character2);
//				        if(character2 == -1) break;
//				      }
//				      if(character2 == -1) break;
//				      System.out.println(userInput);
//			      };
//		      }
//		      System.out.println("log5");
		      
		    }
		    catch (Exception e) {
		      System.out.println(e);
		    }
		    finally {
		      try {
		        connection.close();
		     }
		      catch (IOException e){}
		    }
		}
		
		
		
		Thread[] getAllThreads( ) {
		    final ThreadGroup root = getRootThreadGroup( );
		    final ThreadMXBean thbean = ManagementFactory.getThreadMXBean( );
		    int nAlloc = thbean.getThreadCount( );
		    int n = 0;
		    Thread[] threads;
		    do {
		        nAlloc *= 2;
		        threads = new Thread[ nAlloc ];
		        n = root.enumerate( threads, true );
		    } while ( n == nAlloc );
		    return java.util.Arrays.copyOf( threads, n );
		}
		
		ThreadGroup rootThreadGroup = null;
		 
		ThreadGroup getRootThreadGroup( ) {
		    if ( rootThreadGroup != null )
		        return rootThreadGroup;
		    ThreadGroup tg = Thread.currentThread( ).getThreadGroup( );
		    ThreadGroup ptg;
		    while ( (ptg = tg.getParent( )) != null )
		        tg = ptg;
		    return tg;
		}

}


