package org.example;

import org.springframework.stereotype.Repository;

@Repository
@Prod
public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public String fireEmployee() {
        return "Employee fired";
    }
}
