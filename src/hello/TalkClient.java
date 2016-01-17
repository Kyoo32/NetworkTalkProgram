//package hello;

import java.net.*;
/* The java.io package contains the basics needed for IO operations. */
import java.io.*;

/** The SocketClient class is a simple example of a TCP/IP Socket Client.
 *
 */

public class TalkClient {

	 public static void main(String[] args) {
		 
		 
		if( (args.length < 0) || (args.length > 1) ) //Test for correct # of args
				throw new IllegalArgumentException("Parameter(s): <NickName> ");
		
	    /** Define a host server */
	    String host = "localhost";
	    /** Define a port */
	    int port = 1234;

	    StringBuffer instr = new StringBuffer();
	    String TimeStamp;
	    String nickName = args[0];
	    System.out.println("SocketClient initialized");

	    try {
	        /** Obtain an address object of the server */
	        InetAddress address = InetAddress.getByName(host);
	        /** Establish a socket connection */
	        Socket connection = new Socket(address, port);
	        System.out.println("log1");
	        /** Instantiate a BufferedOutputStream object */
	        BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
	
	        /** Instantiate an OutputStreamWriter object with the optional character
	         * encoding.
	         */
	        OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII");
	        
	        TimeStamp = new java.util.Date().toString();
	       String process = nickName + " Calling the Socket Server on "+ host + " port " + port +   " at " + TimeStamp +  (char) 13;

	       System.out.println("log2");
	        /** Write across the socket connection and flush the buffer */
	        osw.write(process);
	        osw.flush();
	        
	        /** Instantiate a BufferedInputStream object for reading
	        /** Instantiate a BufferedInputStream object for reading
	         * incoming socket streams.
	         */

	        BufferedInputStream bis = new BufferedInputStream(connection.
	            getInputStream());
	        /**Instantiate an InputStreamReader with the optional
	         * character encoding.
	         */

	        InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");

	        /**Read the socket's InputStream and append to a StringBuffer */
	        int c;
	        while ( (c = isr.read()) != 13)
	          instr.append( (char) c);
	        System.out.println("log3");
	        System.out.println(instr);
	        
	        String userInput;
	        while(true){
	        System.out.println("log4");
	        BufferedReader brUser = new BufferedReader(new InputStreamReader(System.in)); //Here you declare your BufferedReader object and instance it.
	        userInput = brUser.readLine();
	        userInput = userInput + (char)13;
	        System.out.println(userInput);
	        osw.write(userInput);
	        	if(userInput.length() <1) break;
	        } 
	        /** Close the socket connection. */
	        connection.close();
	        
	        
	    } catch (IOException f) {
	        System.out.println("IOException: " + f);
	    } catch (Exception g) {
	        System.out.println("Exception: " + g);
	    }
	   }
}
