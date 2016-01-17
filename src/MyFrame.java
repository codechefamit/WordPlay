import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JFormattedTextField;
import javax.swing.Timer;

import java.awt.event.KeyAdapter;
public class MyFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private char array[]=null;
	private JButton btn1,btn2,btn3,btn4,btn5,btn6;
	private JList <String>list2,list3;
	private JList <String> list3_1;
	private DefaultListModel<String> listModel2,listModel3,listModel4,listModel5,listModel6,listAllModel,listModelGame;
	private JFormattedTextField formattedTextField,textPort,textHost,textName;
	private SpellCheck sc;
	private String arr,del;
	private int point;
	private JLabel lblPoints,lblTime;
	private JButton btnSeeAll,btnConnect,btnStart;
	private Timer timer,countdown;
	private int time,count;
	private StartAction sa;
	private JLabel lblLetters;
	private JLabel lblLetter;
	private JScrollPane scrollPane_1;
	private JLabel lblLetter_1;
	private JScrollPane scrollPane_2;
	private JList<String> list4;
	private JList<String> list4_1;
	private JLabel lblLetter_2;
	private JScrollPane scrollPane_3;
	private JList<String> list5;
	private JList<String> list5_1;
	private JLabel lblLetter_3;
	private JScrollPane scrollPane_4;
	private JList<String> list6;
	private JList<String> list6_1;
	private JLabel lbl2letter;
	private JLabel lbl3letter;
	private JLabel lbl4letter;
	private JLabel lbl5letter;
	private JLabel lbl6letter;
	private int l2,l3,l4,l5,l6;
	private JScrollPane scrollPane_5;
	private JList <String> listAll;
	private JLabel lblSeeWhatYou;
	private JLabel lblPort,lblStatus,lblHost;
	private Socket s;
	private Scanner scr;
	private PrintStream ps;
	private boolean game;
	private JFormattedTextField textSPort;
	private JLabel lblServerStatus;
	private JFormattedTextField textPlayer;
	private JLabel lblPlayer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.setTitle("Word Power by Amit Kothiyal");
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setSize(650,585);
					frame.setResizable(false);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMakeAWord = new JLabel("Word Power");
		lblMakeAWord.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMakeAWord.setBounds(226, 29, 195, 33);
		contentPane.add(lblMakeAWord);
		point=0;
		listModel2=new DefaultListModel<String>();
		listModel3=new DefaultListModel<String>();
		listModel4=new DefaultListModel<String>();
		listModel5=new DefaultListModel<String>();
		listModel6=new DefaultListModel<String>();
		listAllModel=new DefaultListModel<String>();
		listModelGame=new DefaultListModel<String>();
		del=null;
		sc=new SpellCheck();
		time=60;
		l2=l3=l4=l5=l6=0;
		s=null;
		count=5;
		game=false;
		btn1 = new JButton();
		btn1.setForeground(Color.BLACK);
		btn1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn1.setBackground(new Color(255, 250, 205));
		btn1.setBounds(40, 100, 50, 50);
		btn1.setFocusable(false);
		contentPane.add(btn1);
		
		btn2 = new JButton();
		btn2.setForeground(Color.BLACK);
		btn2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn2.setBackground(new Color(255, 250, 205));
		btn2.setBounds(101, 100, 50, 50);
		btn2.setFocusable(false);
		contentPane.add(btn2);
		
		btn3 = new JButton();
		btn3.setForeground(Color.BLACK);
		btn3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn3.setBackground(new Color(255, 250, 205));
		btn3.setBounds(161, 100, 50, 50);
		btn3.setFocusable(false);
		contentPane.add(btn3);
		
		btn4 = new JButton();
		btn4.setForeground(Color.BLACK);
		btn4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn4.setBackground(new Color(255, 250, 205));
		btn4.setBounds(161, 161, 50, 50);
		btn4.setFocusable(false);
		contentPane.add(btn4);
		
		btn5 = new JButton();
		btn5.setForeground(Color.BLACK);
		btn5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn5.setBackground(new Color(255, 250, 205));
		btn5.setBounds(40, 161, 50, 50);
		btn5.setFocusable(false);
		contentPane.add(btn5);
		
		btn6 = new JButton();
		btn6.setForeground(Color.BLACK);
		btn6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn6.setBackground(new Color(255, 250, 205));
		btn6.setBounds(101, 161, 50, 50);
		btn6.setFocusable(false);
		contentPane.add(btn6);
		
		sa=new StartAction();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 100, 50, 100);
		scrollPane.setAutoscrolls(true);
		contentPane.add(scrollPane);
		scrollPane.setFocusable(false);
		list2 = new JList<String>(listModel2);
		list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list2.setFont(new Font("Tahoma", Font.BOLD, 16));
		list2.setAutoscrolls(true);
		scrollPane.setViewportView(list2);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String txt=formattedTextField.getText();
				if(sc.check(txt) && txt.length()!=1){
					if(txt.length()==2 && !listModel2.contains(txt)){
						listModel2.addElement(txt);
						list2.ensureIndexIsVisible(listModel2.getSize()-1);
						point=point+(txt.length()*2);
					}
					if(txt.length()==3 && !listModel3.contains(txt)){
						listModel3.addElement(txt);
						list3.ensureIndexIsVisible(listModel3.getSize()-1);
						point=point+(txt.length()*3);
					}
					if(txt.length()==4 && !listModel4.contains(txt)){
						listModel4.addElement(txt);
						list4.ensureIndexIsVisible(listModel4.getSize()-1);
						point=point+(txt.length()*4);
					}
					if(txt.length()==5 && !listModel5.contains(txt)){
						listModel5.addElement(txt);
						list5.ensureIndexIsVisible(listModel5.getSize()-1);
						point=point+(txt.length()*5);
					}
					if(txt.length()==6 && !listModel6.contains(txt)){
						listModel6.addElement(txt);
						list6.ensureIndexIsVisible(listModel6.getSize()-1);
						point=point+(txt.length()*6);
					}
					lblPoints.setText("Points:"+point);
					formattedTextField.setText(null);
					arr=new String(array);
					del=null;
				}
				else
				{
					Toolkit.getDefaultToolkit().beep();
					formattedTextField.setText(null);
					arr=new String(array);
					del=null;
				}
			}
		});
		formattedTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				char c=event.getKeyChar();
				if(arr.indexOf(c)==-1 && c!=KeyEvent.VK_BACK_SPACE){
					event.consume();
				}
				else if(c==KeyEvent.VK_BACK_SPACE){
					char d=del.charAt(del.length()-1);
					arr=arr+d;
					del=del.replace(new Character(d).toString(), "");
				}
				else{
					del=del+c;
					arr=arr.replaceFirst(new Character(c).toString(), "");
				}
			}
			
			public void keyReleased(KeyEvent event) {
				char c=event.getKeyChar();
				if(timer.isRunning())
				{
					if(c==KeyEvent.VK_SPACE)
					{
						shuffle(array);
						btn1.setText(new Character(array[0]).toString().toUpperCase());
						btn2.setText(new Character(array[1]).toString().toUpperCase());
						btn3.setText(new Character(array[2]).toString().toUpperCase());
						btn4.setText(new Character(array[3]).toString().toUpperCase());
						btn5.setText(new Character(array[4]).toString().toUpperCase());
						btn6.setText(new Character(array[5]).toString().toUpperCase());
					}
				}
			}
			
		});
		formattedTextField.setEditable(false);
		formattedTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		formattedTextField.setBounds(20, 237, 231, 40);
		contentPane.add(formattedTextField);
		
		lblPoints = new JLabel("Points :");
		lblPoints.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPoints.setBounds(393, 325, 130, 27);
		contentPane.add(lblPoints);
		
		
		
		lblTime = new JLabel("Time Left : 60 sec's");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTime.setBounds(52, 288, 175, 27);
		contentPane.add(lblTime);
		
		JLabel lblHitSpacebarTo = new JLabel("Hit Spacebar to shuffle words.");
		lblHitSpacebarTo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHitSpacebarTo.setBounds(10, 326, 272, 27);
		contentPane.add(lblHitSpacebarTo);
		
		lblLetters = new JLabel("2 letter");
		lblLetters.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLetters.setBounds(300, 73, 50, 27);
		contentPane.add(lblLetters);
		
		lblLetter = new JLabel("3 letter");
		lblLetter.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLetter.setBounds(360, 73, 50, 27);
		contentPane.add(lblLetter);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(360, 100, 50, 100);
		contentPane.add(scrollPane_1);
		list3 = new JList<String>();
		list3_1 = new JList<String>(listModel3);
		list3_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		list3_1.setAutoscrolls(true);
		scrollPane_1.setViewportView(list3_1);
		
		lblLetter_1 = new JLabel("4 letter");
		lblLetter_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLetter_1.setBounds(420, 73, 50, 27);
		contentPane.add(lblLetter_1);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(420, 100, 60, 100);
		contentPane.add(scrollPane_2);
		
		list4 = new JList<String>();
		list4_1 = new JList<String>(listModel4);
		list4_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		list4_1.setAutoscrolls(true);
		scrollPane_2.setViewportView(list4_1);
		
		lblLetter_2 = new JLabel("5 letter");
		lblLetter_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLetter_2.setBounds(490, 73, 50, 27);
		contentPane.add(lblLetter_2);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(490, 100, 60, 100);
		contentPane.add(scrollPane_3);
		
		list5 = new JList<String>();
		list5_1 = new JList<String>(listModel5);
		list5_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		list5_1.setAutoscrolls(true);
		scrollPane_3.setViewportView(list5_1);
		
		lblLetter_3 = new JLabel("6 letter");
		lblLetter_3.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLetter_3.setBounds(560, 73, 50, 27);
		contentPane.add(lblLetter_3);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(560, 100, 60, 100);
		contentPane.add(scrollPane_4);
		
		list6 = new JList<String>();
		list6_1 = new JList<String>(listModel6);
		list6_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list6_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		list6_1.setAutoscrolls(true);
		scrollPane_4.setViewportView(list6_1);
		
		lbl2letter = new JLabel("");
		lbl2letter.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl2letter.setBounds(300, 199, 40, 27);
		contentPane.add(lbl2letter);
		
		lbl3letter = new JLabel("");
		lbl3letter.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl3letter.setBounds(360, 199, 40, 27);
		contentPane.add(lbl3letter);
		
		lbl4letter = new JLabel("");
		lbl4letter.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl4letter.setBounds(425, 199, 40, 27);
		contentPane.add(lbl4letter);
		
		lbl5letter = new JLabel("");
		lbl5letter.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl5letter.setBounds(495, 199, 40, 27);
		contentPane.add(lbl5letter);
		
		lbl6letter = new JLabel("");
		lbl6letter.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl6letter.setBounds(565, 199, 40, 27);
		contentPane.add(lbl6letter);
		
		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(540, 230, 80, 120);
		contentPane.add(scrollPane_5);
		
		listAll = new JList<String>(listAllModel);
		listAll.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAll.setFont(new Font("Tahoma", Font.BOLD, 16));
		listAll.setAutoscrolls(true);
		scrollPane_5.setViewportView(listAll);
		
		btnSeeAll = new JButton("See All Words");
		btnSeeAll.setEnabled(false);
		btnSeeAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				scrollPane_5.setVisible(true);
			}
		});
		btnSeeAll.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSeeAll.setBounds(393, 275, 140, 33);
		contentPane.add(btnSeeAll);
		
		lblSeeWhatYou = new JLabel("See What You Missed:");
		lblSeeWhatYou.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSeeWhatYou.setBounds(368, 237, 165, 27);
		contentPane.add(lblSeeWhatYou);
		
		JLabel lblCopyrightcAmit = new JLabel("Developed By : Amit Kothiyal | Copyright (C), All rights reserved");
		lblCopyrightcAmit.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblCopyrightcAmit.setBounds(350, 0, 284, 27);
		contentPane.add(lblCopyrightcAmit);
		
		textHost = new JFormattedTextField();
		textHost.setFont(new Font("Tahoma", Font.BOLD, 14));
		textHost.setBounds(100, 375, 150, 30);
		contentPane.add(textHost);
		textHost.setColumns(10);
		
		lblHost = new JLabel("Host   :");
		lblHost.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHost.setBounds(10, 375, 71, 27);
		contentPane.add(lblHost);
		
		try {
			textPort = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		textPort.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPort.setColumns(10);
		textPort.setBounds(100, 455, 150, 30);
		contentPane.add(textPort);
		
		lblPort = new JLabel("Port    :");
		lblPort.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPort.setBounds(10, 455, 75, 27);
		contentPane.add(lblPort);
		
		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				statusChange();
			}
		});
		btnConnect.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConnect.setBounds(151, 496, 100, 25);
		contentPane.add(btnConnect);
		
		lblStatus = new JLabel("Status : Not Connected");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStatus.setBounds(10, 524, 565, 27);
		contentPane.add(lblStatus);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(10, 415, 71, 27);
		contentPane.add(lblName);
		
		textName = new JFormattedTextField();
		textName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textName.setColumns(10);
		textName.setBounds(100, 415, 150, 30);
		contentPane.add(textName);
		
		JLabel label = new JLabel("Port    :");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(300, 397, 75, 27);
		contentPane.add(label);
		
		JLabel lblStartServer = new JLabel("Start Server :");
		lblStartServer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStartServer.setBounds(300, 363, 150, 27);
		contentPane.add(lblStartServer);
		
		
		try {
			textSPort = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		textSPort.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSPort.setColumns(10);
		textSPort.setBounds(390, 398, 150, 30);
		contentPane.add(textSPort);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new Thread(new Server()).start();
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStart.setBounds(503, 439, 100, 25);
		contentPane.add(btnStart);
		
		lblServerStatus = new JLabel("Server Status :");
		lblServerStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblServerStatus.setBounds(290, 495, 320, 27);
		contentPane.add(lblServerStatus);
		
		try {
			textPlayer = new JFormattedTextField(new MaskFormatter("#"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		textPlayer.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPlayer.setColumns(10);
		textPlayer.setBounds(393, 437, 100, 30);
		contentPane.add(textPlayer);
		
		lblPlayer = new JLabel("Player :");
		lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPlayer.setBounds(300, 435, 83, 27);
		contentPane.add(lblPlayer);
		list6 = new JList<String>(listModelGame);
		
		int delay=1000;
		timer=new Timer(delay,new ActionListener(){
			
			public void actionPerformed(ActionEvent event) {
				if(time==00){
					lblTime.setText("Time Left : 60 sec's");
					formattedTextField.setEditable(false);
					formattedTextField.setText(null);
					btnSeeAll.setEnabled(true);
					lblStatus.setText("Status : Game Complete.");
					textHost.setEditable(true);
					textPort.setEditable(true);
					textName.setEditable(true);
					btnConnect.setEnabled(true);
					lblServerStatus.setText("Server Status:Server Stopped.");
					textSPort.setEditable(true);
					btnStart.setEnabled(true);
					textPlayer.setEditable(true);
					ps.println(new Integer(point).toString());
					game=false;
					timer.stop();
				}
				else{
				time--;
				lblTime.setText("Time Left : "+time+" sec's");
				}
			}
			
		});
		
		countdown=new Timer(delay,new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				if(count==00){
					lblStatus.setText("Status : Game in session.");
					sa.actionPerformed(null);
					count=5;
					countdown.stop();
				}
				else{
				lblStatus.setText("Status : Game starts in "+count+" secs.");
				count--;
				}
			}
			
		});
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
	
	class StartAction implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			btnSeeAll.setEnabled(false);
			formattedTextField.setEditable(true);
			formattedTextField.setText(null);
			del=null;
			l2=l3=l4=l5=l6=0;
			sc=new SpellCheck();
			point=0;
			time=60;
			scrollPane_5.setVisible(false);
			listAllModel.clear();
			array=arr.toCharArray();
			for(int k=2;k<=arr.length();k++)
		    	combinations(arr,k,"");
			
			for(int i=0;i<listAllModel.getSize();i++)
			{
				String s=listAllModel.getElementAt(i);
				if(s.length()==2)
					l2++;
				else if(s.length()==3)
					l3++;
				else if(s.length()==4)
					l4++;
				else if(s.length()==5)
					l5++;
				else if(s.length()==6)
					l6++;
			}
			
			lbl2letter.setText(new Integer(l2).toString());
			lbl3letter.setText(new Integer(l3).toString());
			lbl4letter.setText(new Integer(l4).toString());
			lbl5letter.setText(new Integer(l5).toString());
			lbl6letter.setText(new Integer(l6).toString());
			
			listModel2.clear();
			listModel3.clear();
			listModel4.clear();
			listModel5.clear();
			listModel6.clear();
			
			textSPort.setEditable(false);
			btnStart.setEnabled(false);
			textPlayer.setEditable(false);
			
			lblPoints.setText("Points:");
			btn1.setText(new Character(arr.charAt(0)).toString().toUpperCase());
			btn2.setText(new Character(arr.charAt(1)).toString().toUpperCase());
			btn3.setText(new Character(arr.charAt(2)).toString().toUpperCase());
			btn4.setText(new Character(arr.charAt(3)).toString().toUpperCase());
			btn5.setText(new Character(arr.charAt(4)).toString().toUpperCase());
			btn6.setText(new Character(arr.charAt(5)).toString().toUpperCase());
			formattedTextField.requestFocus();
			timer.start();
		}
	}
	
	void combinations(String str, int k, String output) {
    	if(k==0){
    	if(sc.check(output)){
    			if(!listAllModel.contains(output))
    			listAllModel.addElement(output);
    		}
    	}

    	for(int i = 0; i< str.length();i++){

    	combinations(str.substring(0, i)+str.substring(i+1),k-1,output+str.charAt(i));

    	}

   }
	
	void statusChange(){
		int port=new Integer(textPort.getText());
		String host=textHost.getText();
		try {
			s=new Socket(host,port);
			scr=new Scanner(s.getInputStream());
			ps=new PrintStream(s.getOutputStream(),true);
			lblStatus.setText("Status : Connected . Waiting for players.");
			ps.println(textName.getText());
			new Thread(new Scan()).start();
			btnConnect.setEnabled(false);
			textPort.setEditable(false);
			textHost.setEditable(false);
			textName.setEditable(false);
		} catch (Exception e) {
			lblStatus.setText("Status : Connection Failed with Server.");
		}
	}
	
	class Scan implements Runnable{

		public void run() {
			while(true){
				String line=scr.nextLine();
				if(line.equals("true")){
					lblStatus.setText("Status : All players joined. Game will begin shortly.");
				}
				else if(line!=null && game!=true){
					arr=line;
					countdown.start();
					game=true;
					break;
					}
			}
			while(game==true);
			while(scr.hasNextLine()){
				System.out.println(scr.nextLine());
			}
			scr.close();
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	class Server implements Runnable{

		public void run() {
			ServerSocket ss;
			int port=new Integer(textSPort.getText());
			int players=new Integer(textPlayer.getText());
			PlayerThread pt[]=new PlayerThread[players];
			int count=0;
			try {
				ss=new ServerSocket(port);
				Socket s=null;
				System.out.print("\nWaiting for players to join......");
				lblServerStatus.setText("Server Status:Server Started.");
				textSPort.setEditable(false);
				btnStart.setEnabled(false);
				textPlayer.setEditable(false);
				while(count!=players){
				s=ss.accept();
				 int i = 0;
		          for (i = 0; i < players; i++) {
		            if (pt[i] == null) {
		              pt[i] = new PlayerThread(s);
		              count++;
		              break;
		            }
		          }
				}
			} catch (IOException e) {
				lblServerStatus.setText("Server Status:Server Failed");
				textSPort.setEditable(true);
				btnStart.setEnabled(true);
				textPlayer.setEditable(true);
			}
			System.out.print("\nAll Players Joined...");
			GameServer gs=new GameServer(pt);
		    gs.start();
			
		}
		
	}
}
