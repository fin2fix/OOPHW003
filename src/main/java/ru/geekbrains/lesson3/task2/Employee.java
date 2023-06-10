package ru.geekbrains.lesson3.task2;

public abstract class Employee implements Comparable<Employee> {

    protected String name;
    protected String surname;
    protected int age;
    protected String gender;
    protected double salary; // Ставка заработной платы

    public Employee(String name, String surname, int age, String gender, double salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    // Расчет среднемесячной заработной платы
    public abstract double calculateSalary();

    @Override
    public int compareTo(Employee o) {
        int res = surname.compareTo(o.surname);
        if (res == 0)
            return Double.compare(calculateSalary(), o.calculateSalary());
        else
            return res;
    }

}
