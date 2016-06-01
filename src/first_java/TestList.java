package first_java;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Photo> album=new LinkedList<>();
		
		album.add(new Photo("one", new Date(), "classroom"));
		album.add(new Photo("tow", new Date(), "library"));
		album.add(new Photo("three", new Date(), "gym"));
		
		Iterator<Photo> iterator=album.iterator();
		while(iterator.hasNext()){
			Photo photo=iterator.next();
			System.out.println(photo.toString());
		}
		for (Photo photo: album){
			System.out.println(photo.toString());
		}	
	}

}

class Photo{
	String title;
	Date date;
	String memo;
	public Photo(String title, Date date, String memo) {
		// TODO Auto-generated constructor stub
		this.title=title;
		this.date=date;
		this.memo=memo;
	}
	@Override
	public String toString(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return title+"("+formatter.format(date)+")"+memo;
	}
}