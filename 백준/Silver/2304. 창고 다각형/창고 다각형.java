import java.util.*;
import java.io.*;

/**
 1. 문제 정리
 - 주어진 기둥들을 사용해서 창고 다각형의 면적이 최소가 되도록 하는 창고의 지붕을 설계해라!!
 2. 개념 및 접근법
 - 기둥들의 위치(L), 높이(H)를 받아 우선 저장해보고
 - 최고높이 기둥을 중심으로 좌우 구분해서 면적을 계산
 - 최고높이 기준으로 왼쪽기둥들을 계산
 - 최고높이 기준으로 오른쪽기둥들을 계산
 3. 풀이 결과
 메모리 	 ,시간

 */
public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 기둥의 개수 입력 받기
        List<Pillar> pillarsList  = new ArrayList<>(); // 기둥 리스트 초기화

        // 입력 받은 기둥 정보를 리스트에 추가
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            pillarsList.add(new Pillar(L, H));
        }

        // 위치 기준으로 기둥 리스트 정렬
        pillarsList.sort(Comparator.comparingInt(p -> p.x));

        // 최대 높이의 기둥 찾기
        Pillar maxPillar = Collections.max(pillarsList, Comparator.comparingInt(p -> p.height));

        int area = 0;
        Pillar prev = pillarsList.get(0);
        boolean reachedMax = false;

        for (Pillar current : pillarsList) {
            if (!reachedMax) {
                if (current.height >= prev.height) {
                    area += (current.x - prev.x) * prev.height;
                    prev = current;
                }
                if (current == maxPillar) reachedMax = true;
            } else break; // 최대 높이 기둥 도달 시 왼쪽 탐색 종료
        }

        // 오른쪽 탐사를 위해 리스트를 역순으로 정렬
        Collections.reverse(pillarsList);
        prev = pillarsList.get(0); // 이제 prev를 오른쪽 끝 기둥으로 설정
        reachedMax = false; // 다시 최대 기둥에 도달했는지 확인하기 위한 플래그

        for (Pillar current : pillarsList) {
            if (!reachedMax) {
                if (current.height >= prev.height) {
                    area += (prev.x - current.x) * prev.height;
                    prev = current;
                }
                if (current == maxPillar) reachedMax = true;
            } else break; // 최대 높이 기둥 도달 시 오른쪽 탐색 종료
        }

        // 최대 높이 기둥의 면적 추가 (너비는 항상 1)
        area += maxPillar.height;

        System.out.println(area);
    }


}

class Pillar {
    int x;
    int height;

    public Pillar (int x, int height){
        this.x = x;
        this.height = height;
    }
}