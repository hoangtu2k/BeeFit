package com.spring.beefit.repository;

import com.spring.beefit.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "Select c from Customer c where c.status = 0 Order by c.createDate desc")
    List<Customer> getAll();
    @Query(value = "Select c from Customer c where c.status = 1 Order by c.createDate desc")
    List<Customer> getAll1();
    Customer findByUsername(String username);
    @Query(value = "select e from Customer e where e.id = :id")
    Customer getById(@Param("id") Integer Id);
    @Query(value = "select e from Customer e where e.status = 0 and e.fullname like :fullname" )
    List<Customer> searchByFullName(@Param("fullname") String fullname);
    @Query(value = "select e from Customer e where e.username = :username")
    Customer getByUsername(@Param("username") String username);
    @Query(value = "select e from Customer e where e.username = :username")
    Optional<Customer> getByUsernamejwt(@Param("username") String username);
    @Query(value = "Select c.Id,c.Code,c.Fullname,c.Username,c.Password,c.Image,c.Gender,c.Phone,c.Email,c.CreateDate,c.UpdateDate,c.CreateBy,c.UpdateBy,c.Status from Customer c\n" +
            "left join Bill b on b.IdCustomer = c.Id\n" +
            "left join BillDetail bd on bd.IdOrder = b.Id\n" +
            "where c.Id = :IdCustomer and bd.IdProduct = :IdProduct and b.Status = 3", nativeQuery = true)
    Customer checkDanhGia(@Param("IdCustomer") Integer IdCustomer , @Param("IdProduct") Integer IdProduct);

}
