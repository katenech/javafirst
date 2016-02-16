import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TxtReaderWriter {
JPanel p;
JTextField enterText;
JButton b1,b2;
JLabel showText;
String t;

	public static void main(String[] args) {
		TxtReaderWriter t=new TxtReaderWriter();
	}

	TxtReaderWriter(){
		JFrame fr= new JFrame("������-������");
	    fr.setSize(500,400);
	    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    fr.setVisible(true);
	    //����������� ������ ���������� ������
	    fr.setLocationRelativeTo(null);

	    GridLayout gl=new GridLayout(4,1);
	    p=new JPanel();
	    p.setLayout(gl);

	    enterText=new JTextField();
p.add(enterText);
b1=new JButton("<html>�������� <br>� ����");
b1.setForeground(Color.GREEN);
b1.addActionListener(new WriteListener());
b2=new JButton("������� �� �����");
b2.addActionListener(new ReadListener());
p.add(b1);
p.add(b2);
showText = new JLabel();
p.add(showText);

fr.add(p);
	}

class ReadListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		readText();
	}

	public void readText(){
		InputStreamReader r=null;
		BufferedReader buff=null;
		try{
			 InputStream is = getClass().getResourceAsStream("txt/about.txt");
			 File f=new File("c:/");
			 r= new InputStreamReader(is);

			buff=new BufferedReader(r);
			while(true){
				//����������� ������ �� ���������� �����
				String line=buff.readLine();
				//��������, ��������� �� ����� ����� - ����� �������
				if(line==null)break;
				t=t+line;
			}
			}catch(IOException e){
				//�������� ���� ������ :)
				e.printStackTrace();
			}
		//� ����� ������ ��������� ����������� � �����
			finally{
				try{
					buff.close();
					r.close();
				}catch(IOException e1){
					e1.printStackTrace();
				}
			}
		showText.setText(t);
		}
}

class WriteListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		t=enterText.getText();
		//writeText();
	}

	public void writeText(){
		OutputStreamWriter osw=null;
		BufferedWriter buff=null;

		try{


			buff=new BufferedWriter(osw);

				buff.write(t);
				System.out.println("���� ������...");

			System.out.println("������!");
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				buff.flush();
				buff.close();
				osw.close();
			}catch(IOException e1){
				e1.printStackTrace();
			}
		}
	}
}
}
