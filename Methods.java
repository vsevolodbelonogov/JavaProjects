import java.util.Arrays;
import java.math.BigDecimal;

public class Methods {

    // ====== РАЗДЕЛ 1. Методы ======

    // 1. Дробная часть
    // Возвращает дробную часть в смысле x - (int)x, но вычисляет через BigDecimal.valueOf(x),
    // чтобы при обычном десятичном вводе (например "6.78") получить "0.78" без видимых
    // двоичных артефактов при печати.
    public double fraction(double x) {
        BigDecimal bd = BigDecimal.valueOf(x);              // корректная десятичная репрезентация
        BigDecimal intPart = BigDecimal.valueOf((long) x);  // поведение как (int)x (т.е. усечение)
        BigDecimal frac = bd.subtract(intPart).stripTrailingZeros();
        return frac.doubleValue();
    }

    // 2. Букву в число
    // Если символ — '0'..'9' возвращает 0..9, иначе -1.
    public int charToNum(char x) {
        return (x >= '0' && x <= '9') ? (x - '0') : -1;
    }

    // 3. Двузначное число
    public boolean is2Digits(int x) {
        int ax = Math.abs(x);
        return ax >= 10 && ax <= 99;
    }

    // 4. Принадлежность диапазону (границы могут быть в любом порядке)
    public boolean isInRange(int a, int b, int num) {
        int left = Math.min(a, b);
        int right = Math.max(a, b);
        return num >= left && num <= right;
    }

    // 5. Равенство трёх чисел
    public boolean isEqual(int a, int b, int c) {
        return a == b && b == c;
    }

    // ====== РАЗДЕЛ 2. Условия ======

    // 6. Модуль числа
    public int abs(int x) {
        return Math.abs(x);
    }

    // 7. Делится на 3 или 5, но не оба
    public boolean is35(int x) {
        boolean d3 = x % 3 == 0;
        boolean d5 = x % 5 == 0;
        return d3 ^ d5;
    }

    // 8. Максимум из трёх
    public int max3(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }

    // 9. Двойная сумма: если сумма в [10..19] -> 20
    public int sum2(int x, int y) {
        int s = x + y;
        return (s >= 10 && s <= 19) ? 20 : s;
    }

    // 10. День недели (enhanced switch)
    public String day(int x) {
        return switch (x) {
            case 1 -> "понедельник";
            case 2 -> "вторник";
            case 3 -> "среда";
            case 4 -> "четверг";
            case 5 -> "пятница";
            case 6 -> "суббота";
            case 7 -> "воскресенье";
            default -> "это не день недели";
        };
    }

    // ====== РАЗДЕЛ 3. Циклы ======

    // 11. Список чисел подряд (от 0 до x; если x < 0 — от 0 до x по убыванию)
    public String listNums(int x) {
        StringBuilder sb = new StringBuilder();
        if (x >= 0) {
            for (int i = 0; i <= x; i++) sb.append(i).append(" ");
        } else {
            for (int i = 0; i >= x; i--) sb.append(i).append(" ");
        }
        return sb.toString().trim();
    }

    // 12. Чётные числа (от 0 до x или по убыванию если x < 0)
    public String chet(int x) {
        StringBuilder sb = new StringBuilder();
        if (x >= 0) {
            for (int i = 0; i <= x; i++) if (i % 2 == 0) sb.append(i).append(" ");
        } else {
            for (int i = 0; i >= x; i--) if (i % 2 == 0) sb.append(i).append(" ");
        }
        return sb.toString().trim();
    }

    // 13. Длина числа (количество цифр без учета знака)
    public int numLen(long x) {
        return String.valueOf(Math.abs(x)).length();
    }

    // 14. Квадрат из символов '*'
    public void square(int x) {
        if (x <= 0) return;
        String line = "*".repeat(Math.max(0, x));
        for (int i = 0; i < x; i++) System.out.println(line);
    }

    // 15. Правый треугольник, выравненный по правому краю
    public void rightTriangle(int x) {
        if (x <= 0) return;
        for (int i = 1; i <= x; i++) {
            System.out.println(" ".repeat(Math.max(0, x - i)) + "*".repeat(i));
        }
    }

    // ====== РАЗДЕЛ 4. Массивы ======

    // 16. Поиск первого значения (возвращает индекс или -1)
    public int findFirst(int[] arr, int x) {
        if (arr == null) return -1;
        for (int i = 0; i < arr.length; i++) if (arr[i] == x) return i;
        return -1;
    }

    // 17. Поиск элемента с максимальным модулем (возвращаем сам элемент)
    public int maxAbs(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Массив пустой");
        int best = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(best)) best = arr[i];
        }
        return best;
    }

    // 18. Добавление массива ins в массив arr на позицию pos
    public int[] add(int[] arr, int[] ins, int pos) {
        if (arr == null) arr = new int[0];
        if (ins == null) ins = new int[0];
        if (pos < 0) pos = 0;
        if (pos > arr.length) pos = arr.length;

        int[] res = new int[arr.length + ins.length];
        System.arraycopy(arr, 0, res, 0, pos);
        System.arraycopy(ins, 0, res, pos, ins.length);
        System.arraycopy(arr, pos, res, pos + ins.length, arr.length - pos);
        return res;
    }

    // 19. Реверс массива
    public int[] reverseBack(int[] arr) {
        if (arr == null) return null;
        int[] res = Arrays.copyOf(arr, arr.length);
        for (int i = 0, j = res.length - 1; i < j; i++, j--) {
            int tmp = res[i];
            res[i] = res[j];
            res[j] = tmp;
        }
        return res;
    }

    // 20. Все вхождения числа — возвращаем массив индексов (может быть пустым)
    public int[] findAll(int[] arr, int x) {
        if (arr == null) return new int[0];
        int cnt = 0;
        for (int v : arr) if (v == x) cnt++;
        int[] res = new int[cnt];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i] == x) res[idx++] = i;
        return res;
    }
}
