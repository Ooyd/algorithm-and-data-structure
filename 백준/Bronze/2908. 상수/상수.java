import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
     
            String A = sc.next();
            String B = sc.next();
            int numA = Integer.parseInt(reverseString(A));
            int numB = Integer.parseInt(reverseString(B));
        
            if(numA > numB){
                System.out.println(numA);
            } else if (numA < numB){
                System.out.println(numB);
            } else{
                System.out.println(0);
            }
        

        
        
        
    }
    
    public static String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }
}