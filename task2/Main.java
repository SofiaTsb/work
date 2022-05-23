package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> file1Line = readFile(args[0]);
        List<String> file2Line = readFile(args[1]);

        String[] x0y0Array = file1Line.get(0).split(" ");
        float x0 = Float.parseFloat(x0y0Array[0].replace(",", "."));
        float y0 = Float.parseFloat(x0y0Array[1].replace(",", "."));
        float r = Float.parseFloat(file1Line.get(1));
        // квадрат радиуса
        double r2 = Math.pow(r, 2);
        for (int i = 0; i < file2Line.size(); i++) {
            String[] xy1Mas = file2Line.get(i).split(" ");
            float x1 = Float.parseFloat(xy1Mas[0].replace(",", "."));
            float y1 = Float.parseFloat(xy1Mas[1].replace(",", "."));
            // квадрат расстояния между центром окружности и точкой
            double v = Math.pow(x1 - x0, 2) + Math.pow(y1 - y0, 2);
            if (v < r2) {
                // точка внутри окружности
                System.out.println(1);
            } else if (v == r2) {
                // точка лежит на окружности
                System.out.println(0);
            } else {
                // точка снаружи окружности
                System.out.println(2);
            }
        }
    }

    /**
     * Метод считывает содержимое файла построчно в список
     *
     * @param path путь к файлу
     * @return список строк считанных из файла
     */
    public static List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        String readableLine;
        try (FileReader file = new FileReader(path);
             BufferedReader br = new BufferedReader(file);) {
            while ((readableLine = br.readLine()) != null) {
                list.add(readableLine);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
