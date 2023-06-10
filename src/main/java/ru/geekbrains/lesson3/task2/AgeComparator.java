package ru.geekbrains.lesson3.task2;

import java.util.Comparator;

public class AgeComparator implements Comparator<Employee> {

  @Override
  public int compare(Employee o1, Employee o2) {
    // 1 0 -1
    return Integer.compare(o1.age, o2.age);
    // return o1.calculateSalary() == o2.calculateSalary() ? 0 : (o1.calculateSalary() > o2.calculateSalary() ? 1 : -1);
  }

}
