import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputIPv6 = br.readLine();

        // IPv6 주소를 :: 기준으로 앞뒤 부분으로 분리
        String[] ipv6Parts = inputIPv6.split("::");

        String[] beforeParts;
        String[] afterParts;

        // ::기준 전방향 IPv6 처리
        if (ipv6Parts[0].isEmpty()) {
            beforeParts = new String[0];
        } else {
            beforeParts = ipv6Parts[0].split(":");
        }

        // ::기준 후방향 IPV6 처리
        if (ipv6Parts.length == 2) {
            afterParts = ipv6Parts[1].split(":");
        } else {
            afterParts = new String[0];
        }

        //전방향, 후방향 제외한 0000이 들어갈 그룹갯수
        int missingGroups = 8 - (beforeParts.length + afterParts.length);

        StringBuilder fullIPv6 = new StringBuilder();

        for (String part : beforeParts) {
            StringBuilder paddedPart = new StringBuilder(part);
            while (paddedPart.length() < 4) {
                paddedPart.insert(0,"0");
            }
            fullIPv6.append(paddedPart).append(":");        }

        for (int i = 0; i < missingGroups; i++) {
            fullIPv6.append("0000:");
        }

        for (int i = 0; i < afterParts.length; i++) {
            StringBuilder paddedPart = new StringBuilder(afterParts[i]);
            while (paddedPart.length() < 4) {
                paddedPart.insert(0, '0');
            }
            fullIPv6.append(paddedPart);
            if (i < afterParts.length - 1) {
                fullIPv6.append(":");
            }
        }

        if (fullIPv6.charAt(fullIPv6.length() - 1) == ':') {
            fullIPv6.deleteCharAt(fullIPv6.length() - 1);
        }


        System.out.println(fullIPv6.toString());
    }
}
