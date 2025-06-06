import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] num;
    static int[][] dy;
    static ArrayList<Integer>[] arrList;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        num = new int[n + 1];
        dy = new int[n + 1][2];
        arrList = new ArrayList[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            arrList[i] = new ArrayList();
        }

        for (int i = 1; i <= n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrList[x].add(y);
            arrList[y].add(x);
        }

        dfs(1, -1);

        System.out.println(Math.max(dy[1][0], dy[1][1]));
    }

    static void dfs(int x, int par) {
        // x를 root로 하는 subtree에서 root를 선택하지 않고서 가능한 최대 주민 수
        dy[x][0] = 0;
        // x를 root로 하는 subtree에서 root를 선택하고서 가능한 최대 주민 수
        dy[x][1] = num[x];

        // 연결된 자식 노드들을 순회하면서 DP 테이블 업데이트
        for (int y : arrList[x]) {
            // 부모 노드는 다시 방문하지 않도록 건너뜀
            if (y == par) continue;
            dfs(y, x);
            // x를 선택하지 않은 경우: 자식 노드를 선택하든 안 하든 최대값을 더함
            dy[x][0] += Math.max(dy[y][0], dy[y][1]);
            // x를 선택한 경우: 자식 노드는 선택할 수 없으므로 dy[y][0]만 더함
            dy[x][1] += dy[y][0];
        }

    }
}