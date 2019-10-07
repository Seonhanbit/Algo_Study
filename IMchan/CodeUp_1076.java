package a20번전까지;

import java.util.Scanner;

public class CodeUp_1076 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char str = 'a';
		char str2 = sc.next().charAt(0);
		while(true) {
			System.out.println(str);
			str += 1;
			if(str > str2) {
				break;
			}
		}
	}

}
