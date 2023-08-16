import java.io.*;

public class Main {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int personnel = Integer.parseInt(br.readLine());//초기 인원수
      int[] names = new int[personnel];
      //행성의 거주민 이름 입력받기
      for(int i=0; i<personnel; i++){
        names[i] = Integer.parseInt(br.readLine());
      }

      int[] dataStructure = new int[20]; //1,000,000은 2^19.xx이므로 크기 20으로할당.
      for(int name : names){
        int idx = 0;
        while (name > 0){
          if((name & 1) ==1){
            dataStructure[idx]++;
          }
          name >>= 1;
          idx++;
        }
      }

      long planetValue = 0;
      for (int i = 0; i < 20; i++) {
        planetValue += (long) (1 << i) * dataStructure[i] * (personnel - dataStructure[i]);
      }


      System.out.println(planetValue);
    }catch (IOException e){
      e.printStackTrace();
    }

  }

}