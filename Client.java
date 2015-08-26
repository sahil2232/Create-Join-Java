import java.net.*;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Client{
	public static void main(String args[]){
		try{
		//out.println("1");
		while(true){
			System.out.println("1.Poll\n2.Join\n0.Exit");	
			Socket clientSocket = new Socket("localhost",1234);
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch(choice){
				case 0:	out.close();
						in.close(); 
						clientSocket.close();
						return;
				case 1: out.println(1);break;
				case 2: out.println(2);break;
			}
		}
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
}
