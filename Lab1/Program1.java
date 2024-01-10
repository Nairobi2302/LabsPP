import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Scanner;


public class Program1 
{
	public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите значение x: ");
        double x = scanner.nextDouble();
        
        System.out.print("Введите значение k: ");
        int k = scanner.nextInt();
        
        BigDecimal e = BigDecimal.ONE.divide(BigDecimal.TEN.pow(k));
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal temp = BigDecimal.ONE;
        BigInteger i = BigInteger.ZERO;
        while (temp.abs().compareTo(e) >= 0)
        {
        	sum = sum.add(temp);
            i = i.add(BigInteger.ONE);
            temp = temp.multiply(BigDecimal.valueOf(x)).divide(BigDecimal.valueOf(i.intValue()), MathContext.DECIMAL128);
        }
        System.out.println("Приближенное значение суммы ряда: " + sum);
        BigDecimal standardResult = BigDecimal.valueOf(Math.exp(x));
        
        System.out.println("Значение, вычисленное через стандартные функции: " + standardResult);
        scanner.close();
    }	       
}
