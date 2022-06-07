package com.empleave.service;

import com.empleave.dao.EmployeeRepository;
import com.empleave.entity.Employee;
import com.empleave.entity.VacationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository repository){
        this.employeeRepository = repository;
    }

    public List<Employee> getData(){
        return employeeRepository.getData();
    }

    public List<Employee>  manageEmpVacation(List<VacationDTO> dtoList){
        return employeeRepository.manageEmpVacation(dtoList);
    }

    public Boolean validateVacationDays(VacationDTO dto){
        return employeeRepository.validateVacationDays(dto);
    }

}
