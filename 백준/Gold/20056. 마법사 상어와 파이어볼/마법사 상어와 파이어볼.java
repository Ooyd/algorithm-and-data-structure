import java.util.*;
import java.io.*;

/**
 1. 문제 정리
 - 필드 크기 N * N이다.
 - 파이어볼 개수 M, 이동명령횟수는 K이다.
 - 파이어볼의 초기위치, 질량, 속도, 방향이 주어진다.
 - 같은 칸에 여러 파이어 볼이 모일 경우 합쳐짐. 합쳐진 파이어볼은 4개로 분할되고, 해당 조건은 아래와 같다.
 질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
 속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
 질량이 0인 파이어볼은 소멸되어 없어진다.

 2. 개념 및 접근법
 - static 변수로 클래스내부에서 호출될수 있게 하고. 요구사항에 맞춰서 메서드별로 작성해보자.
 - 이동, 합치, 분리

 3. 풀이 결과

 */
public class Main {

    static int n,m,k;
    static ArrayList<Fireball>[][] map;
    static int[][] dir = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

    static class Fireball {
        //질량,속도,방향
        int m, s ,d;
         Fireball(int m, int s,int d) {
            this.m = m;
            this.s = s;
            this.d = d;
         }


    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //선언
        map = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        //할당
        while(m -->  0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[x][y].add(new Fireball(m,s,d));
        }

        //로직
        while(k --> 0){
            moveFireballs();
            mergeAndDivideFireball();
        }

        print();
    }

    private static void print() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for(Fireball fireball : map[i][j]){
                    cnt += fireball.m;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void mergeAndDivideFireball() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].size() > 1){

                    //선언
                    int totalM = 0;
                    int totalS = 0;
                    boolean isEven = true, isOdd = true;

                    for(Fireball fireball : map[i][j]){
                        totalM += fireball.m;
                        totalS += fireball.s;

                        if (fireball.d % 2 == 0) isOdd = false;
                        else isEven = false;
                    }


                    // 조건작성
                    int nM = totalM / 5;
                    int nS = totalS / map[i][j].size();
                    map[i][j].clear();

//                    if(nM == 0) continue;

                    //비교 & 할당
                    if(nM > 0 ){
                        for (int l = 0; l <4; l++) {
                            int nD = isEven || isOdd ? l * 2 : l * 2 + 1;
                            map[i][j].add(new Fireball(nM,nS,nD));
                        } 
                    }
                    


                }
            }
        }
    }


    private static void moveFireballs() {
        //선언
        ArrayList<Fireball>[][] copyMap = new ArrayList[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n;j++){
                copyMap[i][j] = new ArrayList<>();
            }
        }

        //할당
        for(int i = 0; i<n; i++){
            for(int j =0; j<n;j++){
                for(Fireball fireball: map[i][j]){
                    int nx = (i + dir[fireball.d][0] * fireball.s) % n;
                    while (nx < 0) nx += n;

                    int ny = (j + dir[fireball.d][1] * fireball.s) % n;
                    while (ny < 0) ny += n;

                    copyMap[nx][ny].add(new Fireball(fireball.m, fireball.s, fireball.d));
                }
            }
        }

        //할당
        map = copyMap;
    }


}