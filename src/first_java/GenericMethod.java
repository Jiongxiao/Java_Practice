package first_java;

import java.util.Date;

public class GenericMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date= BeanUtil.<Date>getInstance("java.util.Date");
		System.out.println(date);
	}

}

class BeanUtil{
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String className) {
		try{
			Class<?> c= Class.forName(className);
			System.out.println(c.getClass().toString());
			return  (T) c.newInstance();
		}
		catch (ClassNotFoundException ex){}
		catch (InstantiationException ex){}
		catch (IllegalAccessException ex){}
		return null;
}
}