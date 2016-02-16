/**
 * Auto Generated Java Class.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Svetofor extends JPanel{
	JLabel l;
//число для выбора цвета светофора
int i;
//координаты персонажа
int x=100,y=200;

 public static void main(String[] args) {
    JFrame fr= new JFrame("Светофор");
    fr.setSize(500,400);
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //создаем объект-панель и кладем ее на фрейм
    Svetofor ff= new Svetofor();
    fr.add(ff);

    fr.setVisible(true);
    //расположить окошко посередине экрана
    fr.setLocationRelativeTo(null);
      }

 Svetofor(){
  //создаем переключатели
   this.setLayout(null);

    JRadioButton rButton1 = new JRadioButton("Красный");
    JRadioButton rButton2 = new JRadioButton("Желтый");
    JRadioButton rButton3 = new JRadioButton("Зеленый");

    rButton1.setBackground(Color.blue);
    rButton2.setBackground(Color.blue);
    rButton3.setBackground(Color.blue);

    //добаляем слушатель событий к переключателям
    rButton1.addActionListener(new RListener());
    rButton2.addActionListener(new YListener());
    rButton3.addActionListener(new GListener());

    ButtonGroup bg = new ButtonGroup(); // создаем группу взаимного исключения
    bg.add(rButton1);
    bg.add(rButton2); // сделали переключатели в группу
    bg.add(rButton3);
    this.add(rButton1);
    this.add(rButton2); // добавили переключатели на панель
    this.add(rButton3);
    rButton1.setBounds(120,55,80,30);
    rButton2.setBounds(120,95,80,30);
    rButton3.setBounds(120,135,80,30);

    l=new JLabel("Метка");
        this.add(l);
        l.setBounds(200,55,100,50);

    //добавляем вызов слушателя событий клавиатуры
    addKeyListener(new MoveKolobok());
 }

 //в этом методе происходит рисование
 public void paintComponent(Graphics g){
   //устанавливаем задний фон на все окно
   g.setColor(Color.blue);
   g.fillRect(0, 0, this.getWidth(), this.getHeight());

   //рисуем светофор
        g.setColor(Color.black);
        g.fillRect(50, 50, 40, 120);
        if (i==1){
        g.setColor(Color.red);
        g.fillOval(55, 55, 30, 30);}

        if(i==2){
        g.setColor(Color.yellow);
        g.fillOval(55, 95, 30, 30);}

        if(i==3){
        g.setColor(Color.green);
        g.fillOval(55, 135, 30, 30);}

        //рисуем дорогу
        g.setColor(Color.gray);
        g.fillRect(0, 250, 500, 100);

        //рисуем пешеходный переход
        for(int y=260;y<340;y=y+20){
        g.setColor(Color.white);
        g.fillRect(100, y, 100, 10);
        }


        //загружаем изображение
        ImageIcon icon = new ImageIcon(getClass().getResource("img/kolobok.png"));
        Image image = icon.getImage();
        //рисуем изображение
        g.drawImage(image,x,y,50,50, null);

        // Установить фокус, чтобы обработчик клавиатуры мог посылать команды объектам
    requestFocus();
    }

  //добавляем внутренние классы-слушатели переключателей
  class RListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      i=1;
      repaint();
      l.setText("Красный свет-прохода нет!");
    }
  }

    class YListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      i=2;
      repaint();
    }
  }

      class GListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      i=3;
      repaint();
    }
  }

      //добавляем класс-слушатель клавиатуры
      class MoveKolobok implements KeyListener{

        public void keyPressed(KeyEvent event){
        	if(i!=1){
        switch (event.getKeyCode()) {
                case KeyEvent.VK_LEFT:
              x--;
            break;
            case KeyEvent.VK_RIGHT:
              x++;
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
        	}
        };
        //эти методы мы не используем, но их все равно надо включить
        public void keyReleased(KeyEvent event){};
        public void keyTyped(KeyEvent event){};
      }
}

