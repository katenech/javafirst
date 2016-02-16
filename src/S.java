import javax.swing.*;

import java.awt.*;

public class S extends JPanel {

	public S() {
		JFrame f = new JFrame("Кaлейдоскоп");
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(this);
		f.setVisible(true);
		change();
	}

	public static void main(String[] args) {
		S s = new S();

	}

	public void change(){
		while (true) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}
		repaint();
		}

	}

	public void paintComponent(Graphics g) {

			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);

			g.setColor(new Color(red, green, blue));
			g.fillOval(100, 100, 50, 50);

			g.setColor(new Color(red, green, blue));
			g.fillRect(200, 200, 50, 50);

	}

}
