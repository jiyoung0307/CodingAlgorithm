import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 파일 개수 입력 받기
        int n = Integer.parseInt(scanner.nextLine());

        // 파일 이름들을 저장할 배열 만들기
        String[] files = new String[n];

        // 파일 이름을 입력받아 배열에 저장
        for (int i = 0; i < n; i++) {
            files[i] = scanner.nextLine();
        }

        // 모든 파일 이름의 길이는 같다고 했으므로 첫 번째 파일 길이 사용
        int length = files[0].length();

        // 한 글자씩 확인하면서 패턴 출력
        for (int i = 0; i < length; i++) {
            // 첫 번째 파일의 i번째 글자를 기준 문자로 잡기
            char letter = files[0].charAt(i);

            // 이 글자가 모든 파일에서 똑같은지 확인할 변수
            boolean same = true;

            // 나머지 파일들과 비교
            for (int j = 1; j < n; j++) {
                if (files[j].charAt(i) != letter) {
                    same = false;  // 하나라도 다르면 false로 바꾸고 멈춤
                    break;
                }
            }

            // 결과 출력
            if (same) {
                System.out.print(letter);  // 모두 같으면 그 글자 출력
            } else {
                System.out.print('?');     // 다르면 ? 출력
            }
        }

        System.out.println(); // 줄바꿈
    }
}
