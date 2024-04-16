import java.io.*;
import java.util.*;


/**
 1. 문제 정리
 - 한 네트워크 내에서 특정 컴퓨터가 해킹당할 경우, 해당 컴퓨터와 연결된 다른 컴퓨터들이 의존성에 따라 순차적으로 감염되는 시뮬레이션을 수행
 - 각 컴퓨터 간의 의존성과 감염 전파 시간이 주어질 때, 총 몇 대의 컴퓨터가 감염되는지와 마지막 컴퓨터가 감염되기까지의 시간을 구한다.

 2. 개념 및 접근법
 - 노드와 간선, 가중치가 주어지기에 다익스트라 사용

 3. 풀이 결과
 -
 */

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[] infectionTime;
    static ArrayList<ArrayList<Dependency>> network;

    static class Dependency implements Comparable<Dependency> {
        int target, time;

        Dependency(int target, int time) {
            this.target = target;
            this.time = time;
        }

        @Override
        public int compareTo(Dependency other) {
            return this.time - other.time;
        }
    }

    public static void main(String[] args) throws IOException {
        int testCases = Integer.parseInt(reader.readLine().trim());
        StringBuilder results = new StringBuilder();

        for (int testCase = 0; testCase < testCases; testCase++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int computers = Integer.parseInt(tokenizer.nextToken());
            int dependencies = Integer.parseInt(tokenizer.nextToken());
            int hackedComputer = Integer.parseInt(tokenizer.nextToken());

            network = new ArrayList<>();
            infectionTime = new int[computers + 1];
            Arrays.fill(infectionTime, Integer.MAX_VALUE);
            for (int i = 0; i <= computers; i++) {
                network.add(new ArrayList<>());
            }

            for (int i = 0; i < dependencies; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());
                int time = Integer.parseInt(tokenizer.nextToken());
                network.get(b).add(new Dependency(a, time));
            }

            dijkstra(hackedComputer);

            int infectedCount = 0;
            int maxInfectionTime = 0;
            for (int i = 1; i <= computers; i++) {
                if (infectionTime[i] != Integer.MAX_VALUE) {
                    infectedCount++;
                    if (infectionTime[i] > maxInfectionTime) {
                        maxInfectionTime = infectionTime[i];
                    }
                }
            }

            results.append(infectedCount).append(" ").append(maxInfectionTime).append("\n");
        }
        System.out.print(results);
    }

    static void dijkstra(int start) {
        PriorityQueue<Dependency> queue = new PriorityQueue<>();
        queue.offer(new Dependency(start, 0));
        infectionTime[start] = 0;

        while (!queue.isEmpty()) {
            Dependency current = queue.poll();
            int currentNode = current.target;

            if (infectionTime[currentNode] < current.time) continue;

            for (Dependency next : network.get(currentNode)) {
                if (infectionTime[next.target] > infectionTime[currentNode] + next.time) {
                    infectionTime[next.target] = infectionTime[currentNode] + next.time;
                    queue.offer(new Dependency(next.target, infectionTime[next.target]));
                }
            }
        }
    }
}
