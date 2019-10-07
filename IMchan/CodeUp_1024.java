package a20번전까지;

import java.util.Scanner;

public class CodeUp1024 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String txt = sc.next();
		for (int i = 0; i < txt.length(); i++) {
			System.out.println("'" + txt.substring(i,i+1) +"'");
		}



		
	}

}
