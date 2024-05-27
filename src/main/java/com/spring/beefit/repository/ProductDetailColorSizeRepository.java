package com.spring.beefit.repository;

import com.spring.beefit.entity.ProductdetailColorSize;
import com.spring.beefit.viewmodel.response.ProductDetailResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailColorSizeRepository extends JpaRepository<ProductdetailColorSize, Integer> {

    @Query(value = "Select e from ProductdetailColorSize  e where  e.product.id =:id")
    List<ProductdetailColorSize> getAllById(@Param("id") Integer id);

    @Query(value = "Select p from ProductdetailColorSize p \n" +
            "where p.product.id = :idProduct and p.color.id = :idColor")
    List<ProductdetailColorSize> getAllByIdProductAndIdColor(@Param("idProduct") Integer IdProduct, @Param(("idColor")) Integer IdColor);

    @Query(value = "Select SUM(p.quantity) from ProductdetailColorSize p\n" +
            "where p.product.id = :id")
    Integer getQuantityByProduct(@Param("id") Integer id);

    @Query(value = "Select SUM(p.quantity) from ProductdetailColorSize p\n" +
            "where p.product.id = :id and p.color.id = :idcolor")
    Integer getQuantityByProductAndColor(@Param("id") Integer id,@Param("idcolor") Integer idcolor);

    @Query(value = "Select SUM(p.quantity) from ProductdetailColorSize p\n" +
            "where p.product.id = :id and p.color.id = :idcolor and p.size.id = :idsize and p.product.status = 0")
    Integer getQuantityByProductAndColorAndSize(@Param("id") Integer id,@Param("idcolor") Integer idcolor,@Param("idsize") Integer idsize);

    @Query(value = "Select p from ProductdetailColorSize p\n" +
            "where p.product.id = :id and p.color.id = :idcolor and p.size.id = :idsize")
    ProductdetailColorSize getByProductAndColorAndSize(@Param("id") Integer id,@Param("idcolor") Integer idcolor,@Param("idsize") Integer idsize);

    @Query(value = "Select p.Id,p.IdProduct,p.IdColor,p.IdSize,p.Quantity from ProductDetail_Color_Size p \n" +
            " join Product c on p.IdProduct = c.Id\n" +
            " where c.status = 0 order by c.createDate desc", nativeQuery = true)
    List<ProductDetailResponse> getAll();

    @Query(value = "Select p.Id,p.IdProduct,p.IdColor,p.IdSize,p.Quantity from ProductDetail_Color_Size p \n" +
            " join Product c on p.IdProduct = c.Id\n" +
            " where c.Status = 0 and p.Id = :id order by c.CreateDate desc", nativeQuery = true)
    ProductDetailResponse getByIdd(@Param("id") Integer id);

    @Query(value = "select p.Id,p.IdProduct,p.IdColor,p.IdSize,p.Quantity \n" +
            "from ProductDetail_Color_Size p\n" +
            "            join Product c on p.IdProduct = c.Id\n" +
            "where c.Status = 0 and (c.Code like :keyword or c.Name like :keyword or :keyword is null) \n" +
            "\t\t\t\t\tand (p.IdColor = :idColor or :idColor is null) \n" +
            "\t\t\t\t\tand (p.IdSize = :idSize or :idSize is null)  order by c.CreateDate asc", nativeQuery = true)
    List<ProductDetailResponse> getAllByNameAndCodeProduct(@Param("keyword") String keyword,@Param("idColor") Integer idColor , @Param("idSize") Integer idSize);

    @Query(value = "Select p.Id,p.IdProduct,p.IdColor,p.IdSize,p.Quantity from ProductDetail_Color_Size p \n" +
            "join Product c on p.IdProduct = c.Id where c.Id = :id", nativeQuery = true)
    List<ProductDetailResponse> getByProduct(@Param("id") Integer id);



}
