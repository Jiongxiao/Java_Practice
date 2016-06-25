package first_java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern= Pattern.compile("cat");
		Matcher matcher= pattern.matcher("one cat, two cats, three cats in the yard!");
		StringBuffer sbBuffer=new StringBuffer();
		while(matcher.find()){
			matcher.appendReplacement(sbBuffer, "big $0");
		}
		matcher.appendTail(sbBuffer);
		System.out.println(sbBuffer.toString());
		Pattern pattern2=Pattern.compile(",");
		String[] result= pattern2.split(sbBuffer);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i].trim());
		}
	}

}
