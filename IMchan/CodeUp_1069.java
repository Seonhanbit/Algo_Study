package 코드업;

import java.util.Scanner;

public class CodeUp_1069 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char str = sc.next().charAt(0);
		if ( str == 'A') {
			System.out.println("best!!!");
		}else if(str == 'B') {
			System.out.println("good!!");
		}else if(str == 'C') {
			System.out.println("run!");
		}else if(str == 'D') {
			System.out.println("slowly~");
		}else {
			System.out.println("what?");
		}
	}
}
