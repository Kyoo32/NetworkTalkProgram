//package hello;
import java.net.*;
import java.io.*;

public class TCPEchoServer {
	
	private static final int BUFSIZE = 32; // Size of receive buffer
	
	public static void main(String[] args) throws IOException{
		
		if(args.length != 1) //Test for correct # of args
			throw new IllegalArgumentException("Parameter(s) : <Port>");
		
		int servPort = Integer.parseInt(args[0]);
		
		//Create a server socket to accept client connection requests
		ServerSocket servSock = new ServerSocket(servPort);
		
		int recvMsgSize; //Size of received message
		byte[] bytebuffer = new byte[BUFSIZE]; //Receive buffer
		
		for (;;){ //Run forever, accepting and servicing connection
			Socket clntSock = servSock.accept(); //Get client connections
			
			System.out.println("Handing client at " + clntSock.getInetAddress().getHostAddress() + " on port"+ clntSock.getPort() );
			
			InputStream in = clntSock.getInputStream();
			OutputStream out = clntSock.getOutputStream();
			
			//Receive until client closes connection, indicated by -1 return
			while( (recvMsgSize = in.read(bytebuffer)) != -1)
				out.write(bytebuffer, 0, recvMsgSize);
			
			clntSock.close();
			
		}
	}
	
	
}
