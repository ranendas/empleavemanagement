package com.empleave.entity;

import com.empleave.util.EmpUtil;

public class Employee {

    private Integer employeeId;
    private String employeeName;
    private Integer totalWorkingDays;
    private EmployeeType employeeType;
    private Float vacationDays;
    private Boolean isVacationChanged= false;

    public Employee(Integer employeeId, String employeeName, Integer totalWorkingDays, EmployeeType employeeType) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.totalWorkingDays = totalWorkingDays;
        this.employeeType = employeeType;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getTotalWorkingDays() {
        return totalWorkingDays;
    }

    public void setTotalWorkingDays(Integer totalWorkingDays) {
        this.totalWorkingDays = totalWorkingDays;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Boolean getVacationChanged() {
        return isVacationChanged;
    }

    public void setVacationChanged(Boolean vacationChanged) {
        isVacationChanged = vacationChanged;
    }

    public void work(Integer workdays){
        if(workdays>0 && workdays<=260) {
            this.setVacationDays(EmpUtil.calculateTotalVacationDays(getEmployeeType(), workdays));
        } else {
            //work days cannt be more than 260 days
        }
    }

    public void takeVacation(float noOfVacDays){
        this.setVacationDays(this.vacationDays - noOfVacDays);
        this.setVacationChanged(true);
    }

    public Float getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(Float vacationDays) {
        this.vacationDays = vacationDays;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", totalWorkingDays=" + totalWorkingDays +
                ", employeeType=" + employeeType +
                ", vacationDays=" + vacationDays +
                '}';
    }
}
