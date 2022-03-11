package com.example.demojpa;

import com.example.demojpa.entity.Employee;
import com.example.demojpa.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
class DemoJpaApplicationTests {

	@Autowired
	EmployeeRepository er;


	//Q-3 Perform Create Operation on Entity using Spring Data JPA
	// We have create test for Employee of which id is auto incremented as by AUTO_INCREMENT

	@Test
	void testCreateEmployee() {
		Employee employee=new Employee();
		employee.setName("Radhika");
		employee.setName("Suchi");

		er.save(employee);
	}





	//Q(4) Perform Update Operation on Entity using Spring Data JPA

	//update operation to update id through existing id
	@Test
	public void testUpdate(){
		Employee employee = EmployeeRepository.findById(1).get();
		employee.setName("Ritika Rawat");
		EmployeeRepository.save(employee);
	}




//(5) Perform Delete Operation on Entity using Spring Data JPA

	//IN this is we are deleting
	@Test
	public void testDelete(){
		if(EmployeeRepository.existsById(1)){
			System.out.println("Deleting");
			EmployeeRepository.deleteById(1);
		}
	}




//(5) Perform Read Operation on Entity using Spring Data JPA

	//Read out our entity as checking through assert statement
	@Test
	public void testRead(){
		Employee employee = EmployeeRepository.findById(1).get();
		assertNotNull(employee);
		assertEquals("Ritika", employee.getName());
	}





//(6) Get the total count of the number of Employees
	//counting no of employee in our tables and fetching it and geeting our result

	@Test
	public void testCount(){
		System.out.println("Total Records" + EmployeeRepository.count());
	}






//Implement Pagination and Sorting on the bases of Employee Age
	//Through pagingnation sorting makes moe easier to sort any particular varaible or entity.

	@Test
	public void testPagingAndSortingByAge(){
		Pageable pageable = (Pageable) PageRequest.of(1,1, Sort.by("age"));
		EmployeeRepository.findAll(pageable).forEach(p -> System.out.println(p.getName()));
	}




//Create and use finder to find Employee by Name
	//Findin a name "Ritika" in the table
	@Test
	public void testFindByName(){
		List<Employee> employees = EmployeeRepository.findByName("Ritika");
		employees.forEach(p -> System.out.println(p.getId()));
	}




//Create and use finder to find Employees starting with A character
	//It will display all the employee whose name starts with %A%
	@Test
	public void testFindByCharA(){
		List<Employee> employees = EmployeeRepository.findByNameLike("%A%");
		employees.forEach(p -> System.out.println(p.getName()));
	}




	// Create and use finder to find Employees Between the age of 28 to 32
//Display all the age between 28 to 32 whosoever employee age belongs to it
	@Test
	public void testFindByAgeBetween(){
		List<Employee> employees = EmployeeRepository.findByAgeBetween(28,32);
		employees.forEach(p -> System.out.println(p.getName()));
	}


}
