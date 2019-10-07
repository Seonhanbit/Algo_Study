package 코드업;

import java.util.Scanner;

public class CodeUp_1031 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String octal = Integer.toOctalString(num);
		String octal2 = Integer.toBinaryString(num);
		System.out.println(octal);
		System.out.println(octal2);
	}

}
