package Snakes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class FDemo extends JFrame
{
	JPDemo jp1;
	FDemo()
	{
		super.setTitle("Snake N Ladders");
		jp1 = new JPDemo();
		add(jp1);
	}
}

class JPDemo extends JPanel implements ActionListener
{
	ImageIcon img1,img2,img3,img4,img5,img6,img7,img8,img9;
	Image boardi,dice,ss,ss1,player1,player2;
	JButton start,reset,roll,b;
	JTextField tx1,tx2;
	
	int[] px1 = new int[21];
	int[] px2 = new int[21];
	int p1,py1,p2,py2;
	int c;
	
	JPDemo()
	{
		
		setLayout(null);
		setBackground(Color.black);
		img1 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\snake1.jpg");
		boardi=img1.getImage();
		
		c=0;
		py1=600;py2=600;
		p1=0;p2=0;
		px1[0]=185;
		for(int i=1;i<11;i++)
		{
			px1[i]=px1[i-1]+65;
		}
		px1[11]=px1[10];
		for(int i=12;i<21;i++)
		{
			px1[i]=px1[i-1]-65;
		}
		px2[0]=175;
		for(int i=1;i<11;i++)
		{
			px2[i]=px2[i-1]+65;
		}
		px2[11]=px2[10];
		for(int i=12;i<21;i++)
		{
			px2[i]=px2[i-1]-65;
		}

		
		img5 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rdice0.jpg");
		dice=img5.getImage();
		
		img6 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\ss.png");
		ss=img6.getImage();
		
		img7 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\ss1.png");
		ss1=img7.getImage();
		
		img2 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\start2.jpg");
		img3 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\reset2.jpg");
		img4 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\roll2.jpg");
		
		
		start =new JButton(img2);
		reset =new JButton(img3);
		roll =new JButton(img4);
		
		start.setSize(100,50);
		start.setLocation(113,100);
		add(start);
		start.addActionListener(this);
		
		reset.setBounds(5, 100, 100, 50);
		add(reset);
		reset.addActionListener(this);
		
		roll.setBounds(60, 300, 100, 50);
		add(roll);
		//roll.addActionListener(this);
		
	
		
		tx1=new JTextField("PLAYER 1 NAME");
		tx1.setBounds(30,180,150,30);
		add(tx1);
		
		tx2=new JTextField("PLAYER 2 NAME");
		tx2.setBounds(30,230,150,30);
		add(tx2);
		
		img8=new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rblue.png");
		img9=new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rred.png");
		player1=img8.getImage();
		player2=img9.getImage();
	}
	
public void paintComponent(Graphics g) 
{
	super.paintComponent(g);
	g.drawImage(boardi, 220, 0, this);
	g.drawImage(dice, 70, 400, this);
	g.drawImage(ss, 0, 0, this);
	g.drawImage(ss1,5, 540, this);
	
	g.drawImage(player1, px1[p1%20], py1, this);
	g.drawImage(player2, px2[p2%20], py2, this);
	if(p1>=100)
		g.drawString(""+tx1.getText()+" WINS !", 40, 530);
	else if(p2>=100)
		g.drawString(""+tx2.getText()+" WINS !", 40, 530);
	else if(c%2==0)
		g.drawString(""+tx1.getText()+"'s turn", 40, 530);
	else if(c%2==1)
		g.drawString(""+tx2.getText()+"'s turn", 40, 530);

}

public void actionPerformed(ActionEvent e)
{

	if(e.getSource()==reset)
	{
		c=0;
		py1=600;py2=600;
		p1=0;p2=0;
		img5 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rdice0.jpg");
		roll.removeActionListener(this);
		start.addActionListener(this);
	}
	if(e.getSource()==start)
	{
		roll.addActionListener(this);
		start.removeActionListener(this);
	}
	
	if(e.getSource()==roll)	////////////////////////////////Roll
	{
		////////////////////////////////////////////////player 1
		if(c%2==0) {
		int random=(int)Math.round(Math.random()*5+1);
		
		p1=p1+random;
		if(p1>0 && p1<=10)
			py1=600;
		else if(p1>10 && p1<=20)
			py1=535;
		else if(p1>20 && p1<=30)
			py1=470;
		else if(p1>30 && p1<=40)
			py1=405;
		else if(p1>40 && p1<=50)
			py1=340;
		else if(p1>50 && p1<=60)
			py1=275;
		else if(p1>60 && p1<=70)
			py1=210;
		else if(p1>70 && p1<=80)
			py1=145;
		else if(p1>80 && p1<=90)
			py1=80;
		else if(p1>90 && p1<=100)
			py1=15;
		
		switch(random)
		{
	
		case 1:
			img5 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rdice1.jpg");
			break;
		
		case 2:
			img5 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rdice2.jpg");
			break;
		
		case 3:
			img5 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rdice3.jpg");

			break;
		case 4:
			img5 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rdice4.jpg");

			break;
		
		case 5:
			img5 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rdice5.jpg");

			break;
		
		case 6:
			img5 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rdice6.jpg");

		}
		
		//Snakes Conditions
		if(p1==99)	p1=41;
		if(p1==89)	p1=53;
		if(p1==76)	p1=58;
		if(p1==66)	p1=45;
		if(p1==54)	p1=31;
		if(p1==43)	p1=18;
		if(p1==40)	p1=3;
		if(p1==27)	p1=5;
		
		//Ladders Condition
		
		if(p1==4)	p1=25;
		if(p1==13)	p1=46;
		if(p1==33)	p1=49;
		if(p1==50)	p1=69;
		if(p1==42)	p1=63;
		if(p1==62)	p1=81;
		if(p1==74)	p1=92;
	
		
		
		if(p1>0 && p1<=10)
			py1=600;
		else if(p1>10 && p1<=20)
			py1=535;
		else if(p1>20 && p1<=30)
			py1=470;
		else if(p1>30 && p1<=40)
			py1=405;
		else if(p1>40 && p1<=50)
			py1=340;
		else if(p1>50 && p1<=60)
			py1=275;
		else if(p1>60 && p1<=70)
			py1=210;
		else if(p1>70 && p1<=80)
			py1=145;
		else if(p1>80 && p1<=90)
			py1=80;
		else if(p1>90 && p1<=100)
			py1=15;
		c++;
		}
		
		
		////////////////////////////////////////player 2
		else if(c%2==1) {
		int random2=(int)Math.round(Math.random()*5+1);
		
		p2=p2+random2;
		if(p2>0 && p2<=10)
			py2=600;
		else if(p2>10 && p2<=20)
			py2=535;
		else if(p2>20 && p2<=30)
			py2=470;
		else if(p2>30 && p2<=40)
			py2=405;
		else if(p2>40 && p2<=50)
			py2=340;
		else if(p2>50 && p2<=60)
			py2=275;
		else if(p2>60 && p2<=70)
			py2=210;
		else if(p2>70 && p2<=80)
			py2=145;
		else if(p2>80 && p2<=90)
			py2=80;
		else if(p2>90 && p2<=100)
			py2=15;
		
		switch(random2)
		{
	
		case 1:
			img5 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rdice1.jpg");
			break;
		
		case 2:
			img5 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rdice2.jpg");
			break;
		
		case 3:
			img5 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rdice3.jpg");
			break;
		case 4:
			img5 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rdice4.jpg");
			break;
		
		case 5:
			img5 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rdice5.jpg");
			break;
		
		case 6:
			img5 = new ImageIcon("F:\\CODE\\JAVA\\Ecilipse\\rdice6.jpg");

		}
		
		//Snakes Conditions
		if(p2==99)	p2=41;
		if(p2==89)	p2=53;
		if(p2==76)	p2=58;
		if(p2==66)	p2=45;
		if(p2==54)	p2=31;
		if(p2==43)	p2=18;
		if(p2==40)	p2=3;
		if(p2==27)	p2=5;
		
		//Ladders Condition
		
		if(p2==4)	p2=25;
		if(p2==13)	p2=46;
		if(p2==33)	p2=49;
		if(p2==50)	p2=69;
		if(p2==42)	p2=63;
		if(p2==62)	p2=81;
		if(p2==74)	p2=92;
	
		
		
		if(p2>0 && p2<=10)
			py2=600;
		else if(p2>10 && p2<=20)
			py2=535;
		else if(p2>20 && p2<=30)
			py2=470;
		else if(p2>30 && p2<=40)
			py2=405;
		else if(p2>40 && p2<=50)
			py2=340;
		else if(p2>50 && p2<=60)
			py2=275;
		else if(p2>60 && p2<=70)
			py2=210;
		else if(p2>70 && p2<=80)
			py2=145;
		else if(p2>80 && p2<=90)
			py2=80;
		else if(p2>90 && p2<=100)
			py2=15;
		
		c++;
		}
		
		if(p1>=100)
			{p1=100;
			roll.removeActionListener(this);
			start.removeActionListener(this);
			}
		
		if(p2>=100)
			{
			p2=100;
			roll.removeActionListener(this);
			start.removeActionListener(this);
			}
		

	}
	dice=img5.getImage();
	repaint();
}
}


public class snakeNLadders {
	public static void main (String [] args) {
		FDemo f =new FDemo();
		f.setVisible(true);
		f.setBounds(200,0,900,685);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

	}
		}