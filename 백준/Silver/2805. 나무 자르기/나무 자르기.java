import java.util.*;
import java.io.*;

/**
 * 1. 문제 정리
 * - 상근이는 M미터의 나무가 필요하다. 나무를 집에 가져가기 위해 절단기에 설정할 수 있는 높이의 최대값을 찾아라.
 * 2. 개념 및 접근법
 * - 정적 데이터들을 정렬하여 내림차순으로 정렬한다.
 * - M미터의 나무가 필요하고 임의의 높이를가진 N개의 나무들이 있다.
 * - 내가 M미터의 나무를 가져갈 수 있는 절단기의 높이중 가장 최대값을 찾아라.
 * 3. 풀이 결과
 * 메모리  ,시간
 * 4. 추가 정리
 * - 내림차순 정렬시 Collections.reverseOrder()사용
 * - 내림차순은 byte,int,long 같은 Primitive Type 배열에는 적용이 불가능
 * - Integer,String같은 Wrapper class에 사용
 * - Collections.reverseOrder()는 Comparable Interface를 구현한 클래스의 객체만 매개변수로 받는다.
 * 참조자료 : https://gguraeit.tistory.com/3
 *  하.. 정렬문제만 계속 보다보니 그냥 무조건 정렬로만 풀어야된다라고 생각이 박혀있었던거같다..
 *  다른 글들을 참조하니 이글은 이진탐색으로 풀고있더라..
 *
 *  5. 최종 정리
 *  이 문제는 이진 탐색을 통해서 가능한 절단기 높이의 범위를 좁혀 나가 찾아나간다.
 *  N과 M의 범위가 1<= N <= 1,000,000, 1<= M <= 2,000,000,000 로 말도안되게 높다..
 *  이러면 log가 섞여있는 알고리즘(빠른 정렬 알고리즘, 이진탐색 등)을 사용해야한다.
 *
 *  최소높이와 최대높이의 중간을 계산하고, 중간점을 절단기 높이로 설정후, 얻을 수 있는 나무의 양을 계산.
 *  절단된 나무의 양이 M이상이면 조건만족.
 *  조건 만족 -> 최소높이를  중간 +1로 해서 탐색범위 좁힘
 *  조건 불만족 -> 최대높이를 중간 - 1 해서 탐색범위 좁힘.
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //나무 저장할 배열
        Integer[] trees = new Integer [N];
        st = new StringTokenizer(br.readLine());

        // 나무 높이 저장
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        //내림차순 정렬
        Arrays.sort(trees, Collections.reverseOrder());


        //이진탐색 범위 셋팅
        int low = 0, high = trees[0];
        //얘는 절단기
        int cutter = 0;



        //이진탐색 시작
        while (low <= high){
            int mid = (low + high) / 2;
            //절단된 나무들의 합
            long sum = 0;

            //mid 높이로 잘랐을때 얻을 수 있는 나무의 길이 계산
            for(int tree : trees){
                if (tree > mid) sum+= tree - mid;
            }


            if (sum >= M) {
                //현재 mid값 저장
                cutter = mid;
                // 최소 높이를 증가시켜 더 높은 높이 탐색
                low = mid +1;
            } else {
                // 최대 높이를 감소시켜 더 낮은 높이 탐색
                high = mid - 1;
            }


        }
        System.out.println(cutter);
    }
}




