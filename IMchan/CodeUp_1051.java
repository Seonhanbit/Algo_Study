package 코드업;

import java.util.Scanner;

public class CodeUp_1051 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int res = 0;
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(b>=a) {
			res =1;
		}else {
			res =0;
		}
		System.out.println(res);
	}

}
