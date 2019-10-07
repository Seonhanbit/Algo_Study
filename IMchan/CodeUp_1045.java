package 코드업;

import java.util.Scanner;

public class CodeUp_1045 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double res = 0.0;
		double res1 = 0.0;
		double res2 = 0.0;
		double res3 = 0.0;
		double res4 = 0.0;
		double res5 = 0.0;
		
		double x = sc.nextDouble();
		double x1 = sc.nextDouble();
		
		res = x + x1;
		res1 = x - x1;
		res2 = x * x1;
		res3 = x / x1;
		res4 = x % x1;
		res5 = x / x1;
		
				
		System.out.println((int)res);
		System.out.println((int)res1);
		System.out.println((int)res2);
		System.out.println((int)res3);
		System.out.println((int)res4);
		System.out.println(String.format("%.2f", res5));
		
		
	}

}
