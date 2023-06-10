package ru.geekbrains.lesson3.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Program {

    static int getNumber() {
        boolean flag = false;
        int result = 0;

        while (!flag) {
            System.out.println("Введите число:  ");
            try {
                result = Integer.parseInt(scan.nextLine());
                flag = true;
            } catch (Exception ex) {
                System.out.println("Введено не число. Попробуйте еще раз!  ");
            }
        }
        return result;
    }

    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    static List<Employee> generateEmployee() {
        String[] namesMale = new String[] { "Александр", "Алексей", "Альберт", "Анатолий", "Андрей", "Антон", "Аркадий",
                "Арсений", "Артём", "Артур", "Борис", "Вадим", "Валентин", "Валерий", "Василий", "Виктор", "Виталий",
                "Владимир", "Вячеслав", "Геннадий", "Георгий", "Глеб", "Григорий", "Даниил", "Денис", "Дмитрий",
                "Евгений", "Егор", "Иван", "Игорь", "Илья", "Кирилл", "Константин", "Лев", "Леонид", "Максим", "Михаил",
                "Никита", "Олег", "Павел", "Пётр", "Родион", "Роман", "Ростислав", "Руслан", "Семён", "Сергей",
                "Станислав", "Степан", "Тарас", "Тимофей", "Тимур", "Фёдор", "Эдуард" };
        String[] namesFemale = new String[] { "Александра", "Алина", "Алиса", "Алла", "Анастасия", "Анжела", "Анна",
                "Анфиса", "Валентина", "Валерия", "Варвара", "Вера", "Вероника", "Виктория", "Галина", "Дарья",
                "Евгения", "Екатерина", "Елена", "Елизавета", "Жанна", "Зинаида", "Зоя", "Инна", "Ирина", "Карина",
                "Ксения", "Лариса", "Лидия", "Любовь", "Людмила", "Маргарита", "Марина", "Мария", "Милана", "Мирослава",
                "Надежда", "Наталья", "Нина", "Оксана", "Ольга", "Полина", "Прасковья", "Раиса", "Регина", "Светлана",
                "Снежана", "София", "Тамара", "Татьяна", "Ульяна", "Юлия", "Яна", "Ярослава" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов",
                "Горбунов", "Лыткин", "Соколов", "Иванов", "Петров", "Сидоров", "Кузнецов", "Шахтеров", "Шереметьев",
                "Иноземцев" };
        String[] projects = new String[] { "Развитие сайта", "Новый бух. учет", "Инновац. продажи",
                "Разумные расходы" };
        String[] departments = new String[] { "Отдел закупок", "Бухгалтерия", "Отдел продаж", "Склад", "IT",
                "Финансовый отдел" };

        System.out.println("\nУкажите желаемое количество работников в вашей компании   ");
        int number = getNumber();

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            int genderNum = rand.nextInt(2);
            String gender;
            String name;
            String surname;

            if (genderNum == 1) {
                gender = "муж";
                name = namesMale[rand.nextInt(namesMale.length)];
                surname = surnames[rand.nextInt(surnames.length)];
            } else {
                gender = "жен";
                name = namesFemale[rand.nextInt(namesFemale.length)];
                surname = surnames[rand.nextInt(surnames.length)] + 'а';
            }

            int age = rand.nextInt(19, 66);
            int salary;

            int val = rand.nextInt(3);
            switch (val) {
                case 0:
                    salary = rand.nextInt(20000, 80000);
                    employees.add(new Worker(name, surname, age, gender, salary));
                    break;
                case 1:
                    employees.add(new Freelancer(name, surname, age, gender, rand.nextInt(200, 1500),
                            projects[rand.nextInt(projects.length)]));
                    break;
                case 2:
                    salary = rand.nextInt(120000, 200000);
                    employees.add(new Manager(name, surname, age, gender, salary,
                            departments[rand.nextInt(departments.length)]));
                    break;
            }
        }
        return employees;
    }

    static void Sorting(List<Employee> input) {
        int num = 0;
        System.out.println(
                "Выберите, как вы хотите отсортировать данные:\n 1 - по фамилии \n 2 - по полу \n 3 - по возрасту \n 4 - по зарплате\n");
        num = getNumber();

        switch (num) {
            case 1:
                input.sort(new SurnameComparator()); // по фамилии
                break;
            case 2:
                input.sort(new GenderComparator()); // по полу
                break;
            case 3:
                input.sort(new AgeComparator()); // по возрасту
                break;
            case 4:
                input.sort(new SalaryComparator()); // по зарплате
                break;
            default:
                System.out.println("\n Вы ввели неправильное число. Сортировка не произведена!  \n");
                break;
        }
    }

    public static void main(String[] args) {

        List<Employee> company = generateEmployee();
        System.out.println(company);
        System.out.println("\nОтсортируем работников:  \n");
        Sorting(company);
        // Collections.sort(company);
        System.out.println(company);
    }
}
