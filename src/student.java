import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Student implements Serializable {
    private String name;
    private int age;
    private int id;

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}

public class student {
    public static void main(String[] args) {
        // Створення об'єктів Student
        Student student1 = new Student("Іван", 20, 101);
        Student student2 = new Student("Марія", 22, 102);

        // Запис об'єктів у файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(student1);
            oos.writeObject(student2);
            System.out.println("Об'єкти записано у файл.");
        } catch (IOException e) {
            System.out.println("Помилка при записі: " + e.getMessage());
        }

        // Читання об'єктів з файлу
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            Student readStudent1 = (Student) ois.readObject();
            Student readStudent2 = (Student) ois.readObject();
            System.out.println("Прочитані об'єкти з файлу:");
            System.out.println(readStudent1);
            System.out.println(readStudent2);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка при читанні: " + e.getMessage());
        }
    }
}
