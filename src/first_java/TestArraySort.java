package first_java;

import java.util.Arrays;
import java.util.Random;

public class TestArraySort {
	static Random r= new Random();
	static String ssource= "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	static char[] src=ssource.toCharArray();
	
	static String randString(int length){
		char[] buf = new char [length];
		for (int i = 0; i < buf.length; i++) {
			int rnd=Math.abs(r.nextInt())% src.length;
			buf[i]=src[rnd];
		}
		return new String(buf);
	}
	
	static String[] randStrings(int length, int size){
		String[] strings=new String[size];
		for (int i = 0; i < strings.length; i++) {
			strings[i]=randString(length);
		}
		return strings;
	}
	public static void print(String [] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] s=randStrings(4,10);
		print(s);
		Arrays.sort(s);
		print(s);
		int loc= Arrays.<String>binarySearch(s, s[3]);  //<> 这里不太明白
		System.out.println("Location of " + s[3] + " is " + loc);
	}


}
