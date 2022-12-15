package org.example;

import org.springframework.stereotype.Repository;

@Repository
@Dev
public class MockEmployeeDao implements EmployeeDao{
    @Override
    public String fireEmployee() {
        return "mock employee fired";
    }
}
