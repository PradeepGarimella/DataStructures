package Flatten;

public interface IList<T> extends Comparable<IList<T>>,Iterable<T> {
	public void add(T e);
	public T get(int i);
	public void removeAll(T t);
}
