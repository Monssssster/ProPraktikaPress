import java.util.List;
import java.util.ArrayList;

public class Student {

//    private int Id;
    private int age;
    private int course;
    private String group;
    private String name;
    private String surname;
    private double markSr;
    private String sex;
    private String status;


    private static int count = 0;

    public double getMarkSr() {
        return markSr;
    }

    public void setMarkSr(double markSr) {
        this.markSr = markSr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    Student(int age, int course, String group, String name, String surname, String sex, double markSr, String status) {
//        this.Id = Id;
        this.age = age;
        this.course = course;
        this.group = group;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.markSr = markSr;
        this.status = status;
        count++;
    }

    @Override
    public String toString() {
        return super.toString() + (" Возраст: " + age + " Курс: " + course + " Имя: " + name + " Фамилия: " + surname);
    }

    public void Hello(){
        System.out.println("Привет,меня зовут! " + name);
    }

    public static void printCount(){
        System.out.println("Кол-во студентов: " + count);
    }

    public int getAge() {  //геттеры
        return age;
    }

    public int getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setCourse(int course){ //сеттеры можно сделать нажав ПКМ по названию - Generate - Getter & Setter
        if(course>=1 && course<=4) {
            this.course = course;
        }
        else {
            System.out.println("Ошибка! Номер курса должен быть в диапозоне от 1 до 4!");
        }
    }

    public void setAge(int age) {
        if(age>=15 && age<=35) {
            this.age = age;
        }
        else {
            System.out.println("Ошибка!");
        }

    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }


//    public int getId() {
//        return Id;
//    }
//
//    public void setId(int id) {
//        Id = id;
//    }



}
