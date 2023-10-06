package homework2.task2;

// Задача 2. Напишите программу, которая запрашивает у пользователя
// два числа и выполняет их деление. Если второе число равно нулю, программа должна выбрасывать
// исключение DivisionByZeroException с сообщением "Деление на ноль недопустимо".
// В противном случае, программа должна выводить результат деления.
// Обратите внимание, что в обоих задачах используются собственные исключения,
// которые наследуются от класса Exception.
// Это позволяет нам определить специфическую причину ошибки
// и передать информацию об ошибке для последующей обработки.

import java.util.InputMismatchException;
import java.util.Scanner;
public class MainTask2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Введите первое целое число: ");
            int a = sc.nextInt();
            System.out.print("Введите второе целое число: ");
            int b = sc.nextInt();
            divide(a, b);
        } catch (InputMismatchException e1) {
            System.out.println("Ошибка: некорректный ввод. Необходимо ввести целые числа.");
        } catch (DivisionByZeroException e2) {
            System.out.println(e2.getMessage());
        }
        sc.nextLine();
        System.out.println();
    }

    public static void divide(int a, int b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException("Деление на ноль недопустимо.");
        } else {
            System.out.println(a / b);
        }
    }

}
