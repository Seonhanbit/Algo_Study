package a20번전까지;

import java.util.Scanner;

public class CodeUp_1091 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long m = sc.nextInt();
		long d = sc.nextInt();
		long n = sc.nextInt();
		
		for (int i = 0; i < n-1; i++) {
			a = a * m  + d;
		}
		
		System.out.println(a);



	}

}
