package task1;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        BigInteger n = new BigInteger(args[0]);
        BigInteger m = new BigInteger(args[1]);
        BigInteger value;
        BigInteger stepNumber = BigInteger.ZERO;
        do {
            BigInteger index = getIndexByStepNumber(stepNumber, n, m);
            value = getValueByIndex(index, n);
            if (stepNumber.compareTo(BigInteger.ZERO) == 0 || value.compareTo(BigInteger.ONE) != 0) {
                System.out.print(value);
            }
            stepNumber = stepNumber.add(BigInteger.ONE);
        } while (stepNumber.compareTo(BigInteger.ONE) == 0 || value.compareTo(BigInteger.ONE) != 0);
    }

    /**
     * Метод возвращает значение элемента с индексом index из кругового массива размерностью n
     *
     * @param index индекс элемента из кругового массива
     * @param n     число задающее круговой массив
     * @return значение элемента с заданным индексом
     */
    private static BigInteger getValueByIndex(BigInteger index, BigInteger n) {
        return index.remainder(n).add(BigInteger.ONE);
    }

    /**
     * Метод возвращает индекса элемента из кругового массива для обхода с номером stepNumber
     *
     * @param stepNumber номер обхода
     * @param n          число задающее круговой массив
     * @param m          длина обхода
     * @return индекс элемента из
     */
    private static BigInteger getIndexByStepNumber(BigInteger stepNumber, BigInteger n, BigInteger m) {
        return stepNumber.multiply(m.subtract(BigInteger.ONE)).remainder(n);
    }
}
