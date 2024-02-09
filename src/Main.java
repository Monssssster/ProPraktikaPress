import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        GroupStudents group = new GroupStudents("П-420", "Программисты", 420,
                "Кривовид В.В.", 25, 4.5, "2020-09-01",
                "ГБПОУ РО ТКМП","Никто Никто");

        Student student1 = new Student(19, 4, "Программисты","Валерия", "Попова",
                "женский",5.0,"Учиться");
        Student student2 = new Student( 20, 4, "Программисты","Виктория", "Соломахина",
                "женский",4.5,"В академическом отпуске");
        Student student3 = new Student(19, 4, "Программисты","Полина", "Дядюшкина",
                "женский",5.0,"Учиться");
        Student student4 = new Student(20, 4, "Программисты","Владимир", "Ланчинский",
                "мужской",3.2,"В академическом отпуске");
        Student student5 = new Student(20, 4, "Программисты","Никита", "Чукарин",
                "мужской",2.2,"Отчислен");
        Student student6 = new Student(20, 4, "Программисты","Вероника", "Волкова",
                "женский",4.2,"Учиться");
        // студент7 для проверки, что в массив не добавится копия
        Student student7 = new Student(19, 4, "Программисты","Валерия", "Попова",
                "женский",5.0,"Учиться");
        Student student8 = new Student(19, 4, "Программисты","Сергей", "Топалов",
                "мужской",4.4,"Учиться");

        group.addStudentIfNotPresent(student1);
        group.addStudentIfNotPresent(student2);
        group.addStudentIfNotPresent(student3);
        group.addStudentIfNotPresent(student4);
        group.addStudentIfNotPresent(student5);
        group.addStudentIfNotPresent(student6);
        group.addStudentIfNotPresent(student7);
        group.addStudentIfNotPresent(student8);


        // Выводим информацию о группе и список студентов
        group.setGroupLeader(group);
        System.out.println();

        group.addStudentsToGroup();
        System.out.println();



        group.printGroupInfo(group);
        System.out.println();
        group.printStudents(group);
        System.out.println("\nРазделение студентов по полу:");
        group.divideStudentsByGender(group);
        System.out.println();
        group.printStudentStatus(group);
        System.out.println();
        group.printGroupLeader(group);
        System.out.println();
        group.printStudentStudyInfo(group);
        System.out.println();

//        Student student = getStudentByName(group, "Полина", "Дядюшкина");
//        System.out.println("Такой студент найден в группе!" + " " + student.getName() + " " + student.getSurname());
//        System.out.println();

    }

//    public static Student getStudentByName(GroupStudents group, String name, String surname) {
//        List<Student> students = group.getStudents();
//        for (Student student : students) {
//            if (student.getName().equals(name) && student.getSurname().equals(surname)) {
//                return student;
//            }
//        }
//        throw new IllegalArgumentException("Студент " + name + " " + surname + " не найден в группе " + group.getGroupName());
//    }

}

