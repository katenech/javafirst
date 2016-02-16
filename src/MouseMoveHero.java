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
	    JFrame fr= new JFrame("Бродилка");
	    fr.setSize(500,400);
	    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    //создаем объект-панель и кладем ее на фрейм
	    MouseMoveHero ff= new MouseMoveHero();
	    fr.add(ff);

	    fr.setVisible(true);
	    //расположить окошко посередине экрана
	    fr.setLocationRelativeTo(null);
	  //не разрешаем изменять размер фрейма
	  		fr.setResizable(false);
	}

	MouseMoveHero(){
		addKeyListener(new MoveIt());
		addMouseListener(new MoveByMouse());
	}

	public void paintComponent(Graphics g){
		   //устанавливаем задний фон на все окно
		   g.setColor(Color.blue);
		   g.fillRect(0, 0, this.getWidth(), this.getHeight());

		        //загружаем изображение
		        ImageIcon icon = new ImageIcon(getClass().getResource("img/bulldog.png"));
		        Image image = icon.getImage();
		        //рисуем изображение
		        g.drawImage(image,x,y,50,50, null);

		        // Установить фокус, чтобы обработчик клавиатуры мог посылать команды объектам
		    requestFocus();
		    }

	//добавляем класс-слушатель клавиатуры
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
      //после обработки нажвтия клавиши перерисовываем изображение
      repaint();
      };

      //эти методы мы не используем, но их все равно надо написать
      public void keyReleased(KeyEvent event){};
      public void keyTyped(KeyEvent event){};
    }

  //добавляем внутренний класс - слушатель мыши
    class MoveByMouse implements MouseListener{

    public void mouseClicked(MouseEvent event) {
    	int i=0;
    	// получаем координаты мыши и перерисовываем окно
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
    //эти методы обязательно надо перечислить
    public void mouseEntered(MouseEvent event){};
    public void mouseExited(MouseEvent event) {};
    public void mousePressed(MouseEvent event) {};
    public void mouseReleased(MouseEvent event) {};

    }
}


