import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt(); //해당 레벨의 인덱스값.
        
        int level = 0; //레벨
        int totalFraction = 0; //해당 레벨의 분수 개수의 총 합
        while(totalFraction < X){
            level++;
            totalFraction += level;
        } 
       
        int index = X - (totalFraction - level); //해당 레벨의 인덱스 값 - 전 레벨까지의 분수개수의 총 합
        // 4 = 14 - (15 - 5)
        int numerator, denominator;
        
        //규칙상 홀수 짝수로 지그재그의 방향성 셋팅
        //홀수면은 상단 짝수면 하단
        if(level % 2 == 0){
            numerator = index;
            denominator = level - index + 1;
        } else {
            numerator =  level - index + 1;
            denominator = index;
        }
        
        System.out.println(numerator + "/" + denominator);
        
        
    }
}