import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ChooseHero extends JPanel{
	JFrame f;
	int x=50,y=50;
	Image image;

	public static void main(String[] args) {
		ChooseHero ch=new ChooseHero();
	}

	ChooseHero(){
		f= new JFrame("Бродилка");
		 f.setSize(400,500);
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 f.add(this);

	     f.setVisible(true);
		 f.setLocationRelativeTo(null);

		createMenu();
	}

	public void paintComponent(Graphics g){
		//рисуем изображение
        g.drawImage(image,x,y,50,50, this);
	}

	//метод для создания меню игры
    public void createMenu() {
    	//создаем строку главного меню
    	JMenuBar menuBar = new JMenuBar();
    	//создаем элемент 1 меню
    	JMenu gameMenu = new JMenu("Игра");
    	//создаем подпункты меню
    	//1. создаем подпункт меню
    	JMenuItem newgame = new JMenuItem("Выбрать персонажа");
    	//2. привязываем к кнопке слушатель событий
        newgame.addActionListener(new unitListener());
        //3. добавляем подпункт в меню
    	gameMenu.add(newgame);

    	//1. создаем подпункт меню
    	JMenuItem exit = new JMenuItem("Выйти");
    	//exit.addActionListener(new exitListener());
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
    	f.setJMenuBar(menuBar);
   	}

    //слушатель подпункта меню "Выбор песонажа"
    class unitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//окно для выбора файла
			JFileChooser fileOpen=new JFileChooser("C:/");
			//устанавливаем фильтр - файлы с каким расширением показать
			fileOpen.addChoosableFileFilter(new FileNameExtensionFilter("JPEG file", "png", "jpeg"));
			//показываем окно
			fileOpen.showOpenDialog(f);
			//запоминаем выбранный файл
			File myFile=fileOpen.getSelectedFile();
			//преобразуем файл в изображение
			ImageIcon icon = new ImageIcon(myFile.getAbsolutePath());
			image = icon.getImage();
			//перерисовываем изображение
			repaint();
		}

    }

}
