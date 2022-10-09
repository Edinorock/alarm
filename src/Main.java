import java.util.ArrayList;

public class Main
{
    // массив сотрудников
    private static employee[] employees = new employee[10];

    public static void main(String[] args)
    {
        try
        {
            employees[0] = new employee("Комиссаров", "Эльдар", "Проклович", 1000, 1);
            employees[1] = new employee("Сидоров", "Адам", "Мэлсович", 5000, 2);
            employees[2] = new employee("Мухин", "Варлам", "Аркадьевич", 3000, 3);
            employees[3] = new employee("Михайлов", "Карл", "Иринеевич", 2000, 1);

            System.out.println("Количество сотрудников: " + employee.getEmployeeCount() + "\n");

            employees[4] = new employee("Лапин", "Венедикт", "Дмитрьевич", 1500, 1);
            employees[5] = new employee("Попов", "Самуил", "Мартынович", 10000,3);
            employees[6] = new employee("Михайлов", "Лукьян", "Семенович", 700, 2);
            employees[7] = new employee("Дьячков", "Бронислав", "Агафонович", 4500, 2);
            employees[8] = new employee("Туров", "Эльдар", "Викторович", 8300, 3);
            employees[9] = new employee("Доронин", "Демьян", "Мэлсович", 2700, 1);

            System.out.println("Вывод всех сотрудников:");
            printAllEmployees(employees);

            printEmployeeWithMinSalary();

            printEmployeeWithMaxSalary();

            double averageSalary = getAverageSalary();
            System.out.println("Средняя зарплата для всех сотрудников: " + (int)averageSalary);

            System.out.println("\nВывод Ф.И.О. всех сотрудников: ");
            printAllFullNames();

            printSumSalaryOfDepartment(2);

            printAverageSalaryOfDepartment(2);

            setIndexationSalary(10);
            System.out.println("\nПровели индексацию зарплат на 10 процентов!");

            printAllEmployees(employees);

            System.out.println("Вывод сотрудников департамента №2: ");
            printAllEmployeesOfDepartment(2);

            employee[] lessSalaryEmployees = getEmployeesLessSalary(5000);
            employee[] moreSalaryEmployees = getEmployeesMoreSalary(5000);

            System.out.println("\nВывод сотрудников с зарплатой меньше 5000: ");
            printAllEmployees(lessSalaryEmployees);

            System.out.println("\nВывод сотрудников с зарплатой больше 5000: ");
            printAllEmployees(moreSalaryEmployees);
        }
        catch(Exception exception)
        {
            System.out.print(exception.getMessage());
        }
    }

    // вывод данных всех сотрудников
    private static void printAllEmployees(employee[] employees)
    {
        for (int i = 0; i < employees.length; i++)
        {
            if (employees[i] != null)
            {
                System.out.println("Сотрудник №" + i + ":");
                System.out.println("Имя - " + employees[i].getName());
                System.out.println("Отчество - " + employees[i].getPatronymic());
                System.out.println("Фамилия - " + employees[i].getSurname());
                System.out.println("Зарплата - " + (int)employees[i].getSalary());
                System.out.println();
            }
        }
    }

    // вывод данных сотрудника
    private static void printEmployee(employee employee)
    {
        if (employee != null)
        {
            System.out.println("Имя - " + employee.getName());
            System.out.println("Отчество - " + employee.getPatronymic());
            System.out.println("Фамилия - " + employee.getSurname());
            System.out.println("Зарплата - " + (int)employee.getSalary());
            System.out.println();
        }
    }

    // Метод поиска сотрудника с минимальной зарплатой
    private static employee getEmployeeWithMinSalary() {
        employee employeeWithMinSalary = employees[0];

        for (int i = 0; i < employees.length; i++)
        {
            if (employees[i].getSalary() < employeeWithMinSalary.getSalary()
                    && employees[i] != null)
            {
                employeeWithMinSalary = employees[i];
            }
        }

        return employeeWithMinSalary;
    }

    // Метод вывода сотрудника с минимальной зарплатой
    private static void printEmployeeWithMinSalary()
    {
        employee employeeWithMinSalary = getEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной зарплатой:");
        printEmployee(employeeWithMinSalary);
    }

    // Метод поиска сотрудника с максимальной зарплатой
    private static employee GetEmployeeWithMaxSalary() {
        employee employeeWithMaxSalary = employees[0];
        double maxSalary = 0;

        for (int i = 0; i < employees.length; i++)
        {
            if (employees[i].getSalary() > maxSalary
                    && employees[i] != null)
            {
                employeeWithMaxSalary = employees[i];
                maxSalary = employees[i].getSalary();
            }
        }

        return employeeWithMaxSalary;
    }

    // Метод вывода сотрудника с максимальной зарплатой
    private static void printEmployeeWithMaxSalary()
    {
        employee employeeWithMaxSalary = GetEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной зарплатой:");
        printEmployee(employeeWithMaxSalary);
    }

    // Метод рассчета средней зарплаты
    private static double getAverageSalary()
    {
        double sumSalary = 0;
        int countEmployeesOfDepartment = 0;

        for (int i = 0; i < employees.length; i++)
        {
            if (employees[i] != null)
            {
                sumSalary += employees[i].getSalary();
                countEmployeesOfDepartment++;
            }
        }

        return sumSalary / countEmployeesOfDepartment;
    }

    // вывод ФИО всех сотрудников
    private static void printAllFullNames()
    {
        for (int i = 0; i < employees.length; i++)
        {
            if (employees[i] != null)
            {
                System.out.println("Сотрудник №" + i + ":");
                System.out.println("Имя - " + employees[i].getName());
                System.out.println("Отчество - " + employees[i].getPatronymic());
                System.out.println("Фамилия - " + employees[i].getSurname());
                System.out.println();
            }
        }
    }

    // рассчет суммы затрат на зарплату по отделу,
    private static double getSumSalaryOfDepartment(int numberDepartment)
    {
        double sumSalary = 0;

        for (int i = 0; i < employees.length; i++)
        {
            if (employees[i] != null && employees[i].getNumberDepartment() == numberDepartment)
            {
                sumSalary += employees[i].getSalary();
            }
        }

        return sumSalary;
    }

    // вывод суммы затрат на зарплату по отделу
    private static void printSumSalaryOfDepartment(int numberDepartment)
    {
        double sumSalary = getSumSalaryOfDepartment(numberDepartment);
        System.out.println("Отдел № " + numberDepartment + ", сумма затрат на зарплату - " + (int)sumSalary);
    }

    // метод рассчета средней зарплаты по отделу
    private static double getAverageSalaryOfDepartment(int numberDepartment)
    {
        double sumSalary = 0;
        int countEmployeesOfDepartment = 0;

        for (int i = 0; i < employees.length; i++)
        {
            if (employees[i] != null && employees[i].getNumberDepartment() == numberDepartment)
            {
                sumSalary += employees[i].getSalary();
                countEmployeesOfDepartment++;
            }
        }

        return sumSalary / countEmployeesOfDepartment;
    }

    // вывод средней зарплаты по отделу
    private static void printAverageSalaryOfDepartment(int numberDepartment)
    {
        double averageSalary = getAverageSalaryOfDepartment(numberDepartment);
        System.out.println("Отдел № " + numberDepartment + ", средняя зарплата - " + (int)averageSalary);
    }

    // метод индексации зарплаты на %
    private static void setIndexationSalary(int percentIndexation) throws Exception {
        for (int i = 0; i < employees.length; i++)
        {
            if (employees[i] != null)
            {
                double indexationSalary = employees[i].getSalary() + employees[i].getSalary() * percentIndexation / 100;

                employees[i].setSalary(indexationSalary);
            }
        }
    }

    // вывод всех данных всех сотрудников одного отдела, кроме номера отдела
    private static void printAllEmployeesOfDepartment(int numberDepartment)
    {
        for (int i = 0; i < employees.length; i++)
        {
            if (employees[i] != null && employees[i].getNumberDepartment() == numberDepartment)
            {
                System.out.println("Сотрудник №" + i + ":");
                System.out.println("Имя - " + employees[i].getName());
                System.out.println("Отчество - " + employees[i].getPatronymic());
                System.out.println("Фамилия - " + employees[i].getSurname());
                System.out.println("Зарплата - " + (int) employees[i].getSalary());
                System.out.println();
            }
        }
    }

    // поиск сотрудников с зарплатой меньше определенного числа
    private static employee[] getEmployeesLessSalary(double lessSalaryValue)
    {
        ArrayList<employee> employeesWithLessSalary = new ArrayList<employee>();

        for (int i = 0; i < employees.length; i++)
        {
            if (employees[i].getSalary() < lessSalaryValue
                    && employees[i] != null)
            {
                employeesWithLessSalary.add(employees[i]);
            }
        }

        employee[] employees = new employee[employeesWithLessSalary.size()];
        employees = employeesWithLessSalary.toArray(employees);

        return employees;
    }

    // поиск сотрудников с зарплатой больше определенного числа
    private static employee[] getEmployeesMoreSalary(double moreSalaryValue)
    {
        ArrayList<employee> employeesWithMoreSalary = new ArrayList<employee>();

        for (int i = 0; i < employees.length; i++)
        {
            if (employees[i].getSalary() > moreSalaryValue
                    && employees[i] != null)
            {
                employeesWithMoreSalary.add(employees[i]);
            }
        }

        employee[] employees = new employee[employeesWithMoreSalary.size()];
        employees = employeesWithMoreSalary.toArray(employees);

        return employees;
    }
}