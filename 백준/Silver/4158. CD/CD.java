import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) { this.in = is; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, s = 1, x = 0;
            // skip spaces
            do { c = read(); } while (c <= ' ' && c != -1);
            if (c == '-') { s = -1; c = read(); }
            while (c > ' ') {
                x = x * 10 + (c - '0');
                c = read();
            }
            return x * s;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        while (true) {
            int N = fs.nextInt();
            int M = fs.nextInt();
            if (N == 0 && M == 0) break;

            int[] A = new int[N];
            int[] B = new int[M];

            for (int i = 0; i < N; i++) A[i] = fs.nextInt();
            for (int j = 0; j < M; j++) B[j] = fs.nextInt();

            int i = 0, j = 0, count = 0;
            while (i < N && j < M) {
                if (A[i] == B[j]) {
                    count++;
                    i++; j++;
                } else if (A[i] < B[j]) {
                    i++;
                } else {
                    j++;
                }
            }
            out.append(count).append('\n');
        }
        System.out.print(out.toString());
    }
}
