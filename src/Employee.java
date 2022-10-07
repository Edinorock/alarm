public class Employee
{
    // имя сотрудника
    private String _name;
    // отчество сотрудника
    private String _patronymic;
    // фамилия сотрудника
    private String _surname;
    // зарплата сотрудника
    private double _salary;

    // номер отдела сотрудника
    private int _numberDepartment;

    public Employee(String name, String patronymic, String surname, double salary, int numberDepartment) throws Exception {
        set_name(name);
        set_patronymic(patronymic);
        set_surname(surname);
        set_salary(salary);
        set_numberDepartment(numberDepartment);
    }

    public String get_name()
    {
        return _name;
    }

    public void set_name(String name) throws Exception
    {
        if (name.isBlank() == false)
        {
            _name = name;
        }
        else
        {
            throw new Exception("Имя не может быть не заполненным или состоять только из пробелов!");
        }
    }

    public String get_patronymic()
    {
        return _patronymic;
    }

    public void set_patronymic(String patronymic) throws Exception
    {
        if (patronymic.isBlank() == false)
        {
            _patronymic = patronymic;
        }
        else
        {
            throw new Exception("Отчество не может быть не заполненным или состоять только из пробелов!");
        }
    }

    public String get_surname()
    {
        return _surname;
    }

    public void set_surname(String surname) throws Exception
    {
        if (surname.isBlank() == false)
        {
            _surname = surname;
        }
        else
        {
            throw new Exception("Фамилия не может быть не заполненной или состоять только из пробелов!");
        }
    }

    public double get_salary()
    {
        return (int)(_salary);
    }

    public void set_salary(double salary) throws Exception {
        if (salary > 0)
        {
            _salary = salary;
        }
        else
        {
            throw new Exception("Зарплата не может быть меньше или равна нулю!");
        }
    }

    public int get_numberDepartment() {
        return _numberDepartment;
    }

    public void set_numberDepartment(int numberDepartment) throws Exception {
        if (numberDepartment > 0)
        {
            _numberDepartment = numberDepartment;
        }
        else
        {
            throw new Exception("Номер отдела не может быть меньше или равен нулю!");
        }
    }
}
