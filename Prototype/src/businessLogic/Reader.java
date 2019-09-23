package businessLogic;

import java.io.Serializable;
import java.util.Scanner;

public class Reader implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private Scanner sc;
	
	public Reader() {
		this.sc = new Scanner(System.in);
	}
	
	public Reader(String s) {
		this.sc = new Scanner(s);
	}
	
	public int nextInt() {
	return this.sc.nextInt();
	}
	
	public String next() {
		return this.sc.next();
	}
	
	public String nextLine() {
		return this.sc.nextLine();
	}
	
	public String nextLowercase() {
		return this.sc.nextLine().toLowerCase();
	}
}
