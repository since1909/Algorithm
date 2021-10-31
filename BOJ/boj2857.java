package BOJ;

import java.util.*;
import java.util.regex.*;
import java.io.*;

class boj2857{
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 5; i++){
            String line = br.readLine();
            Pattern pattern = Pattern.compile(".*FBI.*");
            Matcher matcher = pattern.matcher(line);
            if(matcher.find()){
                sb.append(i+1).append(" ");
            }
        }
        if(sb.length() == 0){
            System.out.println("HE GOT AWAY!");
        }
        else{
            System.out.println(sb);
        }
    }
}