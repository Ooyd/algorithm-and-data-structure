import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Map<String,Integer> storage = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    int totalCard = sc.nextInt();
    sc.nextLine();

    for(int i =0; i<totalCard; i++){
      String[] temp = sc.nextLine().split(" ");
      String fruit = temp[0];
      int number = Integer.parseInt(temp[1]);
      storage.put(fruit,storage.getOrDefault(fruit,0) + number);
    }

    for(int count : storage.values()){
      if(count == 5) {
        System.out.println("YES");
        return;
      }
    }
    System.out.println("NO");
  }
}