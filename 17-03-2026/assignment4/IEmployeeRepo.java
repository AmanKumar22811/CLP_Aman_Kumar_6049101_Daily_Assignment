package assignment4;

import java.util.Map;

public interface IEmployeeRepo {

    Employee fetchById(int id);

    void addEmployee(Employee emp);

    void updateEmployee(int id, Employee emp);

    void deleteEmployee(int id);

    Map<Integer, Employee> getAllEmployees();
}