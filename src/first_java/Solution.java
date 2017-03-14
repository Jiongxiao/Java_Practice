package first_java;

public class Solution{
    public static void main(String[] args){
    int[] arr = {2,5,1,1,1,1,4,1,7,3,7};
    System.out.println(solve(arr));
    }
    
    public static boolean solve(int[] arr){
    	int sum = 0;
    	int qua = 0;
    	for (int i = 0; i< arr.length; i++){
    		sum+=arr[i];
    	}
    	qua=sum/4;
    	int left=0, right = arr.length-1;
    	int q1=0, q2=0, q3=0, q4=0;
    	for (;q1<qua; ){
    		q1+=arr[left++];
    	}
    	return true;
    }
}