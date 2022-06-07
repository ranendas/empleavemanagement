package com.empleave.controller;

import com.empleave.entity.Employee;
import com.empleave.entity.VacationDTO;
import com.empleave.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    EmployeeService employeeService;
    List<Employee> list= new ArrayList<>();

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/api/employee")
    public List<Employee> load(){
        list = employeeService.getData();
        logger.info("Loading Employee Data , size =  " + list.size());
        return list;
    }

    @PostMapping("/api/employee")
    public ResponseEntity<List<Employee>> manageEmpVacation(@RequestBody List<VacationDTO> dtoList){
        logger.info("POST mapping  DTO size =  "+dtoList.size());
        list = employeeService.manageEmpVacation(dtoList);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/api/employee/vacationdays")
    public ResponseEntity<Boolean> validateVacationDays(@RequestBody VacationDTO dto){
        if(dto==null || dto.getNoOfVacationDays() == 0.0){
            return new ResponseEntity("Missing Data", HttpStatus.NOT_ACCEPTABLE);
        }
        Boolean isValid = employeeService.validateVacationDays(dto);
        return new ResponseEntity<>(isValid, HttpStatus.OK);
    }
}
