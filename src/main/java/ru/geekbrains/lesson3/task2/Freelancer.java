package ru.geekbrains.lesson3.task2;

public class Freelancer extends Employee {

  protected String project;

  public Freelancer(String name, String surname, int age, String gender, double hourSalary, String project) {
    super(name, surname, age, gender, hourSalary * 20 * 8);
    this.project = project;
  }

  @Override
  public double calculateSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return String.format(
        "\n%s %s, пол %s, возраст %d лет; Фрилансер, проект %s; зарплата за месяц (расчет из часовой): %.2f (руб.)",
        surname, name, gender, age, project, calculateSalary());
  }

}
