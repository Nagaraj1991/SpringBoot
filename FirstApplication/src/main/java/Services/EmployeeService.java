package Services;
import modals.EmployeeDO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dal.EmployeeDAL;

@Service
public class EmployeeService {
	
	private final EmployeeDAL _employeeDAL;
	
	@Autowired
	public EmployeeService(@Qualifier("Manager") EmployeeDAL _employeeDAL)
	{
		this._employeeDAL=_employeeDAL;
	}
	
	public int addEmployee(EmployeeDO _employeeDO)
	{
		return _employeeDAL.addEmployee(_employeeDO);
	}
}
