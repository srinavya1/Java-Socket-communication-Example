package Server_ClientPkg;

import java.net.*;
import java.io.*;

class serv1 implements Runnable
{
	Thread t;
	Socket client;
	serv1(Socket client)
	{
		this.client=client;
		t=new Thread(this);
		t.start();
	}
	public void run(){
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			while(true)
			{
				String st1=br.readLine();
				System.out.println("Client: "+st1);
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	public static void main(String args[]) throws IOException
	{
		//try{
			ServerSocket server = new ServerSocket(1300);
			System.out.println("Waiting for request from peer...");
			Socket client = server.accept();
			serv1 s = new serv1(client);
			System.out.println("Request accepted");
			BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
			PrintStream ps2 = new PrintStream(client.getOutputStream());
			while(true)
			{
				String st= br2.readLine();
				ps2.println("Server: "+ st);
			}
		//}
		/*catch(IOException e){
			System.out.println(e);
		}*/
	}
}
