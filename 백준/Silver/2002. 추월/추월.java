import java.util.*;
import java.io.*;

/**
 * 1. 문제 정리 (글 계속 적으면서 이해하기위함)
 *      - 목표 :
 *         -터널 내에서의 차선 변경은 불가능하다 . 대근이는 터널 입구, 영식이는 터널 출구에서
 *          자신들이 적은 차량을 비교해 반드시 추월을 했을것으로 보여지는 차들의 대수를 확인한다.
 *      - 입력 :
 *          - Line 1 : 차의 대수 N
 *          - Line 2~N+1 : 대근이가 적은 차량번호 목록
 *          - Line N+2~2N : 영식이가 적은 차량번호 목록
 *      - 출력 : 터널 내부에서 추월을 반드시 했을것으로 여겨지는 차의 대수
 *
 * 2. 개념 및 접근법
 *  - 터널 입구 차량번호(대근), 터널 출구 차량번호(영식)를 각각 저장
 *  - 대근이와 영식이가 적은 차량번호는 무조건 같아야함.(내가생각한 전제조건)
 *  - 영식이의 차량번호가 대근이의 차량번호보다 인덱스가 앞설경우 무조건 추월했다판단.
 *  - ArrayList를 사용해서 차량의 진입 탈출 순서를 보장.
 */
public class Main{
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //들어온 차량 수
        int N = Integer.parseInt(br.readLine());
        //차량이 들어간 순서를 보장하는 list
        List<String> in = new ArrayList<>();
        //차량이 나온 순서를 보장하는 list
        List<String> out = new ArrayList<>();

        //차량이 들어간 순서대로 차량번호 저장
        for(int i = 0; i < N; i++){
            in.add(br.readLine());
        }
        //차량이 나온 순서대로 차량번호 저장
        for(int i = 0 ; i<N; i++){
            out.add(br.readLine());
        }

        //추월한 차량 대수
        int count = 0;

        //out 리스트를 기준으로 나온 순서 확인하는 로직. 기준은 Out
        for (int i = 0; i < N; i++) {
            //out 순서에서 i번째 차량
            String outCar = out.get(i);
            // out보다 먼저 들어간 in 차량들 확인.
            for (int j = 0; j < in.indexOf(outCar); j++) {
                // 입구에서 먼저 들어간 차량이 출구에서 해당 차량보다 늦게 나오면, 추월발생.
                if (out.indexOf(in.get(j)) > i) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}


