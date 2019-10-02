import java.util.Arrays;
import java.util.Scanner;
//등수매기기(실패)
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        //예상등수 입력
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        //예상등수 정렬
        Arrays.sort(arr);
        int sum =0;
        //불만도 구하기
        //실제 등수 - 예상등수(절댓값)
        for (int i = 0; i < N; i++) {
            sum+=Math.abs((i+1)-arr[i]);
        }
        System.out.println(sum);
    }
}