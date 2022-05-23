package task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<BigInteger> numbers = readFile(args[0]);
        // Сортируем значения по возрастанию
        Collections.sort(numbers);
        int size = numbers.size();
        // ищем медиану
        if (size % 2 == 1) {
            // если количество элементов нечетное, берем среднее значение
            System.out.println(count(numbers, numbers.get(size / 2)));
        } else {
            // если количество элементов четное, то берем два элемента в середине и проверяем все значения между ними
            BigInteger mean1 = numbers.get(size / 2 - 1);
            BigInteger mean2 = numbers.get(size / 2);
            if (mean1.compareTo(mean2) == 0) {
                // элементы равны
                System.out.println(count(numbers, mean1));
            } else {
                // элементы не равны, перебираем все варианты между mean1 и mean2
                BigInteger m = mean1;
                BigInteger count = null;
                do {
                    BigInteger c = count(numbers, m);
                    if (count == null) {
                        count = c;
                    } else {
                        if (c.compareTo(count) < 0) {
                            count = c;
                        }
                    }
                    m = m.add(BigInteger.ONE);
                } while (m.compareTo(mean2) < 0);
                System.out.println(count);
            }
        }
    }

    private static BigInteger count(List<BigInteger> numbers, BigInteger mean) {
        BigInteger count = BigInteger.ZERO;
        for (BigInteger i : numbers) {
            count = count.add(mean.subtract(i).abs());
        }
        return count;
    }

    /**
     * Метод считывает содержимое файла построчно в список
     *
     * @param path путь к файлу
     * @return список строк считанных из файла
     */
    private static List<BigInteger> readFile(String path) {
        List<BigInteger> list = new ArrayList<>();
        String readableLine;
        try (FileReader file = new FileReader(path);
             BufferedReader br = new BufferedReader(file);) {
            while ((readableLine = br.readLine()) != null) {
                list.add(new BigInteger(readableLine));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
