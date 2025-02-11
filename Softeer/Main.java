package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder hidden = new StringBuilder();
        while (st.hasMoreTokens()) {
            hidden.append(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder menu = new StringBuilder();
        while (st.hasMoreTokens()) {
            menu.append(st.nextToken());
        }

        if(menu.toString().indexOf(hidden.toString()) == -1){
            System.out.println("normal");
        }

        System.out.println("secret");
    }
}