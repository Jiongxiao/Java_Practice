package first_java;

class Rnd_36_7
{
	public static void main(String[] args)
	{
		int a[] = new int[7];
		for( int i=0;i<a.length;i++)
		{
			one_num:
			while(true)
			{
				a[i] = (int)( Math.random()*36 ) +1;

				for( int j=0;j<i;j++ ){ 
					if( a[i]==a[j] ) continue one_num;
				}
				break;
			}
		}
		for( int i : a) System.out.print( " " + i ); 
		System.out.println();
	}
}