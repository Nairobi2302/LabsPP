import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Scanner;

public class Program1 {

    public BigDecimal calculateSeriesSum(BigDecimal x, int k) {
        BigDecimal e = BigDecimal.ONE.divide(BigDecimal.TEN.pow(k));
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal temp = BigDecimal.ONE;
        BigInteger i = BigInteger.ZERO;
        while (temp.abs().compareTo(e) >= 0) {
            sum = sum.add(temp);
            i = i.add(BigInteger.ONE);
            temp = temp.multiply(x).divide(BigDecimal.valueOf(i.intValue()), MathContext.DECIMAL128);
        }
        return sum;
    }

    public BigDecimal calculateStandardResult(BigDecimal x) {
        return BigDecimal.valueOf(Math.exp(x.doubleValue()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение x: ");
        double xValue = scanner.nextDouble();
        BigDecimal x = BigDecimal.valueOf(xValue);

        System.out.print("Введите значение k: ");
        int k = scanner.nextInt();

        Program1 program = new Program1();
        BigDecimal sum = program.calculateSeriesSum(x, k);
        System.out.println("Приближенное значение суммы ряда: " + sum);
        BigDecimal standardResult = program.calculateStandardResult(x);
        System.out.println("Значение, вычисленное через стандартные функции: " + standardResult);
        scanner.close();
    }
}
