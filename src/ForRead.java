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
//Глобальные переменные
JMenu mb;
JFrame f;
JPanel panelShow;
JPanel panelAdd;

//Метод конструктора
	public ForRead() {
		f = new JFrame("Читалка");
	    f.setSize(500,400);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    f.setLocationRelativeTo(null);


		createMenu();

	}

//Метод main
	public static void main(String[] args) {

	ForRead fr = new ForRead();
	}

//Метод создания меню
	public void createMenu(){
	    JMenuBar mb = new JMenuBar();
	    JMenu menu = new JMenu("Меню");
	    JMenu about = new JMenu("О программе");
	    JMenuItem showBooks = new JMenuItem("Показать книги");
	    JMenuItem addBook = new JMenuItem("Добавить книги");
	    JMenuItem miExit = new JMenuItem("Закрыть меню");

	    menu.add(showBooks);
	    menu.add(addBook);
	    menu.add(miExit);

	    mb.add(menu);

	    f.setJMenuBar(mb);

	    showBooks.addActionListener(new showBooksListener());
	    addBook.addActionListener(new addBookListener());
	}

//Метод демонстрирования книг
	public void createPanelShow(){
	GridLayout gl=new GridLayout(4,1);
    panelShow=new JPanel();
    panelShow.setLayout(gl);

    JLabel label = new JLabel();
    JTextField TField = new JTextField();
    JLabel label2 = new JLabel("Найти");
    JButton Button = new JButton("Показать");

    panelShow.add(label);
    panelShow.add(TField);
    panelShow.add(label2);
    panelShow.add(Button);

    f.add(panelShow);
    //обновляет окно, чтобы все сразу перерисовалось
    f.validate();
}

	//Метод добавления книг
	public void createPanelAdd(){
		GridLayout gl2=new GridLayout(5,1);
	    panelAdd=new JPanel();
	    panelAdd.setLayout(gl2);

	    JLabel enter = new JLabel("Введите:");
	    JTextField author = new JTextField("Автор");
	    JTextField name = new JTextField("Название");
	    JTextField isbn = new JTextField("ISBN");
	    JButton addButton = new JButton("добавить");

	    panelAdd.add(enter);
	    panelAdd.add(author);
	    panelAdd.add(name);
	    panelAdd.add(isbn);
	    panelAdd.add(addButton);

	    f.add(panelAdd);
f.validate();
	}

//Слушатель showBooks
	public class showBooksListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			createPanelShow();
		}

	}

//Слушатель addBook
	public class addBookListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			createPanelAdd();
		}
}

	}