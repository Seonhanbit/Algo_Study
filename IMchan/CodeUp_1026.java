package a20번전까지;

import java.util.Scanner;

public class CodeUp1026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String splt[] = str.split(":");
		if(Integer.parseInt(splt[1])<10) {
			System.out.println(splt[1].replaceAll("0", ""));
		}else {
			System.out.println(splt[1]);
			}
		}
	
	}


