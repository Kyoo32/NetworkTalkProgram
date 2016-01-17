//package hello;
import java.net.*;


public class Address {
	public static void main(String[] args){
		//Get name and IP address of the local host
		try{
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("Local Host: \t" + address.getHostName() + "\t" + address.getHostAddress());
		} catch (UnknownHostException e){
			System.out.println("Unable to determine this host's address");
		}
			
		for(int i = 0; i<args.length; i++){
			
			try{
				//Get name(s)/address(es) of hosts given on commend-line
				InetAddress[] addressList = InetAddress.getAllByName(args[i]);
				System.out.println(args[i] + ":\t" + addressList[0].getHostName() );
				
				for(int j = 0; j < addressList.length; j++){
					System.out.println("\t"+ addressList[j].getHostAddress());
				}
			} catch (UnknownHostException e){
				System.out.println("Unable to find address for" + args[i]);
			}
		}
		
			
	}
}
