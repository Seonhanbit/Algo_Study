package 코드업;

import java.util.Scanner;

public class CodeUp_1053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		if ( x == 1) {
			x = 0;
		}else if(x == 0) {
			x = 1;
		}
		System.out.println(x);
	
	}

}
