import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Отримуємо текст від користувача
        System.out.println("Введіть текст для запису в файл:");
        String text = scanner.nextLine();

        // Створюємо файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_input.txt"))) {
            writer.write(text);
            System.out.println("Текст успішно записано у файл 'user_input.txt'");
        } catch (IOException e) {
            System.out.println("Помилка при записі в файл: " + e.getMessage());
        }
    }
}
