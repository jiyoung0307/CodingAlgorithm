import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 학생 수
        String[] students = br.readLine().split(" "); // 학생 이름 목록

        // 1. 인기도 초기화
        Map<String, Integer> hm = new HashMap<>();
        for (String name : students) {
            hm.put(name, 0);
        }

        // 2. 각 학생이 좋아하는 사람 처리
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String name = st.nextToken();
                hm.put(name, hm.getOrDefault(name, 0) + 1);
            }
        }

        // 3. Map → List 변환
        List<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());

        // 4. 정렬
        Collections.sort(list, (a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue(); // 인기도 내림차순
            }
            return a.getKey().compareTo(b.getKey()); // 이름 오름차순
        });

        // 5. 출력
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e : list) {
            sb.append(e.getKey()).append(" ").append(e.getValue()).append("\n");
        }
        System.out.print(sb.toString());
    }
}
