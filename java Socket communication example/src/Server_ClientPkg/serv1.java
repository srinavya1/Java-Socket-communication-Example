package Server_ClientPkg;

//package Server_ClientPkg;

import java.net.*;
import java.io.*;

class Clie1 implements Runnable
{
	Thread t;
	Socket client;
	Clie1(Socket client)
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
				System.out.println(" "+st1);
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	public static void main(String args[]) throws IOException
	{
		try{
			System.out.println("Sending request to peer...");
			Socket client = new Socket("192.168.0.2"+ "",1300);
			System.out.println("Successfully connected");
			Clie1 c = new Clie1(client);
			BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
			PrintStream ps = new PrintStream(client.getOutputStream());
			while(true)
			{
				String s = br1.readLine();
				ps.println(s);
			}
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}
