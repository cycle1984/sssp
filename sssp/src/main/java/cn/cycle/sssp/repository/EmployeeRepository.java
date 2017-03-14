package cn.cycle.sssp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.cycle.sssp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
