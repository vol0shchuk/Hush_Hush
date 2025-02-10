import java.io.File;

public class delete {
    public static void main(String[] args) {
        File file = new File("file_to_delete.txt");

        if (file.delete()) {
            System.out.println("Файл успішно видалено.");
        } else {
            System.out.println("Не вдалося видалити файл.");
        }
    }
}
