package com.spring.beefit.repository;

import com.spring.beefit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("Select p from Product p where p.id = :id")
    Product getById(@Param("id") Integer id);

    @Query(value = "Select e from Product e where e.status = 0 Order by e.createDate desc")
    List<Product> getAll();

    @Query(value = "Select e from Product e where e.status = 1 Order by e.createDate desc")
    List<Product> getAll1();

    @Query("Select e from Product  e where e.code = :code")
    Product getByCode(@Param("code") String code);

    @Query(value = "Select SUM(b.quantity) from BillDetail b \n" +
            "join Bill  c on c.id = b.bill.id \n" +
            "where b.product.id = :id and c.status = 3")
    Integer quantitySold(@Param("id") Integer id);
    @Query(value = "Select SUM (b.quantity * b.unitPrice) from BillDetail b \n" +
            "join Bill  c on c.id = b.bill.id \n" +
            "where b.product.id = :id and c.status = 3")
    Double totalSale(@Param("id") Integer id);








    // filter
    @Query(value = "Select e.Id,e.Code,e.Name,e.Weight,e.Discount,e.DiscountDate ,e.Price,e.Description,e.CreateDate,e.UpdateDate,e.CreateBy,e.UpdateBy,e.Status,e.IdBrand,e.IdHandType,e.IdNeckType,e.IdCategory,e.IdDesign \n" +
            "from Product e " +
            "\tjoin ProductDetail_Material m on m.IdProduct = e.Id\n" +
            "\tjoin Material ma on ma.Id = m.IdMaterial\n" +
            "\tjoin ProductDetail_Color_Size p on p.IdProduct = e.Id\n" +
            "\tjoin Color c on c.Id = p.IdColor\n" +
            "\tjoin Size s on s.Id = p.IdSize\n" +
            "where (ma.Id = :idmaterial or :idmaterial is null) \n" +
            "\tand (c.Id = :idcolor or :idcolor is null) \n" +
            "\tand (s.Id = :idsize or :idsize is null) \n" +
            "\tand (e.IdCategory = :idcategory or :idcategory is null) \n" +
            "\tand (e.IdBrand = :idbrand or :idbrand is null) \n" +
            "\tand (e.IdDesign = :iddesign or :iddesign is null) \n" +
            "\tand (e.IdHandType = :idhandtype or :idhandtype is null) \n" +
            "\tand (e.IdNeckType = :idnecktype or :idnecktype is null) \n" +
            "\tand e.Price >= :min and e.Price <= :max and e.Status = 0\n" +
            "\tand e.Id in (\n" +
            "select IdProduct\n" +
            "       from ProductDetail_Color_Size\n" +
            "group by IdProduct\n" +
            "       having SUM(Quantity) < 1 AND SUM(Quantity) > :soLuong1 OR :soLuong IS NULL)\n" +
            "group by e.Id,e.Code,e.Name,e.Weight,e.Discount,e.DiscountDate,e.Price,e.Description,e.CreateDate,e.UpdateDate,e.CreateBy,e.UpdateBy,e.Status,e.IdBrand,e.IdCategory,e.IdHandType,e.IdNeckType,e.IdDesign\n" +
            "           order by e.createDate desc\n" +
            "        ",nativeQuery = true)
    List<Product> getAllByFilter(
            @Param("idcolor") Integer IdColor , @Param("idsize") Integer IdSize,
            @Param("idmaterial") Integer IdMaterial,@Param("idcategory") Integer IdCategory ,
            @Param("idbrand") Integer IdBrand ,@Param("idhandtype") Integer IdHandType,
            @Param("idnecktype") Integer IdNeckType,@Param("iddesign") Integer IdDesign,
            @Param("min") Double min ,@Param("max") Double max,
            @Param("soLuong") Integer soLuong,@Param("soLuong1") Integer soLuong1);

}
