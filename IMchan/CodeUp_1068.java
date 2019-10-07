package 코드업;

import java.util.Scanner;

public class CodeUp_1068 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num >= 90) {
			System.out.println("A");
		}else if(num >=70 && num <90) {
			System.out.println("B");
		}else if(num >=40 && num <=69) {
			System.out.println("C");
		}else if(num >= 0 && num <=39){
			System.out.println("D");
		}
	}
}
