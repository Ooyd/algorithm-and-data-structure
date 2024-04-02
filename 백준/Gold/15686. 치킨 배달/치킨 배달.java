import java.util.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicReference;

class Point {
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{

    static int N,M;
    static int[][] map;
    static ArrayList<Point> house;
    static ArrayList<Point> chicken;
    static int ans;
    static boolean[] open;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) house.add(new Point(i,j));
                else if (map[i][j] == 2) chicken.add(new Point(i,j));
            }
        }

        //Integer.MAX_VALUE하는 이유
        ans = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];

        DFS(0,0);
        System.out.println(ans);

    }

    private static void DFS(int start, int cnt) {
        if(cnt == M){
            int res = 0;
            for(int i =0; i < house.size(); i++){
                int temp = Integer.MAX_VALUE;
                for(int j =0; j < chicken.size(); j++){
                    if(open[j]){
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        temp = Math.min(temp,distance);
                    }
                }

                res += temp;
            }
            ans = Math.min(ans,res);
//            return;
        }
//        백트래킹 적용
        for(int i = start; i < chicken.size(); i++){
            open[i] = true;
            DFS(i + 1, cnt +1);
            open[i] = false;
        }
    }
}