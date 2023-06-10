package ru.geekbrains.lesson3.task2;

public class Worker extends Employee {

    public Worker(String name, String surname, int age, String gender, double salary) {
        super(name, surname, age, gender, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("\n%s %s, пол %s, возраст %d лет; Рабочий; зарплата (фикс): %.2f (руб.)",
                surname, name, gender, age, calculateSalary());
    }
}
