package a20번전까지;

import java.util.Scanner;

public class CodeUp_1089 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			int d = sc.nextInt();
			int n = sc.nextInt();
			for(int i=1; i<n; i++) {
				a= a+d;
			}
		System.out.println(a);
	}

}
