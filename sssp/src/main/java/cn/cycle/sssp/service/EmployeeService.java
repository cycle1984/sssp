package cn.cycle.sssp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cn.cycle.sssp.entity.Employee;
import cn.cycle.sssp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Page<Employee> getPage(int pageNo,int pageSize){
		
		PageRequest pageable = new PageRequest(pageNo-1, pageSize);
		return employeeRepository.findAll(pageable);
	}
}
