package com.empleave.util;

import com.empleave.entity.EmployeeType;

public class EmpUtil {

    //calculate the vacation day
    public static Float calculateTotalVacationDays(EmployeeType type, Integer totalWorkdays){
        Float noOfVacDays = 0.0f;
        if(type.equals(EmployeeType.HOURLY_EMP)){
            noOfVacDays = 10/260f*totalWorkdays;
        } else if(type.equals(EmployeeType.SALARIED_EMP)){
            noOfVacDays = 15/260f*totalWorkdays;
        } else if(type.equals(EmployeeType.SALARIED_EMP_MANAGER)){
            noOfVacDays = 30/260f*totalWorkdays;
        }
        return noOfVacDays;
    }
}
