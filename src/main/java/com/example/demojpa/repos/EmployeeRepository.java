package com.example.demojpa.repos;

import com.example.demojpa.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;



import java.util.List;


//Q2 Set up EmployeeRepository

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {


    List<Employee> findbyName(String name);
    List<Employee> findByNameLike(String name);
    List<Employee> findByAgeBetween(int age1, int age2);




}
