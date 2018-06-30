package Objects;

import Resources.ID;

import java.io.Serializable;

public class Employee extends ID implements Serializable {

    private String employeeName;
    private String employeeEmail;
    private String employeePhone;
    int employeeId;

    public Employee() {
        this.employeeName = "test";
        this.employeeEmail = "Test@test.gov";
        this.employeePhone = "1234567890";
        addEmployeeId();
        employeeId = super.getEmployeeId();
    }

    public Employee(String employeeName, String employeeEmail, String employeePhone) {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
        addEmployeeId();
        employeeId = super.getEmployeeId();
    }

    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    @Override
    public String toString() {
        return String.format("Employee Name: %s\nEmployee Email: %s\nEmployee Phone: %s\n",getEmployeeName(),getEmployeeEmail(),getEmployeePhone());
    }
}
