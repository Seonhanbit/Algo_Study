package a20번전까지;

import java.util.Scanner;

public class CodeUp_1087 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int add = 0;
		int result = 0;
		while(num>add) {
			result++;
			add+=result;
		}
		System.out.println(add);
	}

}
