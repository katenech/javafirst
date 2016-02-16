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
		f= new JFrame("��������");
		 f.setSize(400,500);
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 f.add(this);

	     f.setVisible(true);
		 f.setLocationRelativeTo(null);

		createMenu();
	}

	public void paintComponent(Graphics g){
		//������ �����������
        g.drawImage(image,x,y,50,50, this);
	}

	//����� ��� �������� ���� ����
    public void createMenu() {
    	//������� ������ �������� ����
    	JMenuBar menuBar = new JMenuBar();
    	//������� ������� 1 ����
    	JMenu gameMenu = new JMenu("����");
    	//������� ��������� ����
    	//1. ������� �������� ����
    	JMenuItem newgame = new JMenuItem("������� ���������");
    	//2. ����������� � ������ ��������� �������
        newgame.addActionListener(new unitListener());
        //3. ��������� �������� � ����
    	gameMenu.add(newgame);

    	//1. ������� �������� ����
    	JMenuItem exit = new JMenuItem("�����");
    	//exit.addActionListener(new exitListener());
       	gameMenu.add(exit);

    	//������� ������� 2 ����
    	JMenu aboutMenu = new JMenu("�� ����");
    	//������� ��������� ����
       	//1. ������� �������� ����
    	JMenuItem about = new JMenuItem("�������");
    	//2. ����������� � ������ ��������� �������
        //about.addActionListener(new aboutListener());
        //3. ��������� �������� � ����
    	aboutMenu.add(about);

    	//��������� �������� ���� � ������
    	menuBar.add(gameMenu);
    	menuBar.add(aboutMenu);
    	//��������� �������������� ������������ ����
    	menuBar.add(Box.createHorizontalGlue());

    	//��������� ������ ���� �� �����
    	f.setJMenuBar(menuBar);
   	}

    //��������� ��������� ���� "����� ��������"
    class unitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//���� ��� ������ �����
			JFileChooser fileOpen=new JFileChooser("C:/");
			//������������� ������ - ����� � ����� ����������� ��������
			fileOpen.addChoosableFileFilter(new FileNameExtensionFilter("JPEG file", "png", "jpeg"));
			//���������� ����
			fileOpen.showOpenDialog(f);
			//���������� ��������� ����
			File myFile=fileOpen.getSelectedFile();
			//����������� ���� � �����������
			ImageIcon icon = new ImageIcon(myFile.getAbsolutePath());
			image = icon.getImage();
			//�������������� �����������
			repaint();
		}

    }

}
