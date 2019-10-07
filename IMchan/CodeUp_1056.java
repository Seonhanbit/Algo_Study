package 코드업;

import java.util.Scanner;

public class CodeUp_1056 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res = 0;		
		int x = sc.nextInt();
		int x1 = sc.nextInt();
		
		if(x==1 && x1==0 || x==0 && x1==1) {
			res = 1;
		}else {
			res = 0;
		}
		System.out.println(res);
	}
}
