package a20번전까지;

import java.util.Scanner;

public class CodeUp_1078 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int add = 0;
		for(int i=0; i<=num; i++) {
			if( i % 2 == 0) {
			   add+=i;
			}
		}
		System.out.println(add);
	}

}
