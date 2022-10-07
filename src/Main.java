import java.util.ArrayList;

public class Main {
    // массив сотрудников
    private static Employee[] _employees = new Employee[10];

    public static void main(String[] args) {
        try {
            _employees[0] = new Employee("Комиссаров", "Эльдар", "Проклович", 1000, 1);
            _employees[1] = new Employee("Сидоров", "Адам", "Мэлсович", 5000, 2);
            _employees[2] = new Employee("Мухин", "Варлам", "Аркадьевич", 3000, 3);
            _employees[3] = new Employee("Михайлов", "Карл", "Иринеевич", 2000, 1);
            _employees[4] = new Employee("Лапин", "Венедикт", "Дмитрьевич", 1500, 1);
            _employees[5] = new Employee("Попов", "Самуил", "Мартынович", 10000, 3);
            _employees[6] = new Employee("Михайлов", "Лукьян", "Семенович", 700, 2);
            _employees[7] = new Employee("Дьячков", "Бронислав", "Агафонович", 4500, 2);
            _employees[8] = new Employee("Туров", "Эльдар", "Викторович", 8300, 3);
            _employees[9] = new Employee("Доронин", "Демьян", "Мэлсович", 2700, 1);

            System.out.println("Вывод всех сотрудников:");
            PrintAllEmployees(_employees);

            PrintEmployeeWithMinSalary();

            PrintEmployeeWithMaxSalary();

            double averageSalary = GetAverageSalary();
            System.out.println("Средняя зарплата для всех сотрудников: " + (int) averageSalary);

            System.out.println("\nВывод Ф.И.О. всех сотрудников: ");
            PrintAllFullNames();

            PrintSumSalaryOfDepartment(2);

            PrintAverageSalaryOfDepartment(2);

            SetIndexationSalary(10);
            System.out.println("\nПровели индексацию зарплат на 10 процентов!");

            PrintAllEmployees(_employees);

            System.out.println("Вывод сотрудников департамента №2: ");
            PrintAllEmployeesOfDepartment(2);

            Employee[] lessSalaryEmployees = GetEmployeesLessSalary(5000);
            Employee[] moreSalaryEmployees = GetEmployeesMoreSalary(5000);

            System.out.println("\nВывод сотрудников с зарплатой меньше 5000: ");
            PrintAllEmployees(lessSalaryEmployees);

            System.out.println("\nВывод сотрудников с зарплатой больше 5000: ");
            PrintAllEmployees(moreSalaryEmployees);
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
        }
    }

    // вывод данных всех сотрудников
    public static void PrintAllEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println("Сотрудник №" + i + ":");
                System.out.println("Имя - " + employees[i].get_name());
                System.out.println("Отчество - " + employees[i].get_patronymic());
                System.out.println("Фамилия - " + employees[i].get_surname());
                System.out.println("Зарплата - " + (int) employees[i].get_salary());
                System.out.println();
            }
        }
    }

    // вывод данных сотрудника
    public static void PrintEmployee(Employee employee) {
        if (employee != null) {
            System.out.println("Имя - " + employee.get_name());
            System.out.println("Отчество - " + employee.get_patronymic());
            System.out.println("Фамилия - " + employee.get_surname());
            System.out.println("Зарплата - " + (int) employee.get_salary());
            System.out.println();
        }
    }

    // Метод поиска сотрудника с минимальной зарплатой
    public static Employee GetEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = _employees[0];

        for (int i = 0; i < _employees.length; i++) {
            if (_employees[i].get_salary() < employeeWithMinSalary.get_salary()
                    && _employees[i] != null) {
                employeeWithMinSalary = _employees[i];
            }
        }

        return employeeWithMinSalary;
    }

    // Метод вывода сотрудника с минимальной зарплатой
    public static void PrintEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = GetEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной зарплатой:");
        PrintEmployee(employeeWithMinSalary);
    }

    // Метод поиска сотрудника с максимальной зарплатой
    public static Employee GetEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = _employees[0];
        double maxSalary = 0;

        for (int i = 0; i < _employees.length; i++) {
            if (_employees[i].get_salary() > maxSalary
                    && _employees[i] != null) {
                employeeWithMaxSalary = _employees[i];
                maxSalary = _employees[i].get_salary();
            }
        }

        return employeeWithMaxSalary;
    }

    // Метод вывода сотрудника с максимальной зарплатой
    public static void PrintEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = GetEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной зарплатой:");
        PrintEmployee(employeeWithMaxSalary);
    }

    // Метод рассчета средней зарплаты
    public static double GetAverageSalary() {
        double sumSalary = 0;

        for (int i = 0; i < _employees.length; i++) {
            if (_employees[i] != null) {
                sumSalary += _employees[i].get_salary();
            }
        }

        return sumSalary / _employees.length;
    }

    // вывод ФИО всех сотрудников
    public static void PrintAllFullNames() {
        for (int i = 0; i < _employees.length; i++) {
            if (_employees[i] != null) {
                System.out.println("Сотрудник №" + i + ":");
                System.out.println("Имя - " + _employees[i].get_name());
                System.out.println("Отчество - " + _employees[i].get_patronymic());
                System.out.println("Фамилия - " + _employees[i].get_surname());
                System.out.println();
            }
        }
    }

    // рассчет суммы затрат на зарплату по отделу,
    public static double GetSumSalaryOfDepartment(int numberDepartment) {
        double sumSalary = 0;

        for (int i = 0; i < _employees.length; i++) {
            if (_employees[i] != null && _employees[i].get_numberDepartment() == numberDepartment) {
                sumSalary += _employees[i].get_salary();
            }
        }

        return sumSalary;
    }

    // вывод суммы затрат на зарплату по отделу
    public static void PrintSumSalaryOfDepartment(int numberDepartment) {
        double sumSalary = GetSumSalaryOfDepartment(numberDepartment);
        System.out.println("Отдел № " + numberDepartment + ", сумма затрат на зарплату - " + (int) sumSalary);
    }

    // метод рассчета средней зарплаты по отделу
    public static double GetAverageSalaryOfDepartment(int numberDepartment) {
        double sumSalary = 0;
        int countEmployeesOfDepartment = 0;

        for (int i = 0; i < _employees.length; i++) {
            if (_employees[i] != null && _employees[i].get_numberDepartment() == numberDepartment) {
                sumSalary += _employees[i].get_salary();
                countEmployeesOfDepartment++;
            }
        }

        return sumSalary / countEmployeesOfDepartment;
    }

    // вывод средней зарплаты по отделу
    public static void PrintAverageSalaryOfDepartment(int numberDepartment) {
        double averageSalary = GetAverageSalaryOfDepartment(numberDepartment);
        System.out.println("Отдел № " + numberDepartment + ", средняя зарплата - " + (int) averageSalary);
    }

    // метод индексации зарплаты на %
    public static void SetIndexationSalary(int percentIndexation) throws Exception {
        for (int i = 0; i < _employees.length; i++) {
            if (_employees[i] != null) {
                double indexationSalary = _employees[i].get_salary() + _employees[i].get_salary() * percentIndexation / 100;

                _employees[i].set_salary(indexationSalary);
            }
        }
    }

    // вывод всех данных всех сотрудников одного отдела, кроме номера отдела
    public static void PrintAllEmployeesOfDepartment(int numberDepartment) {
        for (int i = 0; i < _employees.length; i++) {
            if (_employees[i] != null && _employees[i].get_numberDepartment() == numberDepartment) {
                System.out.println("Сотрудник №" + i + ":");
                System.out.println("Имя - " + _employees[i].get_name());
                System.out.println("Отчество - " + _employees[i].get_patronymic());
                System.out.println("Фамилия - " + _employees[i].get_surname());
                System.out.println("Зарплата - " + (int) _employees[i].get_salary());
                System.out.println();
            }
        }
    }

    // поиск сотрудников с зарплатой меньше определенного числа
    public static Employee[] GetEmployeesLessSalary(double lessSalaryValue) {
        ArrayList<Employee> employeesWithLessSalary = new ArrayList<Employee>();

        for (int i = 0; i < _employees.length; i++) {
            if (_employees[i].get_salary() < lessSalaryValue
                    && _employees[i] != null) {
                employeesWithLessSalary.add(_employees[i]);
            }
        }

        Employee[] employees = new Employee[employeesWithLessSalary.size()];
        employees = employeesWithLessSalary.toArray(employees);

        return employees;
    }

    // поиск сотрудников с зарплатой больше определенного числа
    public static Employee[] GetEmployeesMoreSalary(double moreSalaryValue) {
        ArrayList<Employee> employeesWithMoreSalary = new ArrayList<Employee>();

        for (int i = 0; i < _employees.length; i++) {
            if (_employees[i].get_salary() > moreSalaryValue
                    && _employees[i] != null) {
                employeesWithMoreSalary.add(_employees[i]);
            }
        }

        Employee[] employees = new Employee[employeesWithMoreSalary.size()];
        employees = employeesWithMoreSalary.toArray(employees);

        return employees;
    }
}