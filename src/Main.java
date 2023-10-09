import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        while (true) {
            String formula = console.nextLine();
            if (formula.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                String res1 = calc(formula);
                System.out.println("Результат: " + res1);
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
        console.close();
    }

    public static String calc(String formula_any) {
        String[] formula1 = formula_any.split(" ");

        if (formula1.length == 1) {
            throw new IllegalArgumentException("строка не является математической операцией");
        }
        if (formula1.length != 3) {
            throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        char symbol =formula1[1].charAt(0);
        int x = Integer.parseInt(formula1[0]);
        int y = Integer.parseInt(formula1[2]);

        if (!(x > 0 && x <= 10 && y > 0 && y <= 10)) {
            throw new IllegalArgumentException("Калькулятор должен принимать на вход числа от 1 до 10 включительно.");
        }

        int res;
        switch (symbol) {
            case '+':
                res = x + y;
                break;
            case '-':
                res = x - y;
                break;
            case '*':
                res = x * y;
                break;
            case '/':
                res = x / y;
                break;
            default:
                throw new IllegalArgumentException("Можно выбрать только: + - * /");
        }
        return Integer.toString(res);
    }
}