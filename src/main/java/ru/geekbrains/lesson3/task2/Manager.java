package ru.geekbrains.lesson3.task2;

public class Manager extends Employee {

  protected String department;

  public Manager(String name, String surname, int age, String gender, double salary, String department) {
    super(name, surname, age, gender, salary);
    this.department = department;
  }

  @Override
  public double calculateSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return String.format("\n%s %s, пол %s, возраст %d лет; Менеджер, отдел %s; зарплата (фикс): %.2f (руб.)",
        surname, name, gender, age, department, calculateSalary());
  }
}
