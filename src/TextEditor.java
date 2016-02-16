import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;


public class TextEditor {

    public static void main(String[] args) {
        FrameWindow frame;
        frame =  new FrameWindow("Текстовый редактор");
        frame.setVisible(true);
    }
}

class FrameWindow extends JFrame implements ActionListener, WindowListener{
  TextArea ta;
  MenuBar mb;
  Menu mFile;
  MenuItem miOpen;
  MenuItem miSave;
  MenuItem miSaveAs;
  MenuItem miExit;
  String szCurrentFilename = "";
  byte buf[];
  // ============================================
  // FrameWindow
  // ============================================
  public FrameWindow(String szTitle)
  {
    super(szTitle);
    setSize(400, 300);
    mb = new MenuBar();
    mFile = new Menu("Файл");
    miOpen = new MenuItem("Открыть");
    mFile.add(miOpen);
    miSave = new MenuItem("Сохранить");
    mFile.add(miSave);
    miSaveAs = new MenuItem("Сохранить как...");
    mFile.add(miSaveAs);
    mFile.add("-");
    miExit = new MenuItem("Выход");
    mFile.add(miExit);
    mb.add(mFile);
    miOpen.addActionListener(this);
    miSave.addActionListener(this);
    miSaveAs.addActionListener(this);
    miExit.addActionListener(this);
    setMenuBar(mb);
    this.addWindowListener(this);
    ta = new TextArea(10, 30);
    setLayout(new BorderLayout());
    add("Center", ta);
  }
  // ============================================
  // actionPerformed
  // ============================================
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource().equals(miOpen))
    {
      FileOpen();
    }
    else if(e.getSource().equals(miSave))
    {
      FileSave();
    }
    else if(e.getSource().equals(miSaveAs))
    {
      FileSaveAs();
    }
    else if(e.getSource().equals(miExit))
    {
      setVisible(false);
      System.exit(0);
    }
  }

  // ============================================
  // windowClosing
  // ============================================
  public void windowClosing(WindowEvent e)
  {
    setVisible(false);
    System.exit(0);
  }
  public void windowOpened(WindowEvent e) {}
  public void windowClosed(WindowEvent e) {}
  public void windowIconified(WindowEvent e) {}
  public void windowDeiconified(WindowEvent e) {}
  public void windowActivated(WindowEvent e) {}
  public void windowDeactivated(WindowEvent e) {}

  // ============================================
  // FileOpen
  // ============================================
  void FileOpen()
  {
    FileDialog fdlg;
    FileInputStream is = null;

    fdlg = new FileDialog(this, "Открыть",
	FileDialog.LOAD);
    fdlg.show();

    szCurrentFilename = fdlg.getDirectory() +
      fdlg.getFile();

    setTitle("TextEditor" + " - " +
      szCurrentFilename);

    try
    {
      is = new FileInputStream(
        szCurrentFilename);
    }
    catch (FileNotFoundException ex)
    {
      System.out.println(ex.toString());
    }
    catch (SecurityException ex)
    {
      System.out.println(ex.toString());
    }

    try
    {
      buf = new byte[is.available()];
      is.read(buf);
    }
    catch (IOException ex)
    {
      System.out.println(ex.toString());
    }

    ta.selectAll();
    ta.replaceRange(
      "", 0, ta.getSelectionEnd());

    String szStr = new String(buf);// Преобразуем массив байтов (buf) в строку
    StringTokenizer st; //создает объект, готовый разбить строку str на слова, разделенные пробелами, символами табуляций  '\t', перевода строки '\n' и возврата каретки '\r' . Разделители не включаются в число слов.

    st = new StringTokenizer(szStr, "\r\n");//выделяем перевод строки

    while(st.hasMoreElements())
    {
      szStr = new String(
        (String)st.nextElement());// получаем очередной элемент токенайзера и преобразуем его в строку
         ta.append(szStr + "\r\n");// добавляем полученную строку к текстовой области

    }

    try
    {
      is.close();
    }
    catch (IOException ex)
    {
      System.out.println(ex.toString());
    }
  }

  // ============================================
  // FileSaveAs
  // ============================================
  void FileSaveAs()
  {
    FileDialog fdlg;
    fdlg = new FileDialog(
      this, "Сохранить файл как...",
      FileDialog.SAVE);
    fdlg.show();

    if(fdlg.getDirectory() == null ||
      fdlg.getFile() == null)
      return;

    szCurrentFilename = fdlg.getDirectory() +
      fdlg.getFile();

    setTitle("TextEditor" + " - " +
      szCurrentFilename);

    FileSave();
  }

  // ============================================
  // FileSave
  // ============================================
  void FileSave()
  {
    FileOutputStream os = null;

    String sz = ta.getText();
    buf = sz.getBytes();

    try
    {
      os = new FileOutputStream(
        szCurrentFilename);
      os.write(buf);
      os.close();

    }
    catch (IOException ex)
    {
      System.out.println(ex.toString());
    }
    catch (SecurityException ex)
    {
      System.out.println(ex.toString());
    }
  }
}