import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class MoveHero extends JPanel{
	int x,y;
	int x1=100, y1=200;
	boolean flag=false;
	JPanel mainP, propertiesP;
	Map mymap;
	JLabel l;
	JFrame fr;

	public static void main(String[] args) {
		MoveHero mh=new MoveHero();
	}

	MoveHero(){
		 fr= new JFrame("��������");
		 fr.setSize(400,500);
		 fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	     fr.setVisible(true);
		    //����������� ������ ���������� ������
		 fr.setLocationRelativeTo(null);
		  //�� ��������� �������� ������ ������
		 //fr.setResizable(false);
createMenu();
		  	// ����� ����� ��� ������� ������
	 mainP=new JPanel();
	 BorderLayout bl = new BorderLayout();
	 mainP.setLayout(bl);

	    //������� ������-������ � ������ �� �� �����
	    //MoveHero ff= new MoveHero();
	 	propertiesP=new JPanel();
	 	l=new JLabel("����� ����� ���������� � ���� ����");
	 	propertiesP.add(l);
	    mainP.add("Center",this);
	    mainP.add("South",propertiesP);

	    mymap=new Map();

	    fr.add(mainP);

		addKeyListener(new MoveIt());
		Moving m=new Moving();
		m.start();
	}

	//����� ��� �������� ���� ����
    public void createMenu() {
    	//������� ������ �������� ����
    	JMenuBar menuBar = new JMenuBar();
    	//������� ������� 1 ����
    	JMenu gameMenu = new JMenu("����");
    	//������� ��������� ����
    	//gameMenu.add(new JMenuItem("����� ����"));
    	//1. ������� �������� ����
    	JMenuItem newgame = new JMenuItem("����� ����");
    	//2. ����������� � ������ ��������� �������
        //newgame.addActionListener(new newListener());
        //3. ��������� �������� � ����
    	gameMenu.add(newgame);

    	//3 ���� ��� �������� �������� ��������� ����
    	//1. ������� �������� ����
    	JMenuItem exit = new JMenuItem("�����");
    	//2. ����������� � ������ ��������� �������
        //exit.addActionListener(new exitListener());
        //3. ��������� �������� � ����
    	gameMenu.add(exit);

    	//������� ������� 2 ����
    	JMenu aboutMenu = new JMenu("�� ����");
    	//������� ��������� ����
       	//1. ������� �������� ����
    	JMenuItem about = new JMenuItem("�������");
    	//2. ����������� � ������ ��������� �������
        //about.addActionListener(new aboutListener());
        //3. ��������� �������� � ����
    	aboutMenu.add(about);

    	//��������� �������� ���� � ������
    	menuBar.add(gameMenu);
    	menuBar.add(aboutMenu);
    	//��������� �������������� ������������ ����
    	menuBar.add(Box.createHorizontalGlue());

    	//��������� ������ ���� �� �����
    	fr.setJMenuBar(menuBar);
   	}

	public void paintComponent(Graphics g){
		   //������������� ������ ��� �� ��� ����
		   //g.setColor(Color.blue);
		   //g.fillRect(0, 0, this.getWidth(), this.getHeight());

		mymap.paintMap(g);

		        //��������� �����������
		        ImageIcon icon = new ImageIcon(getClass().getResource("img/bulldog.png"));
		        Image image = icon.getImage();
		        //������ �����������
		        g.drawImage(image,x,y,50,50, null);

		        //������ ����������� ��� ��������
		        ImageIcon icon1 = new ImageIcon(getClass().getResource("img/kolobok.png"));
		        Image an = icon1.getImage();
		        g.drawImage(an,x1,y1,50,50, null);

		        // ���������� �����, ����� ���������� ���������� ��� �������� ������� ��������
		    requestFocus();
		    this.updateUI();
		    }

	//��������� �����-��������� ����������
    class MoveIt implements KeyListener{

      public void keyPressed(KeyEvent event){
      switch (event.getKeyCode()) {
              case KeyEvent.VK_LEFT:
            	  if(x>0){
            x--;}
          break;
          case KeyEvent.VK_RIGHT:
        	  if(x<450){
            x++;}
          break;
          case KeyEvent.VK_UP:
            y--;
          break;
          case KeyEvent.VK_DOWN:
            y++;
          break;
      }
      //����� ��������� ������� ������� �������������� �����������
      repaint();
      };

      //��� ������ �� �� ����������, �� �� ��� ����� ���� ��������
      public void keyReleased(KeyEvent event){};
      public void keyTyped(KeyEvent event){};
    }

  //�������� �������� �� ���������� ����� - ��������� �����
    class Moving extends Thread{
      public void run(){

       //����������� ��������
       while(true){

         //������
            while(x1<200){
              repaint();
     try {
     Thread.sleep(50);
    } catch (InterruptedException e) {break;}

     x1=x1+1;
    }
            //�����
             while(x1>20){
              repaint();
     try {
     Thread.sleep(50);
    } catch (InterruptedException e) {}

     x1=x1-1;
      }
         }
         }
       }
}


