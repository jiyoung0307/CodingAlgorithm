import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) { // EOF까지 읽기
            int lowerCount = 0;
            int upperCount = 0;
            int digitCount = 0;
            int spaceCount = 0;

            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                if (Character.isLowerCase(ch)) {
                    lowerCount++;
                } else if (Character.isUpperCase(ch)) {
                    upperCount++;
                } else if (Character.isDigit(ch)) {
                    digitCount++;
                } else if (ch == ' ') {
                    spaceCount++;
                }
            }

            System.out.println(lowerCount + " " + upperCount + " " + digitCount + " " + spaceCount);
        }
    }
}