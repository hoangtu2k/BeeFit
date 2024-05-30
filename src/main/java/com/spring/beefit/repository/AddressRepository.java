package com.spring.beefit.repository;

import com.spring.beefit.entity.Address;
import com.spring.beefit.viewmodel.response.AddressResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query("Select e from Address e where e.Status = 0 and e.customer.id = :id")
    List<Address> getAddressByCustomer(@Param("id") Integer id);
    @Query("Select e from Address e where e.Status = 0 and e.Id = :id")
    Address getAddressById(@Param("id") Integer id);
    @Query(value = "Select a.Id , a.Fullname, a.Phone, a.Address , a.CityName, a.DistrictName, a.WardName, a.CityId, a.DistrictId, a.WardId , a.IdCustomer,a.Status from Address a\n" +
            "join Bill b on a.Id = b.IdAddress\n" +
            "where b.Code = :code",nativeQuery = true)
    AddressResponse getAddressByBill(@Param("code") String code);
}
