import java.io.*;
import java.util.*;

public class Main {

    public static boolean isNumeric(String str) throws ScannerException {
        try {
//            Double.parseDouble(str);
            Integer.parseInt(str);
            if (Integer.parseInt(str) > 10) {
                throw new ScannerException("Число должно быть в диапазоне от 1 до 10 включительно.");
            }
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static String calc(String input) throws ScannerException {
        String accepted = "-+*/";
        int[] nums = new int[2];
        int i = 0;
        char operation = ' ';
        String [] parts = input.split(" ");
        if (parts.length < 3) {
            throw new ScannerException("Слишком мало значений! Выражение надо вводить одной строкой.");
        }
        if (parts.length > 3) {
            throw new ScannerException("Слишком много значений!");
        }
        for (String part: parts) {
            if (isNumeric(part)) {
//                System.out.println(member);
                nums[i++] = Integer.parseInt(part);
            } else {
                if (part.length() == 1) {
                    operation = part.charAt(0);
                    if (accepted.indexOf(operation) < 0) {
                        throw new ScannerException("Не правильная операция!");
                    }
                }
            }
        }
        int res = 0;
        switch (operation) {
            case '+': res = nums[0] + nums[1]; break;
            case '-': res = nums[0] - nums[1]; break;
            case '*': res = nums[0] * nums[1]; break;
            case '/': res = nums[0] / nums[1]; break;
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) throws ScannerException {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите выражение вида 'a операция b': ");
            String expr = in.nextLine();
            System.out.println(calc(expr));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}