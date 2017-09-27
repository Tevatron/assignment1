
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeDatabase {
	
	ArrayList<Employee> EmployeeList;
	
	
	EmployeeDatabase(){
		EmployeeList = new ArrayList<Employee>();	
	}
	
	
	void AddEmployee(String e) {
		if (containsEmployee(e)) {
			return;
		}
		Employee newEmployee = new Employee(e);
		EmployeeList.add(newEmployee);
	}
	
	void addDestination(String e, String d) {
		if (e==null || d==null) {
			throw new IllegalArgumentException("cannot pass null value into addDestination");
		}
		if (!containsEmployee(e)) {
			throw new IllegalArgumentException("User "+e+" does not exist in database");
		}
		getDestinations(e).add(d);
	}
	
	boolean containsEmployee(String e) {
		if (e==null) {
			throw new IllegalArgumentException();
		}
		Iterator<Employee> it = EmployeeList.iterator();
		while(it.hasNext()) {
			Employee curEmp = it.next();
			if (curEmp.getUsername().equals(e)) {
				return true;
			}
		}
		return false;
	}
	
	boolean containsDestination(String d) {
		return false;
	}
	
	boolean hasDestination(String e, String d) {
		return false;
	}
	
	List<String> getEmployees(String d){
		if (d==null) {
			throw new IllegalArgumentException("cannot pass in null value");
		}
		List<String> empList = new ArrayList<String>();
		Iterator<Employee> it = iterator();
		while(it.hasNext()) {
			Employee curEmp = it.next();
			if (curEmp.getWishlist().contains(d)) {
				empList.add(curEmp.getUsername());
			}
		}
		return empList;
	}
	
	List<String> getDestinations(String e){
		if (e==null) {
			throw new IllegalArgumentException();
		}
		Iterator<Employee> it = iterator();
		while(it.hasNext()) {
			Employee curEmp = it.next();
			if (curEmp.getUsername().equals(e)) {
				return curEmp.getWishlist();
			}
		}
		return null;
	}
	
	Iterator<Employee> iterator(){
		Iterator<Employee> it = EmployeeList.iterator();
		return it;
	}
	

	boolean removeEmployee(String e) {
		
		Iterator<Employee> it=iterator();
		while(it.hasNext()) {
			Employee curEmp = it.next();
			if (curEmp.getUsername().equals(e)) {
				it.remove();
				return true;
			}
		}
		return false;
	}
	
	boolean removeDestination(String d) {
		if (d==null) {
			throw new IllegalArgumentException("cannot pass null value");
		}
		boolean exitVal = false;
		Iterator<Employee> it=iterator();
		while(it.hasNext()) {
			Employee curEmp = it.next();
			if (curEmp.getWishlist().remove(d)) {
				exitVal = true;
			}
		}
		return exitVal;
	}
	
	int size() {
		return EmployeeList.size();
	}
}
