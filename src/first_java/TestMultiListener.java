package first_java;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestMultiListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame= new JFrame("Test MultiListener");
		JTextArea msg = new JTextArea();
		Listener1 m1= new Listener1(frame);
		Listener2 m2= new Listener2(frame, msg);
		
		
//		frame.addWindowListener(m1);

		//匿名类
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){System.exit(0);}
		});
		

		
		frame.addMouseMotionListener(m2);
		frame.add(msg, BorderLayout.SOUTH);
		frame.setSize(400, 300);
		frame.setVisible(true);
	}

}

class Listener1 implements WindowListener{
	private JFrame f;
	Listener1(JFrame f) {
		// TODO Auto-generated constructor stub
		this.f=f;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
//只实现一种方法，可以用下面的方式更方便
class Listener10 extends WindowAdapter{
	public void windowClosing(WindowEvent e){System.exit(0);}
}


class Listener2 implements MouseMotionListener{
	private JFrame f;
	private JTextArea msg;
	private boolean bDragged=false;
	public Listener2(JFrame f, JTextArea msg) {
		// TODO Auto-generated constructor stub
		this.f=f;
		this.msg=msg;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		msg.setText("MouseDraged: "+ e.getX()+","+ e.getY());
		if(! bDragged){
			f.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			bDragged=true;
		}
		f.getGraphics().drawLine(e.getX(), e.getY(), e.getX(), e.getY());
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		msg.setText("WAHAHA!! MouseMoved: " + e.getX()+ ","+ e.getY());
		if(bDragged){
			f.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			bDragged=false;
		}
	}
}
