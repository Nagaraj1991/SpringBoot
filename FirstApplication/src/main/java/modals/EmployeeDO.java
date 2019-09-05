package modals;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDO {
	private final UUID empID;
	private final String empName;
	
	public EmployeeDO(@JsonProperty("EmpID") UUID empID,@JsonProperty("EmpName") String empName){
		this.empID=empID;
		this.empName=empName;
	}
	
	public UUID getID(){
		return empID;
	}
	
	public String getempName(){
		return empName;
	}
	
	
	
}
