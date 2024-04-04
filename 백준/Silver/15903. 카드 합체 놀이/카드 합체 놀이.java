import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            minHeap.offer(Long.parseLong(st.nextToken()));
        }


        for (int i = 0; i < m; i++) {
            long x = minHeap.poll();
            long y = minHeap.poll();

            long sum = x + y;
            minHeap.add(sum);
            minHeap.add(sum);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += minHeap.poll();
        }
        System.out.println(ans);
    }
}


