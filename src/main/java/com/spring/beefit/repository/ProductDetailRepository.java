package com.spring.beefit.repository;

import com.spring.beefit.entity.ProductDetail;
import com.spring.beefit.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {

    @Query(value = "Select e from ProductDetail e where e.status = 0 Order by e.createDate desc")
    List<ProductDetail> getAll();

    @Query(value = "Select e from ProductDetail e where e.status = 1 Order by e.createDate desc")
    List<ProductDetail> getAll1();

    @Query(value = "Select e from ProductDetail e where e.id = :id")
    ProductDetail getById(@Param("id") Integer id);

    @Query("Select e from ProductDetail  e where e.product.code = :code")
    ProductDetail getByCode(@Param("code") String code);


    @Query(value = "Select e.Id,e.Price,e.Description,e.CreateDate,e.UpdateDate,e.CreateBy,e.UpdateBy,e.Status,e.IdProduct,e.IdBrand,e.IdHandType,e.IdNeckType,e.IdCategory,e.IdDesign,e.IdPromotion \n" +
            "from ProductDetail e join ProductDetail_Material m on m.IdProductDetail = e.Id\n" +
            "\tjoin Material ma on ma.Id = m.IdMaterial\n" +
            "\tjoin ProductDetail_Color_Size p on p.IdProductDetail = e.Id\n" +
            "\tjoin Color c on c.Id = p.IdColor\n" +
            "\tjoin Product pro on pro.Id = e.IdProduct\n" +
            "\tjoin Size s on s.Id = p.IdSize\n" +
            "where (ma.Id = :idmaterial or :idmaterial is null) \n" +
            "\tand (c.Id = :idcolor or :idcolor is null) \n" +
            "\tand (s.Id = :idsize or :idsize is null) \n" +
            "\tand (e.IdCategory = :idcategory or :idcategory is null) \n" +
            "\tand (e.IdBrand = :idbrand or :idbrand is null) \n" +
            "\tand (e.IdDesign = :iddesign or :iddesign is null) \n" +
            "\tand (e.IdHandType = :idhandtype or :idhandtype is null) \n" +
            "\tand (e.IdNeckType = :idnecktype or :idnecktype is null) \n" +
            "\tand (e.IdPromotion = :idpromotion or :idpromotion is null) \n" +
            "\tand e.Price >= :min and e.Price <= :max and e.Status = 0\n" +
            "\tand e.Id in (\n" +
            "select IdProductDetail\n" +
            "       from ProductDetail_Color_Size\n" +
            "group by IdProductDetail\n" +
            "       having SUM(Quantity) < 1 AND SUM(Quantity) > :soLuong1 OR :soLuong IS NULL)\n" +
            "group by e.Id,e.Price,e.Description,e.CreateDate,e.UpdateDate,e.CreateBy,e.UpdateBy,e.Status,e.IdProduct,e.IdBrand,e.IdCategory,e.IdHandType,e.IdNeckType,e.IdDesign,e.IdPromotion\n" +
            "           order by e.createDate desc\n" +
            "        ",nativeQuery = true)
    List<ProductDetail> getAllByFilter(
            @Param("idcolor") Integer IdColor , @Param("idsize") Integer IdSize,
            @Param("idmaterial") Integer IdMaterial,@Param("idcategory") Integer IdCategory ,
            @Param("idbrand") Integer IdBrand ,@Param("idhandtype") Integer IdHandType,
            @Param("idnecktype") Integer IdNeckType,@Param("iddesign") Integer IdDesign,
            @Param("idpromotion") Integer IdPromotion,
            @Param("min") Double min ,@Param("max") Double max,
            @Param("soLuong") Integer soLuong,@Param("soLuong1") Integer soLuong1);



}
