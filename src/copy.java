import java.io.*;
import java.nio.file.*;

public class copy {
    public static void main(String[] args) {
        try {
            Path sourcePath = Paths.get("source.txt");
            Path destinationPath = Paths.get("destination.txt");

            // Копіюємо вміст файлу
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл успішно скопійовано.");
        } catch (IOException e) {
            System.out.println("Помилка при копіюванні файлу: " + e.getMessage());
        }
    }
}
