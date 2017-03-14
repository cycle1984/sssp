package cn.cycle.sssp.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.cycle.sssp.entity.Employee;
import cn.cycle.sssp.service.EmployeeService;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/emps")
	public String list(@RequestParam(value="pageNo",required=false,defaultValue="1") String pageNoStr,
			Map<String,Object> map){
		
		int pageNo = 1;
		
		try {
			//对 pageNo 的校验
			pageNo = Integer.parseInt(pageNoStr);
			if(pageNo < 1){
				pageNo = 1;
			}
		} catch (Exception e) {}
		//pageNo从1开始
		Page<Employee> page = employeeService.getPage(pageNo, 5);
		//获取总页数，
		int totalPages = page.getTotalPages();
		if(pageNo>totalPages){
			pageNo = totalPages;
			page = employeeService.getPage(pageNo, 5);
		}
		System.out.println("numberOfElements:"+page.getNumberOfElements());
		System.out.println("totalPages:"+totalPages);
		map.put("page", page);
		return "emp/list";
	}
}
