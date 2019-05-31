import java.awt.*;
import java.awt.Panel.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class Notepad extends Frame {
    public static void main(String[] args){
        Notepad notepad =  new Notepad();
        notepad.setTitle("Something not understandable");
        notepad.setSize(640,480);

        Menu mf= new Menu("File");
        MenuItem op= new MenuItem("Open");
        op.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open");
                FileDialog fd= new FileDialog(notepad, "Open",FileDialog.LOAD);
                fd.show();
                String name = fd.getFile();
                File file = new File(name);
                System.out.println(fd.getDirectory()+file.getName());
            }
        });
        MenuItem sa= new MenuItem("Save as");
        sa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Save as ...");
                FileDialog fd= new FileDialog(notepad,"Save as...",FileDialog.SAVE);
                fd.show();

            }
        });
        MenuItem ex = new MenuItem("Exit1");
        ex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exit1");
                Dialog d= new Dialog(notepad,"Are you sure?",true);
                d.setLayout(new FlowLayout());
                Button yes= new Button("Yes");
                yes.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(1);
                    }
                });
                Button no = new Button("No");
                no.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        d.setVisible(false);
                    }
                });
                d.add(yes);
                d.add(no);
                d.setSize(100,100);
                d.show();
            }
        });
        MenuItem ex2 = new MenuItem("Exit2");
        ex2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exit2");
                System.exit(2);
            }
        });
        mf.add(op);
        mf.add(sa);
        mf.addSeparator();
        Menu exit = new Menu("Exit");
        exit.add(ex);
        exit.add(ex2);
        mf.add(exit);

        Menu mfr = new Menu("Format");
        MenuItem rlc= new MenuItem("Relocate words");
        MenuItem font = new MenuItem("Font");
        mfr.add(rlc);
        mfr.add(font);

        MenuBar mb= new MenuBar();
        mb.add(mf);
        mb.add(mfr);

        TextArea ta = new TextArea();
        ta.setBounds(notepad.getBounds());
        notepad.setMenuBar(mb);
        notepad.add(ta);


        notepad.setVisible(true);


    }

    public Notepad(){
        addWindowListener(new MyWindowAdapter());
    }
    class MyWindowAdapter extends WindowAdapter{
        public void windowClosing(WindowEvent we){
            System.exit(0);
        }
    }
}
