package 코드업;

import java.util.Scanner;

public class CodeUp_1033 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
		String Hex = Integer.toHexString(num);
			Hex = Hex.toUpperCase();
		System.out.println(Hex);
	}

}
