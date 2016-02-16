import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class Browser extends JFrame{
	private JTextField field=new JTextField();
	private JEditorPane display=new JEditorPane();
	private JScrollPane scroll=new JScrollPane(display);


	public static void main(String[] args) {
		Browser br=new Browser();

	}

	Browser(){
		setTitle("Мой браузер");
		setSize(850,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);

		field.setBounds(10,10,800,30);
		scroll.setBounds(10,50,800,500);
		add(field);
		add(scroll);

		field.addActionListener(new InternetListener());
		display.addHyperlinkListener(new LinkListener());
	}

	private void loadData(String text){
		try{
			display.setPage(text);
		}catch(Exception e){
			System.out.println("Не удалось загрузить страницу");
		}
	}

	class InternetListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			loadData(e.getActionCommand());
		}

	}

	class LinkListener implements HyperlinkListener{

		public void hyperlinkUpdate(HyperlinkEvent e) {
			if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
				loadData(e.getURL().toString());
			}
		}

	}



}
