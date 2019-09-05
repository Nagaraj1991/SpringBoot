package dal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import modals.EmployeeDO;
@Repository("Manager")
public class EmployeeDataAccessService implements EmployeeDAL {

	private static List<EmployeeDO> DB=new ArrayList<>();
	@Override
	public int insertEmployee(UUID empID,EmployeeDO employeeDO)
	{
		DB.add(new EmployeeDO(empID, employeeDO.getempName()));
		return 1;
	}
}
