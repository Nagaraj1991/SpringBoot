package dal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import modals.EmployeeDO;

public interface EmployeeDAL {
	
	int insertEmployee(UUID empID, EmployeeDO employeeDo);
	
	default int addEmployee(EmployeeDO employeeDO){
		UUID empID=UUID.randomUUID();
		return insertEmployee(empID, employeeDO);
	}
	
	List<EmployeeDO> getAllEmployee();
	
	Optional<EmployeeDO> getEmployeeByID(UUID id);
	
	int updateEmployee(UUID id,EmployeeDO _employee);
	
	int deleteEmployee(UUID id);

}
