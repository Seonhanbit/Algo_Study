package 코드업;

import java.util.Scanner;

public class CodeUp_1064 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
					
System.out.println((x > x1) 
		? 
		(x1 > x2) ? x2 : x1 
				: 
		(x > x2) ? x2 : x);

	}

}
