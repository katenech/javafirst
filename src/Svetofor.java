/**
 * Auto Generated Java Class.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Svetofor extends JPanel{
	JLabel l;
//����� ��� ������ ����� ���������
int i;
//���������� ���������
int x=100,y=200;

 public static void main(String[] args) {
    JFrame fr= new JFrame("��������");
    fr.setSize(500,400);
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //������� ������-������ � ������ �� �� �����
    Svetofor ff= new Svetofor();
    fr.add(ff);

    fr.setVisible(true);
    //����������� ������ ���������� ������
    fr.setLocationRelativeTo(null);
      }

 Svetofor(){
  //������� �������������
   this.setLayout(null);

    JRadioButton rButton1 = new JRadioButton("�������");
    JRadioButton rButton2 = new JRadioButton("������");
    JRadioButton rButton3 = new JRadioButton("�������");

    rButton1.setBackground(Color.blue);
    rButton2.setBackground(Color.blue);
    rButton3.setBackground(Color.blue);

    //�������� ��������� ������� � ��������������
    rButton1.addActionListener(new RListener());
    rButton2.addActionListener(new YListener());
    rButton3.addActionListener(new GListener());

    ButtonGroup bg = new ButtonGroup(); // ������� ������ ��������� ����������
    bg.add(rButton1);
    bg.add(rButton2); // ������� ������������� � ������
    bg.add(rButton3);
    this.add(rButton1);
    this.add(rButton2); // �������� ������������� �� ������
    this.add(rButton3);
    rButton1.setBounds(120,55,80,30);
    rButton2.setBounds(120,95,80,30);
    rButton3.setBounds(120,135,80,30);

    l=new JLabel("�����");
        this.add(l);
        l.setBounds(200,55,100,50);

    //��������� ����� ��������� ������� ����������
    addKeyListener(new MoveKolobok());
 }

 //� ���� ������ ���������� ���������
 public void paintComponent(Graphics g){
   //������������� ������ ��� �� ��� ����
   g.setColor(Color.blue);
   g.fillRect(0, 0, this.getWidth(), this.getHeight());

   //������ ��������
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

        //������ ������
        g.setColor(Color.gray);
        g.fillRect(0, 250, 500, 100);

        //������ ���������� �������
        for(int y=260;y<340;y=y+20){
        g.setColor(Color.white);
        g.fillRect(100, y, 100, 10);
        }


        //��������� �����������
        ImageIcon icon = new ImageIcon(getClass().getResource("img/kolobok.png"));
        Image image = icon.getImage();
        //������ �����������
        g.drawImage(image,x,y,50,50, null);

        // ���������� �����, ����� ���������� ���������� ��� �������� ������� ��������
    requestFocus();
    }

  //��������� ���������� ������-��������� ��������������
  class RListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      i=1;
      repaint();
      l.setText("������� ����-������� ���!");
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

      //��������� �����-��������� ����������
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
        //����� ��������� ������� ������� �������������� �����������
        repaint();
        	}
        };
        //��� ������ �� �� ����������, �� �� ��� ����� ���� ��������
        public void keyReleased(KeyEvent event){};
        public void keyTyped(KeyEvent event){};
      }
}

