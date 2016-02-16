//гдеяэ хлонпрхпсел ахакхнрейх AWT  SWING
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Draw extends JPanel  {
	Color myColor;

//янгдюел назейр йкюяяю
public static void main(String[] args) {
Draw d=new Draw();
}
//гдеяэ пхясел
public void paintComponent(Graphics g){
	g.setColor(myColor);
	g.fillOval(50, 50, 100, 100);
}
//гдеяэ янгдюел тпеил, ймнойх Х ро
Draw(){
JFrame f = new JFrame();
f.setSize(300,300);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.add(this);
f.setVisible(true);

JButton b=new JButton("НЙ");
this.add(b);
b.addActionListener(new WhatColor());
}

class WhatColor implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		myColor=JColorChooser.showDialog(null, "бШАНП ЖБЕРЮ", Color.black);
		repaint();
	}

}
}
