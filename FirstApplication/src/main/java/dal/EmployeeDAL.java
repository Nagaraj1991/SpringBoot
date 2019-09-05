package dal;
import java.util.UUID;

import modals.EmployeeDO;

public interface EmployeeDAL {
	
	int insertEmployee(UUID empID, EmployeeDO employeeDo);
	
	default int addEmployee(EmployeeDO employeeDO){
		UUID empID=UUID.randomUUID();
		return insertEmployee(empID, employeeDO);
	}

}
