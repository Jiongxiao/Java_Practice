package first_java;


import java.util.*;

public class TestCollectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> school = new ArrayList<>();
		school.add(new Person("li", 23));
		school.add( new Person("Wang",28));
		school.add( new Person("Zhang",21));
		school.add( new Person("Tang",19));
		school.add( new Person("Chen",22));
		school.add( new Person("Zhao",22));
		System.out.println(school); //****可以打印List,需重载toString()
		
//		Collections.sort( school, new PersonComparator() );  使用Lambda表达式更方便
		Collections.sort(school, (p1,p2)->p1.age-p2.age);
		System.out.println(school);
		
		int index = Collections.binarySearch(school, new Person("Wang", 28), new PersonComparator());
		if (index>=0) {
			System.out.println("Found:"+ school.get(index).name);
		}
		else System.out.println("NOT Found");
	}

}

class Person
{
	String name;
	int age;
	public Person( String name, int age){ 
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString(){
		return name+":"+age;
	}
}

class PersonComparator implements Comparator<Object>{
	public int compare(Object obj1, Object obj2) {  //这里不能直接传入Person类，因为需要实现接口的方法
		Person p1 = (Person) obj1;
		Person p2 = (Person) obj2;
//		if (p1.age>p2.age) return 1;
//		else if (p1.age<p2.age) return -1;
//		else return p1.name.compareTo(p2.name);
		return p1.name.compareTo(p2.name);
		
	}
}
