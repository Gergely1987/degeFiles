package tree.companyhierarchy;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CompanyTest {

    private Company company;

    @Before
    public void createHierarchy() {
        company = new Company("joe@company.com", "Joe Doe");
        company.addEmployee("john@company.com", "John Doe", "joe@company.com");
        company.addEmployee("jane@company.com", "Jane Doe", "joe@company.com");
        company.addEmployee("jeremy@company.com", "Jeremy Doe", "john@company.com");
        company.addEmployee("joseph@company.com", "Joseph Doe", "john@company.com");
    }

    @Test
    public void testEmptyCompany() {
        Company company = new Company("joe@company.com", "Joe Doe");

        assertThat(company.findByEmail("joe@company.com").getName(), equalTo("Joe Doe"));
        assertThat(company.findByEmail("joe@company.com").getEmail(), equalTo("joe@company.com"));
    }

    @Test
    public void testFind() {
        assertThat(company.findByEmail("john@company.com").getName(), equalTo("John Doe"));
        assertThat(company.findByEmail("joseph@company.com").getName(), equalTo("Joseph Doe"));
    }

    @Test
    public void testFindBossOf() {
        assertThat(company.findBossOf("jeremy@company.com").getName(), equalTo("John Doe"));
    }

//    @Test
//    public void testEmployeesOf() {
//        List<Employee> employees = company.employeesOf("john@company.com");
//        assertThat(employees.get(0).getName(), equalTo("Jeremy Doe"));
//        assertThat(employees.get(1).getName(), equalTo("Joseph Doe"));
//    }
}
