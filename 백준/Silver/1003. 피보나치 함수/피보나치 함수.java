import java.util.*;
import java.io.*;

class Main {
    static Integer[][] arr = new Integer[41][2];
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        //초기값 설정
        arr[0][0] = 1; //fibonacci(0) 호출 시 0의 출력 횟수
        arr[0][1] = 0; //fibonacci(0) 호출 시 1의 출력 횟수
        arr[1][0] = 0; //fibonacci(1) 호출 시 0의 출력 횟수
        arr[1][1] = 1; //fibonacci(1) 호출 시 1의 출력 횟수
        
        int len = sc.nextInt();
        
        for(int i=0; i<len; i++){
            int n = sc.nextInt();
            fibonacci(n);
            
            System.out.println(arr[n][0] + " " + arr[n][1]);
        }
    }
    
    private static Integer[] fibonacci(int n){
        //계산된 값이 있으면 재사용
        if(arr[n][0] != null && arr[n][1] != null) {
            return arr[n];
        }
        
        // 재귀 호출을 통해 필요한 값을 계산
        Integer[] f1 = fibonacci(n - 1);
        Integer[] f2 = fibonacci(n - 2);
        
        // 현재 n에 대한 0과 1의 호출 횟수 계산
        arr[n][0] = f1[0] + f2[0];
        arr[n][1] = f1[1] + f2[1];
        
        return arr[n];

    }
}