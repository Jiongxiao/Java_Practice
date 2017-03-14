package first_java;

import java.util.Scanner;

public class Net {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(); // 
		System.out.println(t);
		for (int i = 0; i< t; i++){
			solve(in);
		}
		
	}
	public static void solve(Scanner in){
//		Scanner in = new Scanner(System.in);
		int n=in.nextInt(); //装备数量
		int s=in.nextInt(); //初始资金
		String [] name= new String[n];
		int [] lev = new int[n];
		int [][] force = new int[n][3];
		int [][] m= new int[n][3];
		for (int i = 0; i < n; i++){
			name[i]=in.next();
//			System.out.println(name[i]);
			lev[i] = in.nextInt();
			for (int j = 0; j< lev[i]; j++){
				force[i][j]=in.nextInt();
				if (j>=1){
					force[i][j]+=force[i][j-1];
				}
				m[i][j] = in.nextInt();
				if (j>=1){
					m[i][j]+=m[i][j-1];
				}
			}
		}
//		for (int i=0; i<n; i++){
//			for (int j=0; j<3;j++){
//				System.out.print(force[i][j]+" ");
//			}
//			System.out.println();
//		}
		int [] record = new int[s+1];
		int [] dp = new int[s+1];
		for (int i = 0; i < n; i++){
			for (int j = s; j>=0; j--){
				for (int k=0; k<lev[i]; k++){
					if (m[i][k]<=j){
						if (force[i][k] + dp[j-m[i][k]] > dp[j]){
							dp[j] = force[i][k] + dp[j-m[i][k]];
							record[j] = record[j-m[i][k]]+(int)Math.pow(10, i)*(k+1);
						}
					}
					else{
						continue;
					}
				}
			}
		}
		System.out.println(dp[s]);
		for (int i = 0; i < n; i++){
			System.out.println(name[i]+"+"+record[s]%10);
			record[s]/=10;
		}
		
	}




}
