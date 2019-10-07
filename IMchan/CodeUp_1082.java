package a20번전까지;

import java.util.Scanner;

public class CodeUp_1082 {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			int a = Integer.parseInt(str, 16);
			for(int i=1; i<16; i++) {
				System.out.printf("%X*%X=%X\n",a,i,a*i);
			}
	}
}
