package com.spring.beefit.service;

import com.spring.beefit.entity.*;
import com.spring.beefit.repository.*;
import com.spring.beefit.viewmodel.request.ProductDetailReq;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class ProductDetailService {

    @Autowired
    private DesignRepository designRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private HandTypeRepository handTypeRepository;
    @Autowired
    private NeckTypeRepository neckTypeRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private ProductDetailMaterialRepository productDetailMaterialRepository;
    @Autowired
    private ProductDetailColorSizeRepository productDetailColorSizeRepository;

    // load data thuoc tinh san pham
    public List<Design> getAllDesigns() {
        return designRepository.getAll();
    }
    public List<Brand> getAllBrands() {
        return brandRepository.getAll();
    }
    public List<Category> getAllCategories() {
        return categoryRepository.getAll();
    }
    public List<HandType> getAllHandTypes() {
        return handTypeRepository.getAll();
    }
    public List<NeckType> getAllNeckTypes() {
        return neckTypeRepository.getAll();
    }

    public List<ProductDetail> findAll() {
        return productDetailRepository.findAll();
    }

    public List<ProductDetail> getAll() {
        return productDetailRepository.getAll();
    }

    public List<ProductDetail> getAll1() {
        return productDetailRepository.getAll1();
    }

    public ProductDetail getById(Integer id){
        ProductDetail productDetail = productDetailRepository.getById(id);
        return productDetail;
    }

    public ProductDetail add(ProductDetailReq request) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setPrice(request.getPrice());
        productDetail.setDiscount(request.getDiscount());
        productDetail.setDescription(request.getDescription());
        productDetail.setProduct(Product.builder().id(request.getIdProduct()).build());
        productDetail.setBrand(Brand.builder().id(request.getIdBrand()).build());
        productDetail.setCategory(Category.builder().id(request.getIdCategory()).build());
        productDetail.setDesign(Design.builder().id(request.getIdDesign()).build());
        productDetail.setHandType(HandType.builder().id(request.getIdHandType()).build());
        productDetail.setNeckType(NeckType.builder().id(request.getIdNeckType()).build());
        productDetail.setDiscountDate(request.getDiscountDate());
        productDetail.setCreateDate(new Date());
        productDetail.setStatus(0);
        return productDetailRepository.save(productDetail);
    }

    public ProductDetail update(Integer id,ProductDetailReq request){
        ProductDetail productDetail = productDetailRepository.getById(id);
        productDetail.setPrice(request.getPrice());
        productDetail.setDiscount(request.getDiscount());
        productDetail.setDescription(request.getDescription());
        productDetail.setBrand(Brand.builder().id(request.getIdBrand()).build());
        productDetail.setCategory(Category.builder().id(request.getIdCategory()).build());
        productDetail.setDesign(Design.builder().id(request.getIdDesign()).build());
        productDetail.setHandType(HandType.builder().id(request.getIdHandType()).build());
        productDetail.setNeckType(NeckType.builder().id(request.getIdNeckType()).build());
        productDetail.setDiscountDate(request.getDiscountDate());
        productDetail.setUpdateDate(new Date());
        return productDetailRepository.save(productDetail);
    }

    public ProductDetail delete(Integer IdProductDetail){
        ProductDetail p = productDetailRepository.getById(IdProductDetail);
        p.setStatus(1);
        return productDetailRepository.save(p);
    }

    public ProductDetail khoiphucDelete(Integer IdProductDetail){
        ProductDetail p = productDetailRepository.getById(IdProductDetail);
        p.setStatus(0);
        return productDetailRepository.save(p);
    }

    public ProductDetail getByCode(String code){
        return productDetailRepository.getByCode(code);
    }

    public String genCode() {
        // Tạo đối tượng Random
        long timestamp = Instant.now().getEpochSecond();
        String code = "SP" + timestamp;
        return code;
    }

    public Product addProduct(ProductDetailReq request){
        Product product = new Product();
        product.setCode(genCode());
        product.setName(request.getName());
        product.setCreateDate(new Date());
        product.setStatus(0);
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, ProductDetailReq request){
        Product product = productRepository.getById(id);
        product.setName(request.getName());
        product.setUpdateDate(new Date());
        return productRepository.save(product);
    }

    public void importExel(MultipartFile file) throws IOException {
        try(InputStream inputStream =  file.getInputStream()){
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // get sheet đầu tiên
            for (Row row: sheet) {
                //Đọc dữ liệu từng hàng cho vào csdl
                if (row.getRowNum() > 0){
                    String code = genCode();
                    String name = row.getCell(0).getStringCellValue();
                    String url = row.getCell(1).getStringCellValue();
                    Double price = row.getCell(2).getNumericCellValue();
                    String description = row.getCell(3).getStringCellValue();
                    Double discount = row.getCell(4).getNumericCellValue();
                    Integer dis = discount.intValue();
                    Double category = row.getCell(5).getNumericCellValue();
                    Integer idcate = category.intValue();
                    Double brand = row.getCell(6).getNumericCellValue();
                    Integer idbrand = brand.intValue();
                    Double design = row.getCell(7).getNumericCellValue();
                    Integer iddesign = design.intValue();
                    Double handType = row.getCell(8).getNumericCellValue();
                    Integer idhandtype = handType.intValue();
                    Double necktype = row.getCell(9).getNumericCellValue();
                    Integer idnecktype = necktype.intValue();
                    String materials = row.getCell(10).getStringCellValue();
                    String [] mate = materials.split(",");
                    String color_size_quanity = row.getCell(11).getStringCellValue();
                    String [] color_size = color_size_quanity.split(",");
                    Product product = new Product();
                    product.setCode(code);
                    product.setName(name);
                    product.setStatus(0);
                    product.setCreateDate(new Date());
                    productRepository.save(product);
                    ProductImage productImage = new ProductImage();
                    productImage.setStatus(0);
                    productImage.setMainImage(true);
                    productImage.setUrl(url);
                    productImage.setProduct(Product.builder().id(product.getId()).build());
                    productImageRepository.save(productImage);
                    ProductDetail productDetail = new ProductDetail();
                    productDetail.setPrice(BigDecimal.valueOf(price));
                    productDetail.setDescription(description);
                    productDetail.setDiscount(dis);
                    productDetail.setProduct(Product.builder().id(product.getId()).build());
                    productDetail.setCategory(Category.builder().id(idcate).build());
                    productDetail.setBrand(Brand.builder().id(idbrand).build());
                    productDetail.setDesign(Design.builder().id(iddesign).build());
                    productDetail.setHandType(HandType.builder().id(idhandtype).build());
                    productDetail.setNeckType(NeckType.builder().id(idnecktype).build());
                    productDetail.setStatus(0);
                    productDetail.setCreateDate(new Date());
                    productDetailRepository.save(productDetail);
                    for (String material:mate) {
                        ProductdetailMaterial productdetailMaterial = new ProductdetailMaterial();
                        productdetailMaterial.setProductDetail(ProductDetail.builder().id(productDetail.getId()).build());
                        productdetailMaterial.setMaterial(Material.builder().id(Integer.parseInt(material)).build());
                        productDetailMaterialRepository.save(productdetailMaterial);
                    }
                    for (String color_size_quantity :color_size) {
                        String [] mang = color_size_quantity.split("-");
                        ProductdetailColorSize productdetailColorSize = new ProductdetailColorSize();
                        productdetailColorSize.setProductDetail(ProductDetail.builder().id(productDetail.getId()).build());
                        productdetailColorSize.setSize(Size.builder().id(Integer.parseInt(mang[1])).build());
                        productdetailColorSize.setColor(Color.builder().id(Integer.parseInt(mang[0])).build());
                        productdetailColorSize.setQuantity(Integer.parseInt(mang[2]));
                        productDetailColorSizeRepository.save(productdetailColorSize);
                    }
                }
            }
            workbook.close();
            inputStream.close();
        }
    }

    public ProductImage addImage(ProductDetailReq image){
        ProductImage productImage = new ProductImage();
        productImage.setUrl(image.getUrl());
        productImage.setMainImage(image.getMainImage());
        productImage.setProduct(Product.builder().id(image.getIdProduct()).build());
        productImage.setCreateDate(new Date());
        productImage.setStatus(0);
        return productImageRepository.save(productImage);
    }
    public void deleteImg(Integer IdProduct){
        List<ProductImage> list = productImageRepository.getAllByIdSP(IdProduct);
        for(ProductImage p : list){
            productImageRepository.delete(p);
        }
    }
    public void delete1(Integer IdProduct){
        List<ProductImage> list = productImageRepository.getAllByIdSP1(IdProduct);
        for(ProductImage p : list){
            productImageRepository.delete(p);
        }
    }

    public List<ProductDetail> getAllbyFilter(
            Integer IdColor,Integer IdSize,Integer IdMaterial,
            Integer IdCategory, Integer IdBrand , Integer IdHandType,Integer IdNeckType, Integer IdDesign,Double min ,Double max ,Integer soLuong,Integer soLuong1){
        return productDetailRepository.getAllByFilter(IdColor,IdSize,IdMaterial,IdCategory,IdBrand, IdHandType,IdNeckType,IdDesign,min,max,soLuong,soLuong1);
    }


}
