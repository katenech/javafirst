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
		 fr= new JFrame("Бродилка");
		 fr.setSize(400,500);
		 fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	     fr.setVisible(true);
		    //расположить окошко посередине экрана
		 fr.setLocationRelativeTo(null);
		  //не разрешаем изменять размер фрейма
		 //fr.setResizable(false);
createMenu();
		  	// Задаём схему для главной панели
	 mainP=new JPanel();
	 BorderLayout bl = new BorderLayout();
	 mainP.setLayout(bl);

	    //создаем объект-панель и кладем ее на фрейм
	    //MoveHero ff= new MoveHero();
	 	propertiesP=new JPanel();
	 	l=new JLabel("Здесь будет информация о ходе игры");
	 	propertiesP.add(l);
	    mainP.add("Center",this);
	    mainP.add("South",propertiesP);

	    mymap=new Map();

	    fr.add(mainP);

		addKeyListener(new MoveIt());
		Moving m=new Moving();
		m.start();
	}

	//метод для создания меню игры
    public void createMenu() {
    	//создаем строку главного меню
    	JMenuBar menuBar = new JMenuBar();
    	//создаем элемент 1 меню
    	JMenu gameMenu = new JMenu("Игра");
    	//создаем подпункты меню
    	//gameMenu.add(new JMenuItem("Новая игра"));
    	//1. создаем подпункт меню
    	JMenuItem newgame = new JMenuItem("Новая игра");
    	//2. привязываем к кнопке слушатель событий
        //newgame.addActionListener(new newListener());
        //3. добавляем подпункт в меню
    	gameMenu.add(newgame);

    	//3 ШАГА для создания рабочего подпункта меню
    	//1. создаем подпункт меню
    	JMenuItem exit = new JMenuItem("Выйти");
    	//2. привязываем к кнопке слушатель событий
        //exit.addActionListener(new exitListener());
        //3. добавляем подпункт в меню
    	gameMenu.add(exit);

    	//создаем элемент 2 меню
    	JMenu aboutMenu = new JMenu("Об игре");
    	//создаем подпункты меню
       	//1. создаем подпункт меню
    	JMenuItem about = new JMenuItem("Справка");
    	//2. привязываем к кнопке слушатель событий
        //about.addActionListener(new aboutListener());
        //3. добавляем подпункт в меню
    	aboutMenu.add(about);

    	//добавляем элементы меню в строку
    	menuBar.add(gameMenu);
    	menuBar.add(aboutMenu);
    	//указываем горизонтальное расположение меню
    	menuBar.add(Box.createHorizontalGlue());

    	//добавляем строку меню на фрейм
    	fr.setJMenuBar(menuBar);
   	}

	public void paintComponent(Graphics g){
		   //устанавливаем задний фон на все окно
		   //g.setColor(Color.blue);
		   //g.fillRect(0, 0, this.getWidth(), this.getHeight());

		mymap.paintMap(g);

		        //загружаем изображение
		        ImageIcon icon = new ImageIcon(getClass().getResource("img/bulldog.png"));
		        Image image = icon.getImage();
		        //рисуем изображение
		        g.drawImage(image,x,y,50,50, null);

		        //рисуем изображение для анимации
		        ImageIcon icon1 = new ImageIcon(getClass().getResource("img/kolobok.png"));
		        Image an = icon1.getImage();
		        g.drawImage(an,x1,y1,50,50, null);

		        // Установить фокус, чтобы обработчик клавиатуры мог посылать команды объектам
		    requestFocus();
		    this.updateUI();
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

  //анимацию помещаем во внутренний класс - отдельный поток
    class Moving extends Thread{
      public void run(){

       //бесконечное движение
       while(true){

         //вперед
            while(x1<200){
              repaint();
     try {
     Thread.sleep(50);
    } catch (InterruptedException e) {break;}

     x1=x1+1;
    }
            //назад
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


