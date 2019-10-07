package 코드업;

import java.util.Scanner;

public class CodeUp_1067 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		if (a < 0) {
			System.out.println("minus");
		}if( a > 0) {
			System.out.println("plus");
		}if (a % 2 == 0) {
			System.out.println("even");
		}else  {
			System.out.println("odd");
		}
		System.out.println(a%2+"\n");
	}

}
//-2581