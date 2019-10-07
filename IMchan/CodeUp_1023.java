package a20번전까지;

import java.util.Scanner;

public class CodeUp1023 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double dd = sc.nextDouble();
		String[] split = String.valueOf(dd).split("\\.");
		
		System.out.println(split[0]);
		System.out.println(split[1]);
	
	}

}
