package 코드업;

import java.util.Scanner;

public class CodeUp_1035 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String num = sc.next(); //String으로 받은 후에
		int result = Integer.valueOf(num, 16);
		String res = Integer.toOctalString(result);
		System.out.println(res);
	}

}
