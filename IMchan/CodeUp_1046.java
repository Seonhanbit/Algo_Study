package 코드업;

import java.util.Scanner;

public class CodeUp_1046 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double res = 0; 
		double res1 = 0;
		double x = sc.nextInt();
		double x1 = sc.nextInt();
		double x2 = sc.nextInt();
		
		res = x+ x1 + x2;
		res1 = res/3;
		System.out.println((int)res);
		System.out.println(String.format("%.1f", res1));
				
		
	}

}
