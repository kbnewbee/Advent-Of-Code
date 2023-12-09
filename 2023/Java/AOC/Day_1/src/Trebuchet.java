import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Trebuchet {

    private final String inputFilePath = "E:\\github\\Advent_Of_Code\\2023\\Java\\AOC\\Day_1\\resources\\input.txt";

    public void solution1() {
        Path path = Paths.get(inputFilePath);
        int sum = 0;

        try {
            List<String> lines = Files.readAllLines(path);

            long st = System.currentTimeMillis();
            for (String line : lines) {
                int num = getNumber(line);
                sum += num;
            }

            System.out.println("sum of part 1 = " + sum);

            long ed = System.currentTimeMillis();
            System.out.println("time taken s1 = " + (ed - st) + "ms");

        } catch (IOException e) {
        }
    }

    private int getNumber(String line) {

        int fd = 0, ld = 0;
        for (char c : line.toCharArray()) {
            if (c >= '1' && c <= '9') {
                fd = c - '0';
                //System.out.println(fd);
                break;
            }
        }

        int n = line.length();
        for (int i = n - 1; i >= 0; i--) {
            char c = line.charAt(i);
            if (c >= '1' && c <= '9') {
                ld = c - '0';
                break;
            }
        }

        int num = fd * 10 + ld;
        return num;
    }

    public void solution2() {
        Path path = Paths.get(inputFilePath);
        int sum = 0;

        try {
            List<String> lines = Files.readAllLines(path);

            long st = System.currentTimeMillis();
            for (String line : lines) {
                //System.out.println(line);
                int num = getNumberUpdated(line);
                sum += num;
            }

            System.out.println("sum of part 2 = " + sum);

            long ed = System.currentTimeMillis();
            System.out.println("time taken s2 = " + (ed - st) + "ms");
        } catch (IOException e) {
        }


    }

    private int getN(int n, char c, String line, int i, int len) {
        if (c >= '1' && c <= '9') {
            n = c - '0';
        } else if (c == 'o' && (i + 3) <= len) {
            String substring = line.substring(i, i + 3);
            //System.out.println(substring);
            if (substring.equals("one")) {
                n = 1;
            }
        } else if (c == 't') {
            String substring = ((i + 3) <= len) ? line.substring(i, i + 3) : "";
            //System.out.println(substring);
            if (substring.equals("two")) {
                n = 2;
            }
            substring = ((i + 5) <= len) ? line.substring(i, i + 5) : "";
            if (substring.equals("three")) {
                n = 3;
            }
        } else if (c == 'f' && (i + 4) <= len) {
            String substring = line.substring(i, i + 4);
            //System.out.println(substring);
            if (substring.equals("four")) {
                n = 4;
            }
            if (substring.equals("five")) {
                n = 5;
            }
        } else if (c == 's') {
            String substring = ((i + 3) <= len) ? line.substring(i, i + 3) : "";
            //System.out.println(substring);
            if (substring.equals("six")) {
                n = 6;
            }
            substring = ((i + 5) <= len) ? line.substring(i, i + 5) : "";
            if (substring.equals("seven")) {
                n = 7;
            }
        } else if (c == 'e' && (i + 5) <= len) {
            String substring = line.substring(i, i + 5);
            //System.out.println(substring);
            if (substring.equals("eight")) {
                n = 8;
            }
        } else if (c == 'n' && (i + 4) <= len) {
            String substring = line.substring(i, i + 4);
            //System.out.println(substring);
            if (substring.equals("nine")) {
                n = 9;
            }
        }

        return n;
    }

    private int getNumberUpdated(String line) {
        int fd = 0, ld = 0;

        int n = line.length();
        for (int i = 0; i < n; i++) {
            char c = line.charAt(i);
            if (fd == 0) {
                fd = getN(fd, c, line, i, n);
                ld = fd;
            } else {
                ld = getN(ld, c, line, i, n);
            }
        }

        int num = fd * 10 + ld;
        return num;
    }
}
