package a20번전까지;

import java.util.Scanner;

public class CodeUp1021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 String str = sc.next();
		 char[] data = new char[str.length()];
		 for(int i=0; i<str.length(); i++) {
			 data[i] = str.charAt(i);
		}
		 System.out.println(data);
	}

}
