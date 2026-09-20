package session_six_classes_objects_revision.assignment_problems;

class Employee {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // increments once every time an object is created
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class CompanyMain {

    public static void main(String[] args) {
        Employee e1 = new Employee("Ravi", 45000);
        Employee e2 = new Employee("Divya", 65000);
        Employee e3 = new Employee("Arjun", 0); // intern

        Employee.printCompanyInfo(); // called through the CLASS name
    }
}
