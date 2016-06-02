package first_java;

import java.util.ArrayList;

public class GenericTreeClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TNode<String> t = new TNode<>("hello");
		t.add("first");t.add("second");
		t.getChild(0).add("little1");
		t.getChild(0).add("little2");
		t.traverse();
	}

}

class TNode<T>{
	private T value;
	private ArrayList<TNode<T>> children= new ArrayList<>();
	
	public TNode(T v) {
		// TODO Auto-generated constructor stub
		this.value=v;
	}
	public T getValue() {
		return this.value;
	}
	public void add(T v) {
		this.children.add(new TNode<T>(v));
	}
	public TNode<T> getChild(int i) {
		if ((i<0) || (i>this.children.size())) {
			return null;
		}
		return this.children.get(i);
	}
	public void traverse() {
		System.out.println(this.value);
		for (TNode<T> child: this.children)
			child.traverse();
	}
}