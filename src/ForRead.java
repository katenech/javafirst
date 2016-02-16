import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ForRead {
//���������� ����������
JMenu mb;
JFrame f;
JPanel panelShow;
JPanel panelAdd;

//����� ������������
	public ForRead() {
		f = new JFrame("�������");
	    f.setSize(500,400);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    f.setLocationRelativeTo(null);


		createMenu();

	}

//����� main
	public static void main(String[] args) {

	ForRead fr = new ForRead();
	}

//����� �������� ����
	public void createMenu(){
	    JMenuBar mb = new JMenuBar();
	    JMenu menu = new JMenu("����");
	    JMenu about = new JMenu("� ���������");
	    JMenuItem showBooks = new JMenuItem("�������� �����");
	    JMenuItem addBook = new JMenuItem("�������� �����");
	    JMenuItem miExit = new JMenuItem("������� ����");

	    menu.add(showBooks);
	    menu.add(addBook);
	    menu.add(miExit);

	    mb.add(menu);

	    f.setJMenuBar(mb);

	    showBooks.addActionListener(new showBooksListener());
	    addBook.addActionListener(new addBookListener());
	}

//����� ���������������� ����
	public void createPanelShow(){
	GridLayout gl=new GridLayout(4,1);
    panelShow=new JPanel();
    panelShow.setLayout(gl);

    JLabel label = new JLabel();
    JTextField TField = new JTextField();
    JLabel label2 = new JLabel("�����");
    JButton Button = new JButton("��������");

    panelShow.add(label);
    panelShow.add(TField);
    panelShow.add(label2);
    panelShow.add(Button);

    f.add(panelShow);
    //��������� ����, ����� ��� ����� ��������������
    f.validate();
}

	//����� ���������� ����
	public void createPanelAdd(){
		GridLayout gl2=new GridLayout(5,1);
	    panelAdd=new JPanel();
	    panelAdd.setLayout(gl2);

	    JLabel enter = new JLabel("�������:");
	    JTextField author = new JTextField("�����");
	    JTextField name = new JTextField("��������");
	    JTextField isbn = new JTextField("ISBN");
	    JButton addButton = new JButton("��������");

	    panelAdd.add(enter);
	    panelAdd.add(author);
	    panelAdd.add(name);
	    panelAdd.add(isbn);
	    panelAdd.add(addButton);

	    f.add(panelAdd);
f.validate();
	}

//��������� showBooks
	public class showBooksListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			createPanelShow();
		}

	}

//��������� addBook
	public class addBookListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			createPanelAdd();
		}
}

	}