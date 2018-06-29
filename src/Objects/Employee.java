package Objects;

import Resources.ID;

import java.io.Serializable;

public class Employee extends ID implements Serializable {

    private String employeeName;
    private String employeeEmail;
    private String employeePhone;
    int employeeId;

    public Employee(String employeeName, String employeeEmail, String employeePhone) {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
        employeeId = getEmployeeId();
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
}
