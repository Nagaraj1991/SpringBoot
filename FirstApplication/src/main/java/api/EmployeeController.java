package api;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping
	public List<EmployeeDO> getAllEmployee(){
		return _employeeService.getAllEmployee();
	}
	@GetMapping(path="{id}")
	public EmployeeDO getEmployeeByID(@PathVariable("id") UUID id) throws Exception
	{
		return _employeeService.getEmployeeByID(id)
				.orElseThrow(()->new Exception("Employee Not Found"));
	}
	@DeleteMapping(path="{id}")
	public int deleteEmployee(@PathVariable("id") UUID id)
	{
		int i=_employeeService.deleteEmployee(id);
		return i;
	}
	@PutMapping(path="{EmpID}")
	public void updateEmployee(@PathVariable("EmpID") UUID EmpID,@RequestBody EmployeeDO _employeeDO)
	{
		_employeeService.updateEmployee(EmpID, _employeeDO);
	}

}
