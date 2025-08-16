import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // x값, y값 각각의 “등장 횟수”를 세는 맵
        HashMap<Integer, Integer> xCounts = new HashMap<>();
        HashMap<Integer, Integer> yCounts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // x 값 개수 세기
            xCounts.put(x, xCounts.getOrDefault(x, 0) + 1);
            // y 값 개수 세기
            yCounts.put(y, yCounts.getOrDefault(y, 0) + 1);
        }

        long answer = 0;

        // 같은 x 값을 가진 점이 2개 이상이면 "세로 직선" 1개
        for (Map.Entry<Integer, Integer> e : xCounts.entrySet()) {
            if (e.getValue() >= 2) answer++;
        }

        // 같은 y 값을 가진 점이 2개 이상이면 "가로 직선" 1개
        for (Map.Entry<Integer, Integer> e : yCounts.entrySet()) {
            if (e.getValue() >= 2) answer++;
        }

        System.out.println(answer);
    }
}
