package api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Services.EmployeeService;
import modals.EmployeeDO;
@RequestMapping("api/v1/employee")
@RestController
public class EmployeeController {
	
	private final EmployeeService _employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService _employeeService){
		this._employeeService=_employeeService;
	}
	@PostMapping
	public void addEmployee(@RequestBody EmployeeDO _employeeDO)
	{
		_employeeService.addEmployee(_employeeDO);
	}

}
