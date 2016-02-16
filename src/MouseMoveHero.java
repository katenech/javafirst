import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseMoveHero extends JPanel{
	int x,y,x2,y2;

	public static void main(String[] args) {
	    JFrame fr= new JFrame("��������");
	    fr.setSize(500,400);
	    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    //������� ������-������ � ������ �� �� �����
	    MouseMoveHero ff= new MouseMoveHero();
	    fr.add(ff);

	    fr.setVisible(true);
	    //����������� ������ ���������� ������
	    fr.setLocationRelativeTo(null);
	  //�� ��������� �������� ������ ������
	  		fr.setResizable(false);
	}

	MouseMoveHero(){
		addKeyListener(new MoveIt());
		addMouseListener(new MoveByMouse());
	}

	public void paintComponent(Graphics g){
		   //������������� ������ ��� �� ��� ����
		   g.setColor(Color.blue);
		   g.fillRect(0, 0, this.getWidth(), this.getHeight());

		        //��������� �����������
		        ImageIcon icon = new ImageIcon(getClass().getResource("img/bulldog.png"));
		        Image image = icon.getImage();
		        //������ �����������
		        g.drawImage(image,x,y,50,50, null);

		        // ���������� �����, ����� ���������� ���������� ��� �������� ������� ��������
		    requestFocus();
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

  //��������� ���������� ����� - ��������� ����
    class MoveByMouse implements MouseListener{

    public void mouseClicked(MouseEvent event) {
    	int i=0;
    	// �������� ���������� ���� � �������������� ����
                  x2 = event.getX();
                  y2 = event.getY();
                  System.out.println(x2+" "+y2);
                  int x1=x;
                  int y1=y;
                  if(x2>x){
                	  i=1;
                  }else{i=-1;}

                  while(x!=x2){
                	  repaint();

                	  x=x+i;
                	  y=Math.round((x-x1)/(x2-x1)*(y2-y1)+y1);
                	  //x1=x;
                	 // y1=y;


                	  try {
               		   Thread.sleep(50);
               		  } catch (InterruptedException e) {}

System.out.println(x1+" "+y1);
System.out.println(x+" "+y);

                  }


              }
    //��� ������ ����������� ���� �����������
    public void mouseEntered(MouseEvent event){};
    public void mouseExited(MouseEvent event) {};
    public void mousePressed(MouseEvent event) {};
    public void mouseReleased(MouseEvent event) {};

    }
}


