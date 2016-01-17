//package hello;
import java.net.*;
import java.io.*;

public class TCPEchoClient {
	public static void main(String[] args) throws IOException{
		
		if( (args.length < 2) || (args.length > 3) ) //Test for correct # of args
			throw new IllegalArgumentException("Parameter(s): <Server><Word> [<Port>]");
		
		String server = args[0]; //Server name or IP address
		//Convert input String to bytes using the default character encoding
		byte[] bytebuffer = args[1].getBytes();
		
		int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;
		
		//Create socket that is connected to server on specified port
		Socket socket = new Socket(server, servPort);
		System.out.println("Connected to server... Sending echo string");
		
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		
		out.write(bytebuffer); //Send the encoded string to the server
		
		//Receive the same string back from the server
		int totalBytesRcvd = 0; //Total bytes received so far
		int bytesRcvd;
		
		while( totalBytesRcvd < bytebuffer.length ){
			if( (bytesRcvd = in.read(bytebuffer, totalBytesRcvd, (bytebuffer.length - totalBytesRcvd) )) == -1)
				throw new SocketException("Connection close prematurely");
			totalBytesRcvd += bytesRcvd;
		}
		
		System.out.println("Received: " + new String(bytebuffer));
		
		socket.close();
	}
}
