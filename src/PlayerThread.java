import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class PlayerThread extends Thread {
	private Scanner sc=null;
	private PrintStream ps=null;
	boolean game;
	String list,name,allPoints[];
	int points;
	public PlayerThread(Socket s) {
		try {
			sc=new Scanner(s.getInputStream());
			ps=new PrintStream(s.getOutputStream(),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		game=false;
		list=null;
		name=sc.nextLine();
		points=0;
		allPoints=null;
	}
	
	public void run(){
		while(game!=true);
		ps.println("true");
		while(list==null);
		ps.println(list);
		while(!sc.hasNextLine());
		points=new Integer(sc.nextLine());
		game=false;
		while(game!=true);
		for(int i=0;i<allPoints.length;i++){
			ps.println(allPoints[i]);
		}
		sc.close();
	}

}
