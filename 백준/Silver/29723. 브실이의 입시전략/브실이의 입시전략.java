import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수강 과목 수
        int M = Integer.parseInt(st.nextToken()); // 반영 과목 수
        int K = Integer.parseInt(st.nextToken()); // 공개 과목 수

        // 과목명 -> 점수
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            scoreMap.put(name, score);
        }

        // 공개 과목 집합
        Set<String> known = new HashSet<>();
        for (int i = 0; i < K; i++) {
            String t = br.readLine().trim();
            known.add(t);
        }

        // 1) 공개 과목 점수 합
        long knownSum = 0;
        for (String k : known) {
            knownSum += scoreMap.get(k);
        }

        // 2) 미공개 과목 점수 목록 만들기
        List<Integer> unknownScores = new ArrayList<>();
        for (Map.Entry<String, Integer> e : scoreMap.entrySet()) {
            if (!known.contains(e.getKey())) {
                unknownScores.add(e.getValue());
            }
        }

        // 3) 오름차순 정렬
        Collections.sort(unknownScores);

        int pick = M - K; // 미공개 중에서 뽑아야 하는 개수 (0일 수도 있음)

        long minSum = knownSum;
        long maxSum = knownSum;

        if (pick > 0) {
            // 4) 최소: 가장 낮은 점수부터 pick개
            for (int i = 0; i < pick; i++) {
                minSum += unknownScores.get(i);
            }
            // 5) 최대: 가장 높은 점수부터 pick개
            int size = unknownScores.size();
            for (int i = 0; i < pick; i++) {
                maxSum += unknownScores.get(size - 1 - i);
            }
        }

        System.out.println(minSum + " " + maxSum);
    }
}
