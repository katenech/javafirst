

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MKC {

	JPanel panel ;
	JLabel labelImage, labelText, date;
	JButton ngf, vn, kvn, chgk, miss, ric, studden, stem, irl, art, vid, test;
	JMenuBar mb;
	JFrame window1;

	public static void main(String[] args) {
		MKC mkc = new MKC();
	}
	MKC() {
	createWindow();
}
	public void createWindow() {


		panel = new JPanel();
		panel.setLayout(null);
	    Font f = new Font("sanserif",Font.CENTER_BASELINE,10);
	    Font b = new Font("sanserif",Font.CENTER_BASELINE,13);

		URL cr = getClass().getResource("img/trava.jpg");
		ImageIcon crab = new ImageIcon (cr);
		labelImage = new JLabel(crab);
		labelImage.setBounds(0, 0, 1365,727);

		labelText = new JLabel("<html> ������� ������ ����� <br> ������� ������� ������ ����� "
				+ "�������� ���� ��� � ���, � �� �� ����������� ������������� ���� ���������� "
				+ "���� � ��������, ������ �� ������� ����������� ����� ��������. ��������� ���, "
				+ "� ������� �� ���������� �������, ��� �� ������������ ��������, ������� �������� "
				+ "�����, ��� �� ������ ��! �� ������, ��� ������� �����, ���������, �������, ������ "
				+ "�� �����. ����� ���� 400 ������� ����, ������, ������� � �����!!! ��� ���������� "
				+ "�������� (��� ��������)! ���� ���� ��������� ��� 13 ��� ������ ����, ������ ��� "
				+ "������ �����, ����� �������� � ������� �������. ��, � ���� �� �� ������ �� ������� "
				+ "����������, ������ ��������. ���������, �������������, �������! ������� ������ "
				+ "����� �������� ������. ��� �������, ��� ���� �������� ��� ��, ��������, ������ "
				+ "� ����� ��������.  �������� ������ ����: ���. +79787458545, skype Oksana Isay, "
				+ "��������� vk.com/id3926409. �� ������! �����!");
		labelText.setBounds(0, 95, 1365, 622);
		//labelText.setVisible(true);

	    ngf = new JButton("�� ����� ����");
	    ngf.setBounds(496, 5, 124,40);
	    ngf.setBackground(Color.magenta);
	    ngf.setFont(f);
	    ngf.setForeground(Color.WHITE);
	    ngf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    ngf.addActionListener(new ngfListener ());

	    vn = new JButton("8-� ����");
	    vn.setBounds(0,5,124,40);
	    vn.setBackground(Color.magenta);
	    vn.setFont(b);
	    vn.setForeground(Color.WHITE);
	    vn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    kvn = new JButton("���");
	    kvn.setBounds(248,5,124,40);
	    kvn.setBackground(Color.magenta);
	    kvn.setFont(b);
	    kvn.setForeground(Color.WHITE);
	    kvn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    chgk = new JButton("���?���?�����?");
	    chgk.setBounds(992,5,124,40);
	    chgk.setBackground(Color.magenta);
	    chgk.setFont(f);
	    chgk.setForeground(Color.WHITE);
	    chgk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    miss = new JButton("���� �����");
	    miss.setBounds(372,5,124,40);
	    miss.setBackground(Color.magenta);
	    miss.setFont(b);
	    miss.setForeground(Color.WHITE);
	    miss.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    ric = new JButton("������ �����");
	    ric.setBounds(620,5,124,40);
	    ric.setBackground(Color.magenta);
	    ric.setFont(f);
	    ric.setForeground(Color.WHITE);
	    ric.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    studden = new JButton("��������");
	    studden.setBounds(744,5,124,40);
	    studden.setBackground(Color.magenta);
	    studden.setFont(b);
	    studden.setForeground(Color.WHITE);
	    studden.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    stem = new JButton("����");
	    stem.setBounds(868,5,124,40);
	    stem.setBackground(Color.magenta);
	    stem.setFont(b);
	    stem.setForeground(Color.WHITE);
	    stem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    irl = new JButton("EIRIN DANCE");
	    irl.setBounds(1116,5,124,40);
	    irl.setBackground(Color.magenta);
	    irl.setFont(b);
	    irl.setForeground(Color.WHITE);
	    irl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    art = new JButton("Art-box");
	    art.setBounds(1240,5,124,40);
	    art.setBackground(Color.magenta);
	    art.setFont(b);
	    art.setForeground(Color.WHITE);
	    art.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    vid = new JButton("��������");
	    vid.setBounds(124,5,124,40);
	    vid.setBackground(Color.magenta);
	    vid.setFont(b);
	    vid.setForeground(Color.WHITE);
	    vid.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    test = new JButton("������ ����");
	    test.setBounds(1232, 55, 124, 40);
	    test.setBackground(Color.magenta);
	    test.setVisible(true);
	    test.setFont(b);
	    test.setForeground(Color.WHITE);
	    test.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    window1 = new JFrame("��������� ���������� ����� �����");
		window1.setSize(1365, 727);
		window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window1.setVisible(true);
		window1.setResizable(false);

	    panel.add(ngf);
	    panel.add(vn);
	    panel.add(chgk);
	    panel.add(miss);
	    panel.add(ric);
	    panel.add(studden);
	    panel.add(stem);
	    panel.add(irl);
	    panel.add(art);
	    panel.add(vid);
	    panel.add(kvn);
		//panel.add(labelImage);
		panel.add(test);
		panel.add(labelText);

        window1.add(panel);

        createMenu();
        }
    public void createMenu (){
		mb = new JMenuBar();
		JMenu game = new JMenu("����");
		JMenuItem newPerson = new JMenuItem ("�������� �������������");
		newPerson.addActionListener(new KontaktListener());
		JMenuItem exit = new JMenuItem ("�����");
		exit.addActionListener (new ExitListener());

		JMenu aas = new JMenu("� �������������");
		JMenuItem kont = new JMenuItem ("���� ��������");
		newPerson.addActionListener(new KontaktListener2());
		JMenuItem onas = new JMenuItem ("� ���");
		onas.addActionListener(new tListener());

		game.add(newPerson);
		game.add(exit);
		mb.add(game);
		mb.add(aas);
		aas.add(kont);
		aas.add(onas);
		window1.setJMenuBar(mb);
	}

	class ExitListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);

		}

    }
    class KontaktListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
        JFrame f = new JFrame ("�������� �������������");
        f.setSize(500,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);

		JPanel c = new JPanel();

		Font g = new Font("sanserif",Font.CENTER_BASELINE,15);
		JLabel k = new JLabel();
		k.setText("<html> 8-� ����  ������������ �����  +7 978 741-98-44 <br>"
				+ "��������  ������ ����  +7(978)745-8-545 <br>"
				+ "���  ������� ���������  +7(978)700-05-81 <br>"
				+ "���� �����  ������ ����  +7(978)745-85-45 <br>"
				+ "�� ����� ����  �������� ������  +7(978)745-84-85<br>"
				+ "������ �����  ������ ����  +7(978)745-85-45<br>"
				+ "��������  ������� ��������  +7(978)896-10-29<br>"
				+ "����  �������� �������  +7(978)010-79-59<br> "
				+ "���? ���? �����?  ������ ����������  +7(978)852-56-70<br>"
				+ "EIRIN DANCE  ������ ������  +7(978)071-36-25<br>"
				+ "Art-box  ����� �������  +7(978)728-27-58");
		k.setBounds(0, 0, 500, 300);
		k.setFont(g);
		k.setForeground(Color.white);

		f.add(c);
		c.add(k);
		c.setBackground(Color.magenta);


		}
    }
    class KontaktListener2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame q = new JFrame ("�������� ��������");
	        q.setSize(500,300);
	        q.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			q.setVisible(true);
			q.setResizable(false);

			JPanel r = new JPanel();
			Font g = new Font("sanserif",Font.CENTER_BASELINE,15);
			JLabel k1 = new JLabel();
			k1.setText("<html>������ ������   +7(978)832-24-88   andi.ne2002@gmail.com<br>"
					+ "������������ ����    +7(978)709-74-97  ilya.voznesensky@gmail.com");
			k1.setBounds(0, 0, 30, 30);
			k1.setFont(g);
			k1.setForeground(Color.white);

			q.add(r);
			r.add(k1);
			r.setBackground(Color.magenta);

		}
		 }
    class tListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
        JFrame w = new JFrame ("� ���");
        w.setSize(500, 500);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setVisible(true);

        JPanel e = new JPanel ();

        JLabel t = new JLabel ("<html>n&v company �������� IT-���������,<br>� ������� ���������� ���� � ��������� �� �����.<br>���� ������ � ���������: https://vk.com/n_v_company");

        URL cr2 = getClass().getResource("nv.jpg");
		ImageIcon crab = new ImageIcon (cr2);

        w.add(e);
        e.add(t);

		}
}
	class ngfListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			labelText = new JLabel ("<html>���-����� '�� ����� ����'<br> ���-����� ��� ����� ���� � ��� ���������������� ���������, ������� �� ����� ������������ �������� ���� ������. ������ �� ��� � 1997 ���� ������� ����������, � ��� �� ������ ���� ����������� �������� �������� ��������. �������� � ������� ���-����� ��� ����� ���� �� ��� �������������, � ����� ������, ��� �� ����� ���� ������ ������������ ������ ��� ����. ������ � ���� ���������� �������, �� ���-����� ������ ��� ���� ����� ������� �����, � �������, �������, ��� �����, ���������. ��� ����� ����� ��������!� - ������� ���� �� �������� ���������� �������� ����������.� ����� ���� �� ������ ��������� ��, �� ��� � �������� ������ ��� ������ ������ �, �������, �������� �� ����� �������� ������������. � ����� �� ��� ���������� �� �����, ���� �������� ����� ������� �� ����������, � ����� ��������� ����� ������������. ���������� ���� � ���-����� ��� ����� ����! �������� ������������:+7(978)745-84-85 (��������) ��� molod_c@mail.ru");

			labelText.setVisible(true);
		}

	}
}
