
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.*;

import java.util.ArrayList; // конкретная реализация интерфейса List. Динамический массив, который автоматически
// увеличивается по мере добавления элементов
import java.util.List; // интерфейс, упорядоченная коллекция объектов, где каждый объект имеет свой индекс
// List является интерфейсом, который определяет функциональность коллекции, а ArrayList - это конкретная реализация этого интерфейса,
// предоставляющая методы для работы с динамическими массивами

public class GroupStudents {
    LocalDate currentDate = LocalDate.now();
    private String groupId; //уникальный идентификатор группы
    private String groupName; //Название группы студентов
    private int groupNumber; //Номер группы студентов
    private List<Student> students; //список студентов в группе
    private String groupTeacher; //руководитель группы
    private int capacity; //максимальная вместимость группы (количество допустимых студентов)
    private double averageMark; //Средний балл группы
    private final String dateFormation; //Дата формирования группы final(чтобы нельзя было паменять никак и нигде)
    private final String locationClasses; //Место проведения занятий final ,запретить сеттер
    private String groupLeader; //Староста группы

    public GroupStudents(String groupId, String groupName, int groupNumber, String groupTeacher, int capacity, double averageMark,
                         String dateFormation, String locationClasses, String groupLeader) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupNumber = groupNumber;
        this.groupTeacher = groupTeacher;
        this.capacity = capacity;
        this.averageMark = averageMark;
        this.dateFormation = dateFormation;
        this.locationClasses = locationClasses;
        this.groupLeader = groupLeader;
        this.students = new ArrayList<>(); //Ключевое слово this используется для указания на текущий объект,
        // и его обычно используют, когда необходимо разрешить неоднозначность между переменными экземпляра и
        // локальными переменными метода или параметрами метода. В данном случае переменная students является
        // переменной экземпляра и потому может быть напрямую обращена к методу инициализации без использования this.
        // Таким образом, присваивание значения переменной students выполняется без указания this, так как это обычная
        // переменная экземпляра, а не локальная переменная метода.

        //Локальная переменная - переменная, объявленная внутри какой-либо функции. Переменная экземпляра
        // - переменные, которые объявляются внутри класса и доступны только для конкретных экземпляров этого класса.

        // students = new ArrayList<>() Инициализирует переменную students типа List<Student> значением нового пустого ArrayList.
        // Так как конструктор класса GroupStudents выполняется при создании объекта этого класса, он устанавливает
        // начальное значение переменной students, которая относится к этому конкретному объекту.

        //В классе GroupStudents мы пишем List<Student> students, потому что мы определяем тип переменной students.
        // Мы используем интерфейс List, который представляет упорядоченный список, и указываем, что этот список
        // будет содержать объекты типа Student. В конструкторе мы инициализируем переменную students,
        // создавая новый экземпляр класса ArrayList, который реализует интерфейс List.

        if (groupId == null || groupId.isEmpty()) {
            throw new IllegalArgumentException("Group ID cannot be null or empty"); }

        if (!groupId.matches("[А-Я]-[0-9]{3}")) { //{3} - должно быть три цифры regex-егулярное выражение, формат
            throw new IllegalArgumentException("Group ID is not in the correct format");}

        if(groupId.equals("0") || groupId.equals("null")) {
            throw new IllegalArgumentException("Group ID cannot be '0' or 'null'"); }
        //сделать проверку с номерами других групп, чтобы не было двух групп П-420


        if (groupName == null || groupName.isEmpty()) {
            throw new IllegalArgumentException("Group name cannot be empty or null"); }

        // Check if groupName contains only valid characters
        if (!groupName.matches("[А-Яа-яa-zA-Z]*")) { //любая последовательность символов, * - может повторяться сколько-то раз
            throw new IllegalArgumentException("Group name contains invalid characters"); }

        if(groupName.equals("0") || groupName.equals("null")) {
            throw new IllegalArgumentException("Group name cannot be '0' or 'null'"); }



        if (groupNumber <= 0) {
            throw new IllegalArgumentException("Group number must be greater than 0"); }

        if (groupNumber > 999) {
            throw new IllegalArgumentException("Group number exceeds the maximum allowed value");}
        //как сделать проверку на соответствие цифрам из groupId?



        if (groupTeacher == null || groupTeacher.isEmpty()) {
            throw new IllegalArgumentException("Group Teacher cannot be empty or null"); }

        if (!groupTeacher.matches("^[А-Я][а-я]* [А-Я]\\.[А-Я]\\.")) { // \. - экранирует точку, чтобы она воспринималась как обычный символ
            throw new IllegalArgumentException("Group Teacher is not in the correct format Surname N.P.");}

        if(groupTeacher.equals("0") || groupTeacher.equals("null")) {
            throw new IllegalArgumentException("Group Teacher cannot be '0' or 'null'"); }



        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than or equal to " + 1); }

        if (capacity > 30) {
            throw new IllegalArgumentException("Capacity exceeds the maximum allowed value"); }



        if (averageMark < 2.0) {
            throw new IllegalArgumentException("Average mark must be greater than or equal to " + 2.0); }

        if (averageMark > 5.0) {
            throw new IllegalArgumentException("Average mark exceeds the maximum allowed value"); }



        if (dateFormation == null || dateFormation.isEmpty()) {
            throw new IllegalArgumentException("Date Formation cannot be empty or null"); }

        //if (!dateFormation.matches("(0?[1-9]|[12][0-9]|3[0-1])/(0?[1-9]|1[0-2])/199[8-9]|20[0-1][0-9]|202[0-4]")) {
            //throw new IllegalArgumentException("Date Formation contains invalid characters");}

        //if (!dateFormation.matches("((199[8-9]|\\d{4})-(0?[1-9]|1[0-2])-(0?[1-9]|[12][0-9]|3[0-1]))")) {
            //throw new IllegalArgumentException("Date Formation contains invalid characters");}

        //сентябрь-октябрь
        //if (!dateFormation.matches("((199[8-9]|\\d{4})-(09)-(0?[1-9]|[12][0-9]|30))")) {
            //if (!dateFormation.matches("((199[8-9]|\\d{4})-(10)-(0?[1-9]|[12][0-9]|3[0-1]))")){
        //throw new IllegalArgumentException("Date Formation contains invalid characters");}}

        // сравнение dateFormation с текущей датой, чтобы дата соответствовала максималной дате месяца
        if (!dateFormation.matches("((199[8-9]|\\d{4})-(0?([14689]|11))-(0?[1-9]|[12][0-9]|30))")) {
        if (!dateFormation.matches("((199[8-9]|\\d{4})-(0?([357]|10|12))-(0?[1-9]|[12][0-9]|3[0-1]))")){
            if (!dateFormation.matches("((199[8-9]|\\d{4})-(02)-(0?[1-9]|[12][0-8]))")){
        throw new IllegalArgumentException("Date Formation contains invalid characters");}}}


        // 0?[1-9] - день может быть двузначным 01-09
        // [12][0-9] - числа от 10 до 29
        // 3[01] - числа 30 и 31
        // / - разделитель между днем, месяцем и годом
        // 0?[1-9] - месяц может быть двузначным 01-09
        // 1[0-2] - числа от 10 до 12
        // \\d - любая цифра {4} - должно быть ровно четыре цифры
        // 199[8-9] - 1998,1999  20[0-1][0-9] - 2000 - 2019  202[0-4] - 2020 - 2024


        // год-месяц-дата
        // сравнение dateFormation с текущим годом
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate = LocalDate.parse(dateFormation,formatter);
        if(parsedDate.isAfter(currentDate)){
            throw new IllegalArgumentException("Date Formation cannot be greater than current date");}



        if(dateFormation.equals("0") || dateFormation.equals("null")) {
            throw new IllegalArgumentException("Date Formation cannot be '0' or 'null'"); }



        if (locationClasses == null || locationClasses.isEmpty()) {
            throw new IllegalArgumentException("Location Classes cannot be empty or null"); }

        if (!locationClasses.matches("[А-Яа-яa-zA-Z ]*")) {
            throw new IllegalArgumentException("Location Classes contains invalid characters"); }

        if(locationClasses.equals("0") || locationClasses.equals("null")) {
            throw new IllegalArgumentException("Location Classes cannot be '0' or 'null'"); }



        if (groupLeader == null || groupLeader.isEmpty()) {
            throw new IllegalArgumentException("Group Leader cannot be empty or null"); }

        if (!groupLeader.matches("^([А-Я][а-я]*) ([А-Я][а-я]*)")) {
            throw new IllegalArgumentException("Group Leader is not in the correct format Name Surname"); }

        if(groupLeader.equals("0") || groupLeader.equals("null")) {
            throw new IllegalArgumentException("Group Leader cannot be '0' or 'null'"); }


    }



    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    //public List<Student> getStudents() {
        //return students;
    //}

    //public void setStudents(List<Student> students) {
        //this.students = students;
    //} // заменить на прямое без getter

    public String getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(String GroupLeader) {
        this.groupLeader = GroupLeader;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public String getDateFormation() {
        return dateFormation;
    }

    public String getLocationClasses() {
        return locationClasses;
    }

    public String getGroupTeacher() {
        return groupTeacher;
    }

    public void setGroupTeacher(String groupTeacher) {
        this.groupTeacher = groupTeacher;
    }



    public void addStudentsToGroup() {


        // Вывод информации о студентах
        for (Student student : students) {
            System.out.println(student);
        }

        // Запрос на удаление списка студентов
//        Scanner scanner = new Scanner(System.in); // Создание объекта Scanner для считывания ввода пользователя с консоли
//        System.out.print("Вы хотите удалить student list? (Y/N): "); // Вывод на консоль вопроса о удалении списка студентов
//        String response = scanner.nextLine(); // Считывание ответа пользователя
//
//        if (response.equalsIgnoreCase("Y")) { // Проверка, равен ли ответ пользователя "Y" (без учета регистра)
//            System.out.print("Введите пароль, чтобы удалить student list: "); // Вывод на консоль запроса пароля для удаления списка студентов
//            String enteredPassword = scanner.nextLine(); // Считывание введенного пароля
//
//            String password = "password123"; // Установка правильного пароля
//            if (enteredPassword.equals(password)) { // Проверка, совпадает ли введенный пароль с правильным паролем
//                students.clear(); // Удаление списка студентов
//                System.out.println("Student list удален."); // Вывод на консоль сообщения о успешном удалении списка студентов
//            } else {
//                System.out.println("Неправильный пароль. Student list не будет удален."); // Вывод на консоль сообщения о неправильном пароле
//            }
//        } else {
//            System.out.println("Student list не будет удален."); // Вывод на консоль сообщения о том, что список студентов не будет удален
//        }
//        scanner.close(); // Закрытие объекта Scanner




        Scanner scanner = new Scanner(System.in); // Создание объекта Scanner для считывания ввода пользователя с консоли
        System.out.print("Вы хотите удалить student list? (Y/N): "); // Вывод на консоль вопроса о удалении списка студентов
        String response = scanner.nextLine(); // Считывание ответа пользователя

        if (response.equalsIgnoreCase("Y")) { // Проверка, равен ли ответ пользователя "Y" (без учета регистра)
            System.out.print("Введите пароль, чтобы удалить student list: "); // Вывод на консоль запроса пароля для удаления списка студентов
            String enteredPassword = scanner.nextLine(); // Считывание введенного пароля

            String password = "password123"; // Установка правильного пароля
            if (enteredPassword.equals(password)) { // Проверка, совпадает ли введенный пароль с правильным паролем
                students.clear(); // Удаление списка студентов
                System.out.println("Student list удален."); // Вывод на консоль сообщения о успешном удалении списка студентов
            } else {
                System.out.println("Неправильный пароль. Student list не будет удален."); // Вывод на консоль сообщения о неправильном пароле
            }
        } else {
            System.out.println("Student list не будет удален."); // Вывод на консоль сообщения о том, что список студентов не будет удален
        }

        System.out.print("Хотите добавить нового студента? (Y/N): "); // Вывод на консоль вопроса о добавлении нового студента
        response = scanner.nextLine(); // Считывание ответа пользователя

        if (response.equalsIgnoreCase("Y")) { // Проверка, равен ли ответ пользователя "Y" (без учета регистра)
            System.out.print("Введите возраст студента: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Введите курс студента: ");
            int course = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Введите группу студента: ");
            String group = scanner.nextLine();

            System.out.print("Введите имя студента: ");
            String name = scanner.nextLine();

            System.out.print("Введите фамилию студента: ");
            String surname = scanner.nextLine();

            System.out.print("Введите пол студента: ");
            String sex = scanner.nextLine();

            System.out.print("Введите среднюю оценку студента: ");
            double markSr = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Введите статус студента: ");
            String status = scanner.nextLine();

            // Создание объекта студента на основе введенных данных
            Student newStudent = new Student(age, course, group, name, surname, sex, markSr, status);

            // Проверка наличия студента в списке
            boolean studentExists = addStudentIfNotPresent(newStudent);
            if (studentExists) {
                System.out.println("Ошибка: студент уже существует.");
            } else {
                System.out.println("Студент " + newStudent.getName() + " " + newStudent.getSurname() + " добавлен в список.");
            }
        }


        scanner.close(); // Закрытие объекта Scanner


    }



    public boolean addStudentIfNotPresent(Student student) {
        for (Student existingStudent : students) {
            if (existingStudent.getAge() == student.getAge() && existingStudent.getCourse() == student.getCourse() &&
                    existingStudent.getGroup().equals(student.getGroup()) && existingStudent.getName().equals(student.getName()) &&
                    existingStudent.getSurname().equals(student.getSurname()) && existingStudent.getSex().equals(student.getSex())
                    && existingStudent.getStatus().equals(student.getStatus())) {
                return true; // Возвращаем true, если студент с такими атрибутами уже существует
            }
        }
        students.add(student); // Если студент не существует, добавляем его в список группы
        return false; // Возвращаем false, если студент успешно добавлен
    }






//    public void addStudentIfNotPresent(Student student) {
//        boolean studentExists = false; // Устанавливаем флаг для отслеживания наличия студента
//        for (Student existingStudent : students) { // Проходим по каждому студенту в списке группы
//            if (existingStudent.getAge() == student.getAge() && existingStudent.getCourse() == student.getCourse() &&
//                    existingStudent.getGroup().equals(student.getGroup()) && existingStudent.getName().equals(student.getName()) &&
//                    existingStudent.getSurname().equals(student.getSurname()) && existingStudent.getSex().equals(student.getSex())
//                    && existingStudent.getStatus().equals(student.getStatus())) {
//                // Проверяем, совпадают ли все атрибуты студента с уже существующими студентами
//                studentExists = true; // Если студент с такими атрибутами уже существует, устанавливаем флаг в true и выходим из цикла
//                break;
//            }
//        }
//
//        if (!studentExists) { // Если студент не существует, добавляем его в список группы
//            students.add(student);
//        } else { // Если студент уже существует, выводим сообщение об этом
//            System.out.println("Студент " + student.getName() + " " + student.getSurname() + " уже присутствует в списке группы.");
//        }
//    }

    public void printGroupInfo(GroupStudents group) {
        System.out.println("Информация о группе " + group.getGroupName() + ":");
        System.out.println("ID группы: " + group.getGroupId());
        System.out.println("Номер группы: " + group.getGroupNumber());
        System.out.println("Руководитель группы: " + group.getGroupTeacher());
        System.out.println("Максимальная вместимость группы: " + group.getCapacity());
        System.out.println("Средний балл группы: " + group.getAverageMark());
        System.out.println("Дата формирования группы: " + group.getDateFormation());
        System.out.println("Место проведения занятий: " + group.getLocationClasses());
    }

    public void printStudents(GroupStudents group) {
        List<Student> students = group.students; //объявление переменной students типа List(список) с элементами
        // типа Student
        System.out.println("Список студентов группы " + group.getGroupName() + ":");
        for (Student student : students) {
            System.out.println("Имя: " + student.getName() +", Фамилия: " + student.getSurname() +
                    ", Возраст: " + student.getAge() + ", Пол: " + student.getSex() + ", Средний балл: " + student.getMarkSr());
        }
    }

    public void printStudentStatus(GroupStudents group) {
        List<Student> students = group.students;
        System.out.println("Статус студентов группы " + group.getGroupName() + ":");
        for (Student student : students) { //student ссылается на каждый объект типа Student в списке students
            // и в данном случае цикл будет вызываться для каждого студента, чтобы проверить его средний балл
            if (student.getMarkSr() >= 4.5) {
                System.out.println(student.getName() + " " + student.getSurname() + " - отличник");
            } else if (student.getMarkSr() >= 3.5) {
                System.out.println(student.getName() + " " + student.getSurname() + " - хорошист");
            } else if (student.getMarkSr() >= 2.5) {
                System.out.println(student.getName() + " " + student.getSurname() + " - удовлетворительно");
            } else {
                System.out.println(student.getName() + " " + student.getSurname() + " - в списке на отчисление");
            }
        }
    }

    public void printStudentStudyInfo(GroupStudents group) {
        List<Student> students = group.students;
        System.out.println("Учебный статус студентов группы " + group.getGroupName() + ":");
        for (Student student : students) {
            if (Objects.equals(student.getStatus(), "Учиться")) {
                System.out.println(student.getName() + " " + student.getSurname() + " - учиться");
            } else if (Objects.equals(student.getStatus(), "Отчислен")) {
                System.out.println(student.getName() + " " + student.getSurname() + " - отчислен");
            }
        }
    }

//    public void printGroupLeader(GroupStudents group) {
//        if (students.isEmpty()) {
//            System.out.println("Староста группы " + group.getGroupName() + ": ");
//        } else {
//            if (group.getGroupLeader() != null && !students.contains(group.getGroupLeader())) {
//                group.setGroupLeader(null);
//            }
//            if (group.getGroupLeader() == null) {
//                System.out.println("Староста группы " + group.getGroupName() + ": Не установлен");
//            } else {
//                System.out.println("Староста группы " + group.getGroupName() + ": " + group.getGroupLeader());
//            }
//        }
//    }


    public void printGroupLeader(GroupStudents group) {
        if (students.isEmpty()) {
            System.out.println("Староста группы " + group.getGroupName() + ": ");
        } else {
            System.out.println("Староста группы " + group.getGroupName() + ": " + group.getGroupLeader());
        }
    }

//    public void removeStudent(Student student) {
//        students.remove(student);
//        if (student.equals(groupLeader)) {
//            System.out.println("Вы удаляете старосту группы. Хотите продолжить? (Y/N)");
//            Scanner scanner = new Scanner(System.in);
//            String answer = scanner.nextLine();
//            if (answer.equals("Y")) {
//                groupLeader = null;
//                System.out.println("Староста группы " + getGroupName() + " удален."); }}
//    }

    public void setGroupLeader(GroupStudents group) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Хотите установить старосту группы " + group.getGroupName() + "? (Y/N): ");
        String answer = scanner.nextLine().trim().toUpperCase();
        if (answer.equals("Y")) {
            System.out.print("Введите имя студента: ");
            String studentName = scanner.nextLine().trim();
            System.out.print("Введите фамилию студента: ");
            String studentSurname = scanner.nextLine().trim();
            boolean found = false;
            for (Student student : students) {
                if (student.getName().equals(studentName) && student.getSurname().equals(studentSurname)) {
                    groupLeader = String.valueOf(student);
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println("Староста группы " + group.getGroupName() + " успешно установлен.");
            } else {
                System.out.println("Студент \"" + studentName + "\" не найден в группе " + group.getGroupName() + ". Попробуйте еще раз.");
                setGroupLeader(group);
            }
        } else if (answer.equals("N")) {
            double maxAverageGrade = 0;
            Student newGroupLeader = null;
            for (Student student : students) {
                if (student.getMarkSr() > maxAverageGrade) {
                    maxAverageGrade = student.getMarkSr();
                    newGroupLeader = student;
                }
            }

            

            groupLeader = String.valueOf(newGroupLeader);
            System.out.println("Староста группы " + group.getGroupName() + " автоматически установлен.");
        } else {
            System.out.println("Некорректный ответ. Попробуйте еще раз.");
            setGroupLeader(group);
        }
    }


//    public void addStudentIfNotPresent(Student student) {
//        boolean studentExists = false; // Устанавливаем флаг для отслеживания наличия студента
//        for (Student existingStudent : students) { // Проходим по каждому студенту в списке группы
//            if (existingStudent.getId() == student.getId()) { // Проверяем, совпадает ли идентификатор студента с уже существующими студентами
//                studentExists = true; // Если студент с таким идентификатором уже существует, устанавливаем флаг в true и выходим из цикла
//                break;
//            }
//        }
//
//        if (!studentExists) { // Если студент не существует, добавляем его в список группы
//            students.add(student);
//        } else { // Если студент уже существует, выводим сообщение о присутствии в списке группы
//            System.out.println("Студент " +student.getName() + " " + student.getSurname() + " уже присутствует в списке группы.");
//        }}



    //    public boolean checkStudentExists(Student student) {
//        for(Student s : getStudents()) {
//            if(s.equals(student)) {
//                return false;
//            }
//        }
//        return true;
//    }

    public void divideStudentsByGender(GroupStudents group) {
        //filter.fromTo()-фильтрация данных
        List<Student> students = group.students;

        List<Student> femaleStudents = new ArrayList<>();
        List<Student> maleStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.getSex().equals("женский")) {
                femaleStudents.add(student);
            } else if (student.getSex().equals("мужской")) {
                maleStudents.add(student);
            }
        }

        System.out.println("Женский пол:");
        for (Student femaleStudent : femaleStudents) {
            System.out.println("Имя: " + femaleStudent.getName() + ", Фамилия: " + femaleStudent.getSurname());
        }

        System.out.println("\nМужской пол:");
        for (Student maleStudent : maleStudents) {
            System.out.println("Имя: " + maleStudent.getName() + ", Фамилия: " + maleStudent.getSurname());
        }


    }

}