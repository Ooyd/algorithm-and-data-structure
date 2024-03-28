import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String alphabet = sc.next().toUpperCase();
    Map<Character,Integer> storage = new HashMap<>();

    for(char c : alphabet.toCharArray()){
      storage.put(c,storage.getOrDefault(c,0)+1);
    }

    int maxValue = 0;
    char mostFrequentChar = '?';
    boolean isEqual = false;

    for(Map.Entry<Character, Integer> entry: storage.entrySet()){
      if(entry.getValue() > maxValue) {
        maxValue = entry.getValue();
        mostFrequentChar = entry.getKey();
        isEqual = false;
      } else if(entry.getValue() == maxValue){
        isEqual = true;
      }
    }

    System.out.println(isEqual ? "?" : mostFrequentChar);

  }
}