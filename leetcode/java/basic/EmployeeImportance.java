import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class EmployeeImportance {
public int getImportance(List<Employee> employees, int id) {
        
        if(employees == null || employees.size() == 0)
            return 0;
        
        Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();
        
        for(Employee emp: employees)
        {
            empMap.put(emp.id, emp);
        }
    
        
        return getImportance(id,empMap);
    }
    
    int getImportance(int id, Map<Integer, Employee> empMap)
    {
        Employee emp = empMap.get(id);
        
        if(emp == null)
            return 0;
        
        int sum = emp.importance;
        
        for(Integer sub: emp.subordinates)
        {
            sum += getImportance(sub,empMap);
        }
        
        return sum;
    }
}


class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
