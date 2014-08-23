package Flatten;

import Flatten.Node;
import GraphPackage.Interfaces.GraphTestingApp;

class Person {
	public final String age;
	public Person(String age) {
		this.age=age;
	}
}
class student extends Person {
	public final String GPA;
	public student() {
		super("99");
		GPA="-";
	}
	
	public String getGPA() {
		return GPA;
	}
}

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		GraphTestingApp app = new GraphTestingApp();
		app.testGraph();
	}

}
