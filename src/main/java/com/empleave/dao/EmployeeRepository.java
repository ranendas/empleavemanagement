package com.empleave.dao;

import com.empleave.entity.Employee;
import com.empleave.entity.EmployeeType;
import com.empleave.entity.VacationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeRepository {

    Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);

    List<Employee> employeeList = new ArrayList<>();

    @PostConstruct
    public List<Employee> createEmployeeData(){
        logger.info("Loading Data");
        Employee hourlyEmp1 = new Employee(101, "Hourly_Emp1", 260, EmployeeType.HOURLY_EMP);
        Employee hourlyEmp2 = new Employee(102, "Hourly_Emp2", 230, EmployeeType.HOURLY_EMP);
        Employee hourlyEmp3 = new Employee(103, "Hourly_Emp3", 200, EmployeeType.HOURLY_EMP);
        Employee hourlyEmp4 = new Employee(104, "Hourly_Emp4", 175, EmployeeType.HOURLY_EMP);
        Employee hourlyEmp5 = new Employee(105, "Hourly_Emp5", 150, EmployeeType.HOURLY_EMP);
        Employee hourlyEmp6 = new Employee(106, "Hourly_Emp6", 125, EmployeeType.HOURLY_EMP);
        Employee hourlyEmp7 = new Employee(107, "Hourly_Emp7", 100, EmployeeType.HOURLY_EMP);
        Employee hourlyEmp8 = new Employee(108, "Hourly_Emp8", 75, EmployeeType.HOURLY_EMP);
        Employee hourlyEmp9 = new Employee(109, "Hourly_Emp9", 50, EmployeeType.HOURLY_EMP);
        Employee hourlyEmp10 = new Employee(110, "Hourly_Emp10", 25, EmployeeType.HOURLY_EMP);
        employeeList.add(hourlyEmp1);
        employeeList.add(hourlyEmp2);
        employeeList.add(hourlyEmp3);
        employeeList.add(hourlyEmp4);
        employeeList.add(hourlyEmp5);
        employeeList.add(hourlyEmp6);
        employeeList.add(hourlyEmp7);
        employeeList.add(hourlyEmp8);
        employeeList.add(hourlyEmp9);
        employeeList.add(hourlyEmp10);

        Employee salEmp1 = new Employee(201, "Salary_Emp1", 260, EmployeeType.SALARIED_EMP);
        Employee salEmp2 = new Employee(202, "Salary_Emp2", 230, EmployeeType.SALARIED_EMP);
        Employee salEmp3 = new Employee(203, "Salary_Emp3", 200, EmployeeType.SALARIED_EMP);
        Employee salEmp4 = new Employee(204, "Salary_Emp4", 175, EmployeeType.SALARIED_EMP);
        Employee salEmp5 = new Employee(205, "Salary_Emp5", 150, EmployeeType.SALARIED_EMP);
        Employee salEmp6 = new Employee(206, "Salary_Emp6", 125, EmployeeType.SALARIED_EMP);
        Employee salEmp7 = new Employee(207, "Salary_Emp7", 100, EmployeeType.SALARIED_EMP);
        Employee salEmp8 = new Employee(208, "Salary_Emp8", 75, EmployeeType.SALARIED_EMP);
        Employee salEmp9 = new Employee(209, "Salary_Emp9", 50, EmployeeType.SALARIED_EMP);
        Employee salEmp10 = new Employee(210, "Salary_Emp10", 25, EmployeeType.SALARIED_EMP);
        employeeList.add(salEmp1);
        employeeList.add(salEmp2);
        employeeList.add(salEmp3);
        employeeList.add(salEmp4);
        employeeList.add(salEmp5);
        employeeList.add(salEmp6);
        employeeList.add(salEmp7);
        employeeList.add(salEmp8);
        employeeList.add(salEmp9);
        employeeList.add(salEmp10);

        Employee salManEmp1 = new Employee(301, "Salary_Man_Emp1", 260, EmployeeType.SALARIED_EMP_MANAGER);
        Employee salManEmp2 = new Employee(302, "Salary_Man_Emp2", 230, EmployeeType.SALARIED_EMP_MANAGER);
        Employee salManEmp3 = new Employee(303, "Salary_Man_Emp3", 200, EmployeeType.SALARIED_EMP_MANAGER);
        Employee salManEmp4 = new Employee(304, "Salary_Man_Emp4", 175, EmployeeType.SALARIED_EMP_MANAGER);
        Employee salManEmp5 = new Employee(305, "Salary_Man_Emp5", 150, EmployeeType.SALARIED_EMP_MANAGER);
        Employee salManEmp6 = new Employee(306, "Salary_Man_Emp6", 125, EmployeeType.SALARIED_EMP_MANAGER);
        Employee salManEmp7 = new Employee(307, "Salary_Man_Emp7", 100, EmployeeType.SALARIED_EMP_MANAGER);
        Employee salManEmp8 = new Employee(308, "Salary_Man_Emp8", 75, EmployeeType.SALARIED_EMP_MANAGER);
        Employee salManEmp9 = new Employee(309, "Salary_Man_Emp9", 50, EmployeeType.SALARIED_EMP_MANAGER);
        Employee salManEmp10 = new Employee(310, "Salary_Man_Emp10", 25, EmployeeType.SALARIED_EMP_MANAGER);
        employeeList.add(salManEmp1);
        employeeList.add(salManEmp2);
        employeeList.add(salManEmp3);
        employeeList.add(salManEmp4);
        employeeList.add(salManEmp5);
        employeeList.add(salManEmp6);
        employeeList.add(salManEmp7);
        employeeList.add(salManEmp8);
        employeeList.add(salManEmp9);
        employeeList.add(salManEmp10);

        employeeList.forEach(emp->{
            emp.work(emp.getTotalWorkingDays());
        });
        logger.info("Employee Data size = "+ employeeList.size());
        return employeeList;
    }

    public List<Employee> getData(){
        return employeeList;
    }

    /**
     *
     * @param dtoList
     * @return
     */

    public List<Employee> manageEmpVacation(List<VacationDTO> dtoList){
        dtoList.forEach(dto->{
            if(validateVacationDays(dto)) {
                Float noOfVacationDays = dto.getNoOfVacationDays();
                dto.getEmployee().takeVacation(noOfVacationDays);
            } else {
                logger.info("Vacation cannot be updated ");
            }
        });

        dtoList.forEach(dto->{
            if(dto.getEmployee().getVacationChanged()) {
                employeeList.stream().filter(emp -> Objects.equals(dto.getEmployee().getEmployeeId(), emp.getEmployeeId())).
                        findFirst().get().setVacationDays(dto.getEmployee().getVacationDays());
            }});
        return employeeList;
    }

    /**
     *
     * @param dto
     * @return
     */
    public Boolean validateVacationDays(VacationDTO dto){
        Boolean isValid = false;
        Float noOfVacationDays = dto.getNoOfVacationDays();
        if(noOfVacationDays < dto.getEmployee().getVacationDays()){
            isValid = true;
        }
        logger.info("Data are valid or not = "+ isValid);
        return isValid;
    }

}
