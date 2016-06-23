package first_java;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.MalformedInputException;

import javax.swing.*;

public class URLGetContent extends JFrame{
	TextArea textArea=new TextArea("#downloading\n");	
	public void init() {

		setSize(400,300);
		getContentPane().add(textArea);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void download() {
		String strUrl= "http://www.baidu.com";
		new Thread(()->{
			String content= getContentFromUrl(strUrl);
			SwingUtilities.invokeLater(()->{
				textArea.append(content);
			});
		}).start();
	}
	
	public String getContentFromUrl(String strUrl) {
		try{
			URL url=new URL(strUrl);
			InputStream stream= url.openStream();
			String content= readAll(stream);
			return content;
		}catch(MalformedInputException e){
			System.out.println("URL格式有误");
		}catch(IOException ioe){
			System.out.println("IO异常");
		}
		return "";
	}
	
	public String readAll(InputStream stream) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//	public static String readAll( InputStream stream, String charcode ) throws IOException{
//		BufferedReader reader = new BufferedReader(
//			new InputStreamReader(stream, charcode));      这样最后显示的是乱码！
		StringBuilder sb= new StringBuilder();
		String temp;
		while((temp=reader.readLine()) != null){
//			System.out.println(temp);
			sb.append(temp+"\n");
		}
		return sb.toString();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URLGetContent f = new URLGetContent();
		f.init();
		f.download();
		String encoding = System.getProperty("file.encoding");
        System.out.println("Default System Encoding:" + encoding);
	}

}



