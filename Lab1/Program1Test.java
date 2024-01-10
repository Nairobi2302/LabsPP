import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Program1Test {

    @Test
    public void testSeriesSumCalculation() {
        Program1 program = new Program1();

        BigDecimal x = BigDecimal.valueOf(2.5); // Значение x
        int k = 10; // Значение k

        BigDecimal actualSum = program.calculateSeriesSum(x, k);
        BigDecimal expectedSum = BigDecimal.valueOf(12.1824939607); // Ожидаемое значение суммы ряда

        assertEquals(expectedSum, actualSum, "Проверка на вычисление суммы ряда");
    }

    @Test
    public void testStandardFunctionCalculation() {
        Program1 program = new Program1();

        BigDecimal x = BigDecimal.valueOf(2.5); // Значение, для которого вычисляется экспонента
        BigDecimal actualResult = program.calculateStandardResult(x);
        BigDecimal expectedStandardResult = BigDecimal.valueOf(Math.exp(2.5)); // Ожидаемое значение, вычисленное через стандартные функции

        assertEquals(expectedStandardResult, actualResult, "Проверка на вычисление с использованием стандартных функций");
    }
}
