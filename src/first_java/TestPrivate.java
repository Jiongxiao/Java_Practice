package first_java;

class TestPrivate 
{
	private int a=100;
	public static void main(String[] args){
		int k = new TestPrivate().a;
		System.out.println(k);
	}
}
