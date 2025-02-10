import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class studentM implements Serializable {
    private String name;
    private int age;
    private int id;

    public studentM(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}

class StudentM {
    private List<Student> students;
    private String filePath;

    public StudentM(String filePath) {
        this.filePath = filePath;
        students = new ArrayList<>();
        readFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void writeToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(students);
            System.out.println("Список студентів успішно записано у файл.");
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }
    }

    public void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка при читанні з файлу або файл не знайдено.");
        }
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class studentM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentM studentManager = new StudentM("students_list.dat");

        // Додавання нових студентів
        System.out.println("Введіть ім'я студента:");
        String name = scanner.nextLine();
        System.out.println("Введіть вік студента:");
        int age = scanner.nextInt();
        System.out.println("Введіть ID студента:");
        int id = scanner.nextInt();
        Student newStudent = new Student(name, age, id);

        studentManager.addStudent(newStudent);

        // Запис студентів у файл
        studentManager.writeToFile();

        // Виведення студентів
        System.out.println("\nСписок студентів:");
        studentManager.displayStudents();
    }
}
