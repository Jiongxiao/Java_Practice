package first_java;

import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Beidanci extends JFrame {
	JLabel lbWord = new JLabel("word");
	JLabel lbMeaning= new JLabel("meaning");
	
	public void init() {
		setSize(400,200);
		setLayout(new FlowLayout()); //用来显示
		getContentPane().add(lbWord);
		getContentPane().add(lbMeaning);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	List<String> words = new ArrayList<>();
	List<String> meanings= new ArrayList<>();
	int current=0;
	
	public void begin(){
		new Thread(()->{
			try{
				readAll();
			}catch(IOException ex){}
			new Timer(1000,(e)->{
				lbWord.setText(words.get(current));
				lbMeaning.setText(meanings.get(current));
				current++;
			}).start();
		}).start();
	}	

	public void readAll() throws IOException{
		String fileName = "College_Grade4.txt";
		String charset = "GB2312";
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(fileName), charset));
		String temp;
		while((temp=reader.readLine())!=null){
			temp=temp.trim();
			if(temp.length()==0) continue;
			int idx= temp.indexOf("\t");
			words.add(temp.substring(0,idx));
			meanings.add(temp.substring(idx+1));
		}
		reader.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Beidanci beidanci=new Beidanci();
		beidanci.init();
		beidanci.begin();

	}

}
