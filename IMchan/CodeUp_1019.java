package a20번전까지;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CodeUp1019 {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		String from = sc.next();
		SimpleDateFormat tfrom = new SimpleDateFormat("yyyy.MM.dd");
		System.out.println(tfrom.format(from));
	}
}
