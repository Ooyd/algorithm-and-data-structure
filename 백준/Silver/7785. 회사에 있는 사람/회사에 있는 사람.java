import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> currentlyInCompany = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            // "입장"과 "퇴장" 상태를 올바르게 비교하여 처리
            if ("enter".equals(status)) {
                currentlyInCompany.add(name); // 입장 시 이름 추가
            } else if ("leave".equals(status)) {
                currentlyInCompany.remove(name); // 퇴장 시 이름 제거
            }
        }

        // 역순으로 정렬하기 위해 리스트로 변환
        ArrayList<String> sortedNames = new ArrayList<>(currentlyInCompany);
        Collections.sort(sortedNames, Collections.reverseOrder());

        // 이름 출력
        for (String name : sortedNames) {
            System.out.println(name);
        }
    }
}
