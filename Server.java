import java.net.*;
import java.io.*;
import java.lang.*;

public class Server{
	public static void main(String args[]){
		ServerSocket serverSocket=null;
		try{
		serverSocket=new ServerSocket(1234);
		}catch(Exception ex){
			//System.out.println(ex);
		}
		while(true){
			Socket socket=null;
			try{
			socket = serverSocket.accept();
			new ClientThread(socket);
			}catch(Exception ex){
				try{
				socket.close();
				}catch(Exception e){
					System.exit(1);
				}
				return;
				//System.out.println(ex);
			}
		}
	}
}
