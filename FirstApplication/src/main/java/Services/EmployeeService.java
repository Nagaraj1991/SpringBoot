package Services;
import modals.EmployeeDO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dal.EmployeeDAL;

@Service
public class EmployeeService {
	
	private final EmployeeDAL _employeeDAL;
	
	@Autowired
	public EmployeeService(@Qualifier("ManagerSQL") EmployeeDAL _employeeDAL)
	{
		this._employeeDAL=_employeeDAL;
	}
	
	public int addEmployee(EmployeeDO _employeeDO)
	{
		return _employeeDAL.addEmployee(_employeeDO);
	}
	
	public List<EmployeeDO> getAllEmployee(){
		return _employeeDAL.getAllEmployee();
	}
	public Optional<EmployeeDO> getEmployeeByID(UUID id)
	{
		return _employeeDAL.getEmployeeByID(id);
	}
	
	public int deleteEmployee(UUID id){
		return _employeeDAL.deleteEmployee(id);
	}
	public int updateEmployee(UUID id,EmployeeDO _employeeDO)
	{
		return _employeeDAL.updateEmployee(id, _employeeDO);
	}
}
