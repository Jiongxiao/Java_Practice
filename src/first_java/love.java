package first_java;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

public class love {
	
	 public static void main(String[] args) {
	 // TODO Auto-generated method stub
		 love love= new love();
		 double mu1=0, mu2=0,sigma1=1,sigma2=1;
		 love.leartCurve(mu1,sigma1,mu2,sigma2);
	 }
	public void leartCurve(double mu1, double sigma1, double mu2, double sigma2) {
		int[] N = new int[] { 1000, 10000, 50000, 500000 };
		ArrayList<Double> p= new ArrayList<>();
		Random random = new Random();
		for (int n : N) {
			int count=0;
			for (int i = 0; i < n; i++) {
				double x = mu1 + random.nextGaussian()*sigma1;
				double y = mu2 + random.nextGaussian()*sigma2;
				if (Math.pow(x, 2)+y*y-x*y-1<=0 || x*x+y*y+x*y-1<=0){
					count++;
				}

			}
			p.add((double)count/n);
		}
		for (double pro : p){
			System.out.println(pro);
		}

	}

}
