package first_java;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestJFrame extends JFrame {
	private JLabel label;
	public TestJFrame() {
		super("Test JFrame");
		label = new JLabel("hello nima");
		getContentPane().add(label);
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestJFrame().setVisible(true);
	}

}
