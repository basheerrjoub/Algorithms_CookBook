public class Main {
    public static void main(String[] args) {
        //fetch employee record based on his id from the database
        Employee model = retriveEmployeeFromDatabase();

        //Create a view : to write employee details on console
        EmployeeView view = new EmployeeView();

        EmployeeController controller = new EmployeeController(model, view);

        controller.updateView();

        //update model data
        controller.setEmployeeName("John");

        controller.updateView();
    }

    private static Employee retriveEmployeeFromDatabase() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Robert");
        employee.setSalary(10000);
        return employee;
    }
}

class Employee {
    private String id;
    private String name;
    private double salary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class EmployeeView {
    public void printEmployeeDetails(String name, double salary) {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class EmployeeController {
    private Employee model;
    private EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public void setEmployeeName(String name) {
        model.setName(name);
    }

    public String getEmployeeName() {
        return model.getName();
    }

    public void setEmployeeSalary(double salary) {
        model.setSalary(salary);
    }

    public double getEmployeeSalary() {
        return model.getSalary();
    }

    public void updateView() {
        view.printEmployeeDetails(model.getName(), model.getSalary());
    }
}
