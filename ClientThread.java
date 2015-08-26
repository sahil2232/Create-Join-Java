import java.lang.*;
import java.net.*;
import java.io.*;
public class ClientThread implements Runnable{
	Socket socket;
	BufferedReader in;
	PrintWriter pw;
	Thread thread;
	//int players;
	ClientThread(Socket socket)
	{
		try{
		this.socket=socket;
		in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream(),true);
		thread = new Thread(this);
		thread.start();
		}catch(NumberFormatException ex){
			System.out.println("Game Stopped !! Client Ran Away !! You Won");
			return;
		}
		catch(IOException ex){
			System.out.println("Connection Lost !! Restart Server");
			return;
		}
	}	
	
	public void run()
	{
		int request=-1;
		try{
		request = Integer.parseInt((in.readLine()).toString());
		}catch(Exception ex){
			//ex.printStackTrace();
			return;
		}
		if(request==1)
		{
			System.out.println("Thread " + Thread.currentThread().getId() + " Got a Poll Request" + " Exiting !!BYE!!");
			return;
		}
		else
		{
			System.out.println("Thread "+Thread.currentThread().getId()+" Got a Join Request" + " JOINING GAME !! WELCOME !!");
			while(true){
				//game loop
			}
		}
	}
}
