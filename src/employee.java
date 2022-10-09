public class employee
{
    // идентификатор
    private int Id;
    // статический счетчик генератор
    private static int employeeCount;
    // имя сотрудника
    private String name;
    // отчество сотрудника
    private String patronymic;
    // фамилия сотрудника
    private String surname;
    // зарплата сотрудника
    private double salary;

    // номер отдела сотрудника
    private int numberDepartment;

    // статический конструктор
    static {
        employeeCount = 0;
    }
    public employee(String name, String patronymic, String surname, double salary, int numberDepartment) throws Exception {
        setName(name);
        setPatronymic(patronymic);
        setSurname(surname);
        setSalary(salary);
        setNumberDepartment(numberDepartment);

        employeeCount += 1;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public String getName()
    {
        return name;
    }

    private void setName(String name) throws Exception
    {
        if (name.isBlank() == false)
        {
            this.name = name;
        }
        else
        {
            throw new Exception("Имя не может быть не заполненным или состоять только из пробелов!");
        }
    }

    public String getPatronymic()
    {
        return patronymic;
    }

    private void setPatronymic(String patronymic) throws Exception
    {
        if (patronymic.isBlank() == false)
        {
            this.patronymic = patronymic;
        }
        else
        {
            throw new Exception("Отчество не может быть не заполненным или состоять только из пробелов!");
        }
    }

    public String getSurname()
    {
        return surname;
    }

    private void setSurname(String surname) throws Exception
    {
        if (surname.isBlank() == false)
        {
            this.surname = surname;
        }
        else
        {
            throw new Exception("Фамилия не может быть не заполненной или состоять только из пробелов!");
        }
    }

    public double getSalary()
    {
        return (int)(salary);
    }

    public void setSalary(double salary) throws Exception {
        if (salary > 0)
        {
            this.salary = salary;
        }
        else
        {
            throw new Exception("Зарплата не может быть меньше или равна нулю!");
        }
    }

    public int getNumberDepartment() {
        return numberDepartment;
    }

    private void setNumberDepartment(int numberDepartment) throws Exception {
        if (numberDepartment > 0)
        {
            this.numberDepartment = numberDepartment;
        }
        else
        {
            throw new Exception("Номер отдела не может быть меньше или равен нулю!");
        }
    }
}
