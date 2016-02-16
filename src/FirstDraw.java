import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FirstDraw extends JPanel{

	public static void main(String[] args) {
		JFrame fr= new JFrame("Светофор");
	    fr.setSize(500,400);
	    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    //создаем объект-панель и кладем ее на фрейм
	    FirstDraw p= new FirstDraw();
	    fr.add(p);

	    fr.setVisible(true);
	    //расположить окошко посередине экрана
	    fr.setLocationRelativeTo(null);

	}
	//в этом методе происходит рисование
	 public void paintComponent(Graphics g){
	   //устанавливаем задний фон на все окно
	   g.setColor(Color.blue);
	   g.fillRect(0, 0, 500, 400);
	 }

}
