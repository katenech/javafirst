
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Svetofor1 extends JPanel {
	int i;
int x = 10;
int y = 10;
public static void main(String[] args) {
Svetofor1 ss = new Svetofor1();

JFrame f = new JFrame();
f.setSize(700,500);
f.setVisible (true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setLocationRelativeTo(null);
f.add(ss);



}
Svetofor1()
{

createControl();
addKeyListener(new moveHero());
}

public void paintComponent(Graphics g)
{

ImageIcon i = new ImageIcon(getClass().getResource("img/bulldog.png"));
Image image = i.getImage();
g.setColor(new Color(255, 255, 255));
g.fillRect(0, 0, 10000, 10000);

g.drawImage(image,x,y,300,300,null);
g.setColor( Color.BLACK );
g.fillRect(350,100,50,50);
g.fillRect(350,170,50,50);
g.fillRect(350,240,50,50);

requestFocus();
}

public void createControl()
{
this.setLayout(null);
JRadioButton r1 = new JRadioButton("Красный");
JRadioButton r2 = new JRadioButton("Жёлтый");
JRadioButton r3 = new JRadioButton("Зелёный");
//добаляем слушатель событий к переключателям
r1.addActionListener(new RListener());
r2.addActionListener(new YListener());
r3.addActionListener(new GListener());
ButtonGroup bg = new ButtonGroup();
bg.add(r1);
bg.add(r2);
bg.add(r3);
this.add(r1);
this.add(r2);
this.add(r3);
r1.setBounds(400,100,150,50);
r2.setBounds(400,170,150,50);
r3.setBounds(400,240,150,50);
}

//добавляем внутренние классы-слушатели переключателей
class RListener implements ActionListener{
  public void actionPerformed(ActionEvent event){
    i=1;
    repaint();
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

class moveHero implements KeyListener
{


public void keyPressed(KeyEvent e) {

switch (e.getKeyCode())
{
case KeyEvent.VK_RIGHT:
x=x+8;
break;
case KeyEvent.VK_LEFT:
x=x-8;
break;
case KeyEvent.VK_UP:
y=y-8;
break;
case KeyEvent.VK_DOWN:
y=y+8;
break;

}
repaint();
}


public void keyReleased(KeyEvent arg0) {


}


public void keyTyped(KeyEvent arg0) {


}

}
}