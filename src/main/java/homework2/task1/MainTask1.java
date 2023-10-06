package homework2.task1;

// Задача 1. Напишите программу, которая запрашивает у пользователя число
// и проверяет, является ли оно положительным.
// Если число отрицательное или равно нулю,
// программа должна выбрасывать исключение InvalidNumberException
// с сообщением "Некорректное число".
// В противном случае, программа должна выводить сообщение "Число корректно".

import java.util.Scanner;
import java.util.InputMismatchException;

public class MainTask1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Введите целое число: ");
            int inputNumber = sc.nextInt();
            checkNumber(inputNumber);
        } catch (InvalidNumberException ex) {
            System.out.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("Ошибка: Некорректный ввод. Необходимо ввести целое число.");
        }
        sc.nextLine();
        System.out.println();
    }
    public static void checkNumber(int inputNumber) throws InvalidNumberException {
        if (inputNumber <= 0) {
            throw new InvalidNumberException("Некорректное число.");
            } else {
                System.out.println("Число корректно.");
            }
        }

}