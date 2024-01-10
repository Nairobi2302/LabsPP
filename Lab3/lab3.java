import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class lab3 {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath= "output.txt";

        try {
            // Чтение первой и второй строки из файла
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            String firstLine = reader.readLine();
            String secondLine = reader.readLine();
            reader.close();

            // Разбиение первой строки на лексемы с использованием разделителей из второй строки
            List<String> lexemes = splitToLexemes(firstLine, secondLine);

            // Поиск целых чисел и времени в лексемах
            List<Integer> integers = findIntegers(lexemes);
            List<String> times = findTimes(lexemes);

            // Генерация случайного числа и добавление его после лексемы-времени или в середину строки
            String modifiedLine = addRandomNumber(firstLine, times);

            // Удаление самой короткой подстроки, начинающейся с цифры
            modifiedLine = removeShortestSubstring(modifiedLine);
