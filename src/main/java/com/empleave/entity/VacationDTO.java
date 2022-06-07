package com.empleave.entity;

public class VacationDTO {
    private Employee employee;
    private float noOfVacationDays;

    public float getNoOfVacationDays() {
        return noOfVacationDays;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setNoOfVacationDays(float noOfVacationDays) {
        this.noOfVacationDays = noOfVacationDays;
    }
}
