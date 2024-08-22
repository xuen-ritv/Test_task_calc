import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 3 + 2):");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        // Удаляем лишние пробелы из строки
        input = input.trim();

        // Определяем операцию (возможны: +, -, *, /)
        String[] operators = {"+", "-", "*", "/"};
        String operator = null;

        for (String op : operators) {
            if (input.contains(op)) {
                operator = op;
                break;
            }
        }

        if (operator == null) {
            throw new Exception("Некорректный оператор. Допустимы только +, -, *, /");
        }

        // Разделяем строку по оператору
        String[] parts = input.split("\\s*\\" + operator + "\\s*");

        if (parts.length != 2) {
            throw new Exception("Некорректный формат ввода.");
        }

        int a;
        int b;

        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            throw new Exception("Оба операнда должны быть целыми числами.");
        }

        // Проверяем, что числа находятся в диапазоне от 1 до 10 включительно
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Числа должны быть в диапазоне от 1 до 10 включительно.");
        }

        int result;

        // Выполняем операцию
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new Exception("Деление на ноль недопустимо.");
                }
                result = a / b;
                break;
            default:
                throw new Exception("Неизвестная ошибка.");
        }

        return String.valueOf(result);
    }
}