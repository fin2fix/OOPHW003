package ru.geekbrains.lesson3.task2;

import java.util.Comparator;

public class GenderComparator implements Comparator<Employee> {

  @Override
  public int compare(Employee o1, Employee o2) {
    // 1 0 -1
    return o1.gender.compareTo(o2.gender);
    // return o1.calculateSalary() == o2.calculateSalary() ? 0 : (o1.calculateSalary() > o2.calculateSalary() ? 1 : -1);
  }
}
