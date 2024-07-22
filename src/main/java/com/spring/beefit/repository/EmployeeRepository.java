package com.spring.beefit.repository;

import com.spring.beefit.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByUsername(String username);

    @Query(value = "SELECT Code FROM Employee b ORDER BY LEN(b.Code) DESC, b.Code DESC OFFSET 0 ROW FETCH NEXT 1 ROW ONLY", nativeQuery = true)
    String getBiggestMa();

    @Query(value = "select e from Employee e where e.id = :id")
    Employee getById(@Param("id") Integer Id);

    @Query(value = "Select e from Employee e where e.status = 0")
    List<Employee> getAll();

    @Query(value = "Select e from Employee e where e.status = 1")
    List<Employee> getAll1();


    @Query(value = "Select e from Employee e where e. fullname like : fullname")
    List<Employee> searchByName(@Param("fullname") String fullname);

    @Query(value = "select e from Employee e where e.username = : username")
    Employee getByUsername(@Param("username") String username);

//            @Query(value = "select e from Employee e where e.status = 0 and (e.role. Id = :idRole or :idRole is null)")
//            public List‹Employee>getEmployeeByRole(@Param("idRole") Integer id);

    @Query(value = "Select e from Employee e where e.status = :status")
    List<Employee> getByStatus(@Param("status") Integer status);

}
