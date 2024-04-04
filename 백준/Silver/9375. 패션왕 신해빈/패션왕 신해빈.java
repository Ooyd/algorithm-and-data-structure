import java.util.*;
import java.io.*;

/**
 * 1. 문제 정리 (글 계속 적으면서 이해하기위함)
 *      -목표 : 해빈이가 알몸이 아닌 상태로 의상을 입을 수 있는 모든 경우의 수를 찾는거
 *      - 조건 : 한번 입었던 옷의 조합은 다시 안입음. 같은 종류의 의상은 동시에 하나만 착용.
 *      - 입력
 *        -> Line 1 테스트케이스 횟수(최대100)
 *        -> Line 2 해빈이의 의상 수 (n)
 *        -> Line T_1 의상의 이름, 의상의 종류(사이 빈 공백)
 *      - 출력 : 각 테스트 케이스에 대해 해빈이가 알몸이 아닌 상태로 의상을 입을 수 있는 경우
 *
 * 2. 개념 및 접근법
 *  - HashMap을 사용한다.(의상의 종류, 개수)
 *  - 해빈이는 각 의상을 입거나 입지 않을 수 있다. (알몸만 아니면 됨)
 *  - 각 의상 종류별로 의상을 입는 경우의 수 + 1(의상을 안 입는 경우)로 계산.
 *  - 각 의상 종류별 경우의 수를 곱한 후, 아무것도 입지 않는 경우를 제외하여 최종 값을 도출
 *  -> (a+1)*(b+1)*(c+1)-1 =결과값
 */
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트 케이스 횟수값 setting
        int TestCase = Integer.parseInt(br.readLine());

        //테스트 케이스의 횟수만큼 반복
        for(int i = 0; i<TestCase;i++){
            // 의상 수
            int n = Integer.parseInt(br.readLine());

            //Key = 의상 종류 , value = 개수
            HashMap<String,Integer> clothes = new HashMap<>();

            for(int j=0; j<n;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                //의상의 이름
                String name = st.nextToken();
                //의상의 종류
                String category = st.nextToken();
                // 해당 종류의 의상 개수 저장 (+1).
                clothes.put(category, clothes.getOrDefault(category, 0) + 1);
            }

            //경우의 수 초기화.
            int numberOfCase = 1;
            
            // 각 의상 종류별 경우의 수 계산: 의상을 입는 경우의 수 + 의상을 입지 않는 경우(1)
            // (a+1)*(b+1)*(c+1)
            for (int count : clothes.values()) {
                numberOfCase *= (count + 1);
            }

            System.out.println(numberOfCase - 1);
        }



    }
}


