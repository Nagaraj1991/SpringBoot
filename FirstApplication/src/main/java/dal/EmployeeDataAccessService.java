package dal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
	@Override
	public List<EmployeeDO> getAllEmployee() {
		
		return DB;
	}
	
	@Override
	public int updateEmployee(UUID id, EmployeeDO _employee) {
		return getEmployeeByID(id)
				.map(p->{
					int indexEmp=DB.indexOf(_employee);
					if(indexEmp>=0){
						DB.set(indexEmp, new EmployeeDO(id, _employee.getempName()));
						return 1;
					}
					return 0;
				})
				.orElse(0);
				
	}
	@Override
	public int deleteEmployee(UUID id) {
		Optional<EmployeeDO> employeeDel=getEmployeeByID(id);
		if(employeeDel.isPresent()){
			DB.remove(employeeDel.get());
			return 1;
		}
		return 0;
	}
	@Override
	public Optional<EmployeeDO> getEmployeeByID(UUID id) {
		return DB.stream()
				.filter(employee->employee.getID().equals(id))
				.findFirst();
	}
}
