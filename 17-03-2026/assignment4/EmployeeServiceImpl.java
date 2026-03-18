package assignment4;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepo repo;
    
    @Override
    public Employee fetchById(int id) {
		return repo.fetchById(id);
	}
    
	@Override
	public void addEmployee(Employee emp) {
		repo.addEmployee(emp);
	}

	@Override
	public void updateEmployee(int id, Employee emp) {
		repo.updateEmployee(id, emp);
	}

	@Override
	public void deleteEmployee(int id) {
		repo.deleteEmployee(id);
	}

	@Override
	public Map<Integer, Employee> getAllEmployees() {
		return repo.getAllEmployees();
	}

}