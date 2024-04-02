import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputIpv6 = br.readLine();

        String[] parts = inputIpv6.split("::");
        String[] beforeParts;
        String[] afterParts;

        if(parts[0].isEmpty()){
           beforeParts = new String[0];
        } else {
            beforeParts = parts[0].split(":");
        }

        if(parts.length == 2){
            afterParts = parts[1].split(":");
        } else{
            afterParts = new String[0];
        }

        int emptyValueCount = 8 -(beforeParts.length + afterParts.length);

        StringBuilder fullIpv6 = new StringBuilder();

        for(String part : beforeParts){
            StringBuilder tempPart = new StringBuilder(part);

            while(tempPart.length() < 4){
                tempPart.insert(0,"0");
            }
            fullIpv6.append(tempPart).append(":");
        }

        for(int i=0; i<emptyValueCount;i++){
            fullIpv6.append("0000:");
        }

        for(String part : afterParts){
            StringBuilder tempPart = new StringBuilder(part);
            while(tempPart.length() < 4){
                tempPart.insert(0,"0");
            }
            fullIpv6.append(tempPart).append(":");
        }

        if(fullIpv6.charAt(fullIpv6.length()-1) == ':'){
            fullIpv6.deleteCharAt(fullIpv6.length()-1);
        }

        System.out.println(fullIpv6.toString());

    }
}