import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FirstDraw extends JPanel{

	public static void main(String[] args) {
		JFrame fr= new JFrame("��������");
	    fr.setSize(500,400);
	    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    //������� ������-������ � ������ �� �� �����
	    FirstDraw p= new FirstDraw();
	    fr.add(p);

	    fr.setVisible(true);
	    //����������� ������ ���������� ������
	    fr.setLocationRelativeTo(null);

	}
	//� ���� ������ ���������� ���������
	 public void paintComponent(Graphics g){
	   //������������� ������ ��� �� ��� ����
	   g.setColor(Color.blue);
	   g.fillRect(0, 0, 500, 400);
	 }

}
