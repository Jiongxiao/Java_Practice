package first_java;
import java.util.*;

public class TestStringMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringTokenizer st=new StringTokenizer("wo Cao Ni da yE!! !");
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken().toUpperCase());
		}
		st=new StringTokenizer("1,2,3,4,5,6", ",");
		double sum=0;
		while(st.hasMoreElements()){
			sum+=Double.parseDouble(st.nextToken());
		}
		System.out.println((int)sum);

	}

}
