package 코드업;

import java.util.Scanner;

public class CodeUp_1034 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next(); //String 값으로 받고
		int octal = Integer.valueOf(num, 8); 
		System.out.println(octal);
		
	}
}
//num을 받는다 그리고 int형으로 변환한다 그리고 8진수로 변환한다.!
