package tree.companyhierarchy;

import java.util.*;

public class Company {
    private Employee head;
    private Set<Employee> employees = new HashSet<>();

    public Company(String email, String name) {
        this.head = new Employee(email, name);
    }

    public void addEmployee(String email, String name, String bossEmail) {
        employees.add(new Employee(email, name, bossEmail));
    }


    public Employee findByEmail(String email) {
        return findByEmail(head,email);
    }

    private Employee findByEmail(Employee searchIn,String email){
        if (head.getEmail().equals(email)) {
            return head;
        }
        Set<Employee>newEmployees=new HashSet<>(employees);
        List<Employee>childNodes=new ArrayList<>();
        Iterator<Employee>i=newEmployees.iterator();
        while(i.hasNext()){
            Employee em=i.next();
            if(em.getEmail().equals(email)){
                return em;
            }
            childNodes.add(em);
        }
        for (Employee e:childNodes) {
            findByEmail(e,email);
        }
        throw new IllegalArgumentException("cannot find the person "+searchIn.getName());
    }

    public Employee findBossOf(String email){
        Employee employee = findByEmail(email);

        return findByEmail(employee.getBossEmail());
    }

    public List<Employee> employeesOf(String email) {
        List<Employee>totalEmployeesPerPerson=new ArrayList<>();
       return totalEmployeesPerPerson;
    }



}
