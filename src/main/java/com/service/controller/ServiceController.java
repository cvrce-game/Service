package com.service.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.dto.AccountEntity;
import com.service.dto.Address;
import com.service.dto.Employee;
import com.service.dto.Student;
import com.service.repository.StudentRepository;
import com.service.repository.SystemRepository;

@RestController
public class ServiceController {

	@Autowired
	SystemRepository systemRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	EntityManager em;

	@RequestMapping("/hi")
	public String sayHi() {
		return "Hi";
	}
	
	@RequestMapping("/")
	public Iterable<Employee> sayHello() {
		Iterable<Employee> employee = systemRepository.findAll();
		for (Employee systemmodel : employee) {
			System.out.println("Here is a system: " + systemmodel);
		}
		return employee;
	}

	@RequestMapping("/save")
	public String save() {
		Employee employee = new Employee();
		Address address = new Address();
		employee.setName("Ex2");
		employee.setAddress(address);
		systemRepository.save(employee);
		return "Deatils Saved SuccessFully";
	}

	@RequestMapping("/find")
	public Optional<Employee> find() {
		Optional<Employee> employee = systemRepository.findById(003);
		return employee;
	}

	@RequestMapping("/update")
	public String update() {

		Optional<Employee> employee = systemRepository.findById(11);
		employee.get().setName("Papun Testing");
		employee.get().getAddress().setAddressLine1("Madhapur");
		employee.get().getAddress().setPostalCode("500081");
		systemRepository.save(employee.get());
		return "Deatils Updated SuccessFully";
	}

	@RequestMapping("/delete")
	public String delete() {

		Optional<Employee> employee = systemRepository.findById(13);

		systemRepository.delete(employee.get());
		return "Deatils Deleted SuccessFully";
	}

	@RequestMapping("/criteria")
	public List<Employee> getCriteria() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

		Root<Employee> empRoot = cq.from(Employee.class);
		//Predicate authorNamePredicate = cb.equal(empRoot.get("name"), "Papun");
		Predicate titlePredicate = cb.like(empRoot.get("address"), "%" + "M" + "%");
		cq.where(titlePredicate);

		//cq.select(empRoot.get("name"));
		cq.orderBy(cb.asc(empRoot.get("name")));
		TypedQuery<Employee> query = em.createQuery(cq);
		System.out.println(query.getResultList());
		return query.getResultList();
	}
	@RequestMapping("/oneToMany")
	public Iterable<Student> getOneToManyMapping() {
		
		AccountEntity accountEntity1 = new AccountEntity();
		accountEntity1.setAccountId(101);
		accountEntity1.setAccountNumber("MX121213SJI");
		
		AccountEntity accountEntity2 = new AccountEntity();
		accountEntity1.setAccountId(102);
		accountEntity2.setAccountNumber("MX121343SJI");
		
		Set<AccountEntity> accountEntitySet =  new HashSet<AccountEntity>();
		accountEntitySet.add(accountEntity1);
		accountEntitySet.add(accountEntity2);
		
		Student student = new Student();
		student.setFirstName("Papun");
		student.setLastName("Mohapatra");
		student.setEmail("papun.1424@gmail.com");
		student.setAccounts(accountEntitySet);
		
		studentRepository.save(student);
		
		Iterable<Student> studentItr = studentRepository.findAll();
		for (Student studentModel : studentItr) {
			System.out.println("Here is a studentModel: " + studentModel);
		}
		return studentItr;
	}
}
