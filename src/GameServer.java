import java.util.Random;

public class GameServer extends Thread {
	private PlayerThread pt[]=null;
	private int players;
	private char[] array=null;
	private String points[];
	public GameServer(PlayerThread[] pt) {
		players=pt.length;
		this.pt=pt;
		points=new String[pt.length];
		initArray();
	}
	
	public void run(){
		for(int i=0;i<players;i++){
            pt[i].start();
			pt[i].game=true;
		}
		System.out.print("\nStarting Game Session...");
		for(int i=0;i<players;i++){
           pt[i].list=new String(array);
		}
		System.out.print("\nGame In Session...");
		while(pt[0].game==true);
		System.out.print("\nGame Summary:");
		while(pt[0].game!=false);
		for(int i=0;i<players;i++){
			points[i]=pt[i].name+":"+pt[i].points;
		}
		for(int i=0;i<players;i++){
				pt[i].allPoints=points;
		}
		
		for(int i=0;i<players;i++){
			pt[i].game=true;
		}
		System.out.print("\nGame Over.");
	
}

	void initArray(){
		array=new char[6];
		String conset="bcdfghjklmnpqrstvwxyz";
		String vowset="aeiou";
		Random r=new Random();
		int i=0;
		for(i=0;i<=2;i++)
			array[i]=vowset.charAt(r.nextInt(vowset.length()));
		for(;i<=5;i++)
			array[i]=conset.charAt(r.nextInt(conset.length()));
		//shuffle
		shuffle(array);
	}
	
	void shuffle(char array[]){
		Random r=new Random();
		for (int i1 = array.length - 1; i1 > 0; i1--)
	    {
	      int index = r.nextInt(i1 + 1);
	      // Simple swap
	      char a = array[index];
	      array[index] = array[i1];
	      array[i1] = a;
	    }
	}

}
