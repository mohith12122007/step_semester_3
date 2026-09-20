package session_six_classes_objects_revision.assignment_problems;

class CompanyEmployee {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    CompanyEmployee(String empName, double salary) {
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
        CompanyEmployee e1 = new CompanyEmployee("Ravi", 45000);
        CompanyEmployee e2 = new CompanyEmployee("Divya", 65000);
        CompanyEmployee e3 = new CompanyEmployee("Arjun", 0); // intern

        CompanyEmployee.printCompanyInfo(); // called through the CLASS name
    }
}
