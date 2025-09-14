import java.util.Scanner;
import java.util.Arrays;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        Methods m = new Methods();
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

        while (true) {
            printMainMenu();
            int section = safeIntInRange(sc, 0, 4, "Выберите раздел (0 — выход): ");
            if (section == 0) {
                System.out.println("Выход из программы. До свидания!");
                break;
            }

            while (true) {
                printSectionMenu(section);
                int task = safeIntInRange(sc, 0, 5, "Выберите задачу (0 — назад): ");
                if (task == 0) break;

                try {
                    executeTask(section, task, m, sc);
                } catch (Exception ex) {
                    System.out.println("Ошибка при выполнении задачи: " + ex.getMessage());
                }

                System.out.println("\n--- Нажмите Enter, чтобы вернуться к списку задач ---");
                sc.nextLine(); // ждём Enter
            }
        }

        sc.close();
    }

    private static void printMainMenu() {
        System.out.println("\n=== ЛАБОРАТОРНАЯ №1 — МНОГОУРОВНЕВОЕ МЕНЮ ===");
        System.out.println("1. Методы");
        System.out.println("2. Условия");
        System.out.println("3. Циклы");
        System.out.println("4. Массивы");
        System.out.println("0. Выход");
    }

    private static void printSectionMenu(int section) {
        System.out.println("\n--- Раздел " + section + " ---");
        switch (section) {
            case 1 -> {
                System.out.println("1. Дробная часть (fraction)");
                System.out.println("2. Символ в число (charToNum)");
                System.out.println("3. Двузначное число (is2Digits)");
                System.out.println("4. Принадлежность диапазону (isInRange)");
                System.out.println("5. Все три равны? (isEqual)");
            }
            case 2 -> {
                System.out.println("1. Модуль числа (abs)");
                System.out.println("2. Делится на 3 или 5, но не оба (is35)");
                System.out.println("3. Максимум из трёх (max3)");
                System.out.println("4. Двойная сумма (sum2)");
                System.out.println("5. День недели (day)");
            }
            case 3 -> {
                System.out.println("1. Числа подряд (listNums)");
                System.out.println("2. Чётные числа (chet)");
                System.out.println("3. Длина числа (numLen)");
                System.out.println("4. Квадрат из символов (square)");
                System.out.println("5. Правый треугольник (rightTriangle)");
            }
            case 4 -> {
                System.out.println("1. Поиск первого значения (findFirst)");
                System.out.println("2. Максимум по модулю (maxAbs)");
                System.out.println("3. Добавление массива в массив (add)");
                System.out.println("4. Реверс массива (reverseBack)");
                System.out.println("5. Все вхождения числа (findAll)");
            }
            default -> System.out.println("Неизвестный раздел");
        }
    }

    private static void executeTask(int section, int task, Methods m, Scanner sc) {
        int num = (section - 1) * 5 + task; // 1..20
        switch (num) {
            // Раздел 1
            case 1 -> {
                System.out.println("Пояснение: введите вещественное число x. Результат — дробная часть (x - (int)x).");
                System.out.print("x = ");
                double x = safeDouble(sc);
                // вызываем метод (чтобы использовать реализацию в Methods)
                double methodResult = m.fraction(x);
                // печатаем метод результат (он теперь корректно показывает, например, 0.78 для 6.78)
                System.out.println("Дробная часть: " + methodResult);
            }
            case 2 -> {
                System.out.println("Пояснение: введите один символ (обычно цифру). Если не цифра — вернётся -1.");
                System.out.print("символ = ");
                char c = safeChar(sc);
                System.out.println("Результат: " + m.charToNum(c));
            }
            case 3 -> {
                System.out.println("Пояснение: введите целое число. Проверим, является ли оно двузначным.");
                System.out.print("n = ");
                int n = safeInt(sc);
                System.out.println("Двузначное? " + m.is2Digits(n));
            }
            case 4 -> {
                System.out.println("Пояснение: введите границы диапазона a и b (в любом порядке), затем число num.");
                System.out.print("a = "); int a = safeInt(sc);
                System.out.print("b = "); int b = safeInt(sc);
                System.out.print("num = "); int numIn = safeInt(sc);
                System.out.println("В диапазоне? " + m.isInRange(a, b, numIn));
            }
            case 5 -> {
                System.out.println("Пояснение: введите три целых числа a, b, c. Проверим, все ли равны.");
                System.out.print("a = "); int a = safeInt(sc);
                System.out.print("b = "); int b = safeInt(sc);
                System.out.print("c = "); int c = safeInt(sc);
                System.out.println("Результат: " + m.isEqual(a, b, c));
            }

            // Раздел 2
            case 6 -> {
                System.out.println("Пояснение: введите целое x. Вернём |x|.");
                System.out.print("x = "); int xi = safeInt(sc);
                System.out.println("Модуль: " + m.abs(xi));
            }
            case 7 -> {
                System.out.println("Пояснение: введите целое x. Проверим: делится на 3 или на 5, но не на оба.");
                System.out.print("x = "); int xi2 = safeInt(sc);
                System.out.println("Результат: " + m.is35(xi2));
            }
            case 8 -> {
                System.out.println("Пояснение: введите три целых числа. Найдём максимум.");
                System.out.print("x = "); int x1 = safeInt(sc);
                System.out.print("y = "); int y1 = safeInt(sc);
                System.out.print("z = "); int z1 = safeInt(sc);
                System.out.println("Максимум: " + m.max3(x1, y1, z1));
            }
            case 9 -> {
                System.out.println("Пояснение: введите два целых. Если их сумма в [10..19] — вернётся 20, иначе — сама сумма.");
                System.out.print("a = "); int a1 = safeInt(sc);
                System.out.print("b = "); int b1 = safeInt(sc);
                System.out.println("Результат: " + m.sum2(a1, b1));
            }
            case 10 -> {
                System.out.println("Пояснение: введите номер дня недели (1..7). Вернётся название дня.");
                int d = safeIntInRange(sc, 1, 7, "день (1..7) = ");
                System.out.println("День: " + m.day(d));
            }

            // Раздел 3
            case 11 -> {
                System.out.println("Пояснение: введите целое x. Выведем числа от 0 до x (если x<0 — от 0 до x по убыванию).");
                System.out.print("x = "); int lx = safeInt(sc);
                System.out.println(m.listNums(lx));
            }
            case 12 -> {
                System.out.println("Пояснение: введите целое x. Вернём все чётные числа от 0 до x (или по убыванию при x<0).");
                System.out.print("x = "); int cx = safeInt(sc);
                System.out.println(m.chet(cx));
            }
            case 13 -> {
                System.out.println("Пояснение: введите целое (может быть отрицательным). Вернём количество цифр без знака.");
                System.out.print("x = "); long lx2 = safeLong(sc);
                System.out.println("Длина числа: " + m.numLen(lx2));
            }
            case 14 -> {
                System.out.println("Пояснение: введите размер квадрата (целое > 0). Нарисуем квадрат из '*'.");
                int s = safeIntPositive(sc, "size (>0) = ");
                m.square(s);
            }
            case 15 -> {
                System.out.println("Пояснение: введите высоту треугольника (целое > 0). Нарисуем правый треугольник.");
                int h = safeIntPositive(sc, "height (>0) = ");
                m.rightTriangle(h);
            }

            // Раздел 4
            case 16 -> {
                System.out.println("Пояснение: введите массив (сначала длина, затем элементы), затем число для поиска.");
                int[] arr = readIntArray(sc, "arr");
                System.out.print("Число для поиска = ");
                int key = safeInt(sc);
                System.out.println("Первое вхождение (индекс) = " + m.findFirst(arr, key));
            }
            case 17 -> {
                System.out.println("Пояснение: введите массив (длина > 0). Найдём элемент с наибольшим модулем.");
                int[] arr2 = readIntArrayNonEmpty(sc, "arr");
                System.out.println("Элемент с максимальным модулем = " + m.maxAbs(arr2));
            }
            case 18 -> {
                System.out.println("Пояснение: введите основной массив arr, затем массив ins для вставки, затем позицию pos (0..arr.length).");
                int[] base = readIntArray(sc, "arr");
                int[] ins = readIntArray(sc, "ins");
                int pos = safeIntInRange(sc, 0, base.length, "Позиция вставки pos (0.." + base.length + ") = ");
                System.out.println("Результирующий массив: " + Arrays.toString(m.add(base, ins, pos)));
            }
            case 19 -> {
                System.out.println("Пояснение: введите массив. Вернём его в обратном порядке.");
                int[] arr3 = readIntArray(sc, "arr");
                System.out.println("Реверс: " + Arrays.toString(m.reverseBack(arr3)));
            }
            case 20 -> {
                System.out.println("Пояснение: введите массив, затем число. Найдём все индексы этого числа.");
                int[] arr4 = readIntArray(sc, "arr");
                System.out.print("Число для поиска = ");
                int key2 = safeInt(sc);
                System.out.println("Индексы всех вхождений: " + Arrays.toString(m.findAll(arr4, key2)));
            }

            default -> System.out.println("Задачи с таким номером не существует.");
        }
    }

    // ------------- Ввод и вспомогательные функции -------------
    private static int safeInt(Scanner sc) {
        while (true) {
            String line = sc.nextLine();
            if (line == null) line = "";
            line = line.trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Ошибка: ожидается целое число. Повторите ввод: ");
            }
        }
    }

    private static long safeLong(Scanner sc) {
        while (true) {
            String line = sc.nextLine();
            if (line == null) line = "";
            line = line.trim();
            try {
                return Long.parseLong(line);
            } catch (NumberFormatException e) {
                System.out.print("Ошибка: ожидается целое (long). Повторите ввод: ");
            }
        }
    }

    private static double safeDouble(Scanner sc) {
        while (true) {
            String line = sc.nextLine();
            if (line == null) line = "";
            line = line.trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.print("Ошибка: ожидается число (double). Повторите ввод: ");
            }
        }
    }

    private static char safeChar(Scanner sc) {
        while (true) {
            String line = sc.nextLine();
            if (line == null) line = "";
            line = line.trim();
            if (line.isEmpty()) {
                System.out.print("Введите символ (не пустая строка): ");
                continue;
            }
            return line.charAt(0);
        }
    }

    private static int safeIntInRange(Scanner sc, int min, int max, String prompt) {
        if (prompt != null && !prompt.isEmpty()) System.out.print(prompt);
        while (true) {
            int v = safeInt(sc);
            if (v < min || v > max) {
                System.out.print("Число должно быть в диапазоне [" + min + ".." + max + "]. Попробуйте снова: ");
            } else {
                return v;
            }
        }
    }

    private static int safeIntPositive(Scanner sc, String prompt) {
        if (prompt != null && !prompt.isEmpty()) System.out.print(prompt);
        while (true) {
            int v = safeInt(sc);
            if (v <= 0) System.out.print("Число должно быть положительным (>0). Повторите ввод: ");
            else return v;
        }
    }

    private static int safeIntNonNegative(Scanner sc, String prompt) {
        if (prompt != null && !prompt.isEmpty()) System.out.print(prompt);
        while (true) {
            int v = safeInt(sc);
            if (v < 0) System.out.print("Число должно быть >= 0. Повторите ввод: ");
            else return v;
        }
    }

    private static int[] readIntArray(Scanner sc, String name) {
        System.out.print("Введите длину массива " + name + " (целое >= 0): ");
        int n = safeIntNonNegative(sc, "");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print(name + "[" + i + "] = ");
            arr[i] = safeInt(sc);
        }
        return arr;
    }

    private static int[] readIntArrayNonEmpty(Scanner sc, String name) {
        System.out.print("Введите длину массива " + name + " (целое > 0): ");
        int n;
        while (true) {
            n = safeInt(sc);
            if (n <= 0) System.out.print("Длина должна быть > 0. Повторите ввод: ");
            else break;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print(name + "[" + i + "] = ");
            arr[i] = safeInt(sc);
        }
        return arr;
    }
}
