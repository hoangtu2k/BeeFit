package com.spring.beefit.service;

import com.spring.beefit.entity.*;
import com.spring.beefit.repository.*;
import com.spring.beefit.viewmodel.request.AttributesRequest;
import com.spring.beefit.viewmodel.request.ProductReq;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    // add thuoc tinh san pham
    public Design addDesign(AttributesRequest request){
        Design design = new Design();
        design.setName(request.getName());
        design.setCreateDate(new Date());
        design.setStatus(0);
        return designRepository.save(design);
    }
    public Brand addBrand(AttributesRequest request){
        Brand brand = new Brand();
        brand.setName(request.getName());
        brand.setCreateDate(new Date());
        brand.setStatus(0);
        return brandRepository.save(brand);
    }
    public Category addCategory(AttributesRequest request){
        Category category = new Category();
        category.setName(request.getName());
        category.setCreateDate(new Date());
        category.setStatus(0);
        return categoryRepository.save(category);
    }
    public HandType addHandType(AttributesRequest request){
        HandType handType = new HandType();
        handType.setName(request.getName());
        handType.setCreateDate(new Date());
        handType.setStatus(0);
        return handTypeRepository.save(handType);
    }
    public NeckType addNeckType(AttributesRequest request){
        NeckType neckType = new NeckType();
        neckType.setName(request.getName());
        neckType.setCreateDate(new Date());
        neckType.setStatus(0);
        return neckTypeRepository.save(neckType);
    }
    // update thuoc tinh san pham
    public Design updateDesign(Integer Id,AttributesRequest request){
        Design design = designRepository.getById(Id);
        design.setName(request.getName());
        design.setUpdateDate(new Date());
        return designRepository.save(design);
    }
    public Brand updateBrand(Integer Id,AttributesRequest request){
        Brand brand = brandRepository.getById(Id);
        brand.setName(request.getName());
        brand.setUpdateDate(new Date());
        return brandRepository.save(brand);
    }
    public Category updateCategory(Integer Id,AttributesRequest request){
        Category category = categoryRepository.getById(Id);
        category.setName(request.getName());
        category.setUpdateDate(new Date());
        return categoryRepository.save(category);
    }
    public HandType updateHandType(Integer Id,AttributesRequest request){
        HandType handType = handTypeRepository.getById(Id);
        handType.setName(request.getName());
        handType.setUpdateDate(new Date());
        return handTypeRepository.save(handType);
    }
    public NeckType updateNeckType(Integer Id,AttributesRequest request){
        NeckType neckType = neckTypeRepository.getById(Id);
        neckType.setName(request.getName());
        neckType.setUpdateDate(new Date());
        return neckTypeRepository.save(neckType);
    }
    ////////////////////////////////////////////////////////////////////////////////
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public List<Product> getAll() {
        return productRepository.getAll();
    }
    public List<Product> getAll1() {
        return productRepository.getAll1();
    }
    public Integer quantitySold(@Param("id") Integer id){
        return productRepository.quantitySold(id);
    }
    public Double totalSold(@Param("id") Integer id){
        return productRepository.totalSale(id);
    }
    public Product getById(Integer id){
        Product product = productRepository.getById(id);
        return product;
    }
    public Product addProduct(ProductReq request) {
        Product product = new Product();
        product.setCode(genCode());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setWeight(request.getWeight());
        product.setDiscount(request.getDiscount());
        product.setDiscountDate(request.getDiscountDate());
        product.setDescription(request.getDescription());
        product.setCreateBy(request.getCreateBy());
        // Xử lý trường idBrand có thể là null
        if (request.getIdBrand() != null) {
            product.setBrand(Brand.builder().id(request.getIdBrand()).build());
        } else {
            product.setBrand(null);
        }
        product.setCategory(Category.builder().id(request.getIdCategory()).build());
        product.setDesign(Design.builder().id(request.getIdDesign()).build());
        product.setHandType(HandType.builder().id(request.getIdHandType()).build());
        product.setNeckType(NeckType.builder().id(request.getIdNeckType()).build());
        product.setCreateDate(new Date());
        product.setStatus(0);
        return productRepository.save(product);
    }
    public Product updateProduct(Integer id, ProductReq request){
        Product product = productRepository.getById(id);
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setWeight(request.getWeight());
        product.setDiscount(request.getDiscount());
        product.setDiscountDate(request.getDiscountDate());
        product.setDescription(request.getDescription());
        product.setUpdateBy(request.getUpdateBy());
        // Xử lý trường idBrand có thể là null
        if (request.getIdBrand() != null) {
            product.setBrand(Brand.builder().id(request.getIdBrand()).build());
        } else {
            product.setBrand(null);
        }
        product.setCategory(Category.builder().id(request.getIdCategory()).build());
        product.setDesign(Design.builder().id(request.getIdDesign()).build());
        product.setHandType(HandType.builder().id(request.getIdHandType()).build());
        product.setNeckType(NeckType.builder().id(request.getIdNeckType()).build());
        product.setUpdateDate(new Date());
        return productRepository.save(product);
    }
    public Product delete(Integer IdProduct){
        Product p = productRepository.getById(IdProduct);
        p.setStatus(1);
        return productRepository.save(p);
    }
    public Product khoiphucDelete(Integer IdProduct){
        Product p = productRepository.getById(IdProduct);
        p.setStatus(0);
        return productRepository.save(p);
    }
    public Product getByCode(String code){
        return productRepository.getByCode(code);
    }
    public String genCode() {
        // Tạo đối tượng Random
        long timestamp = Instant.now().getEpochSecond();
        String code = "SP" + timestamp;
        return code;
    }
    public ProductImage addImage(ProductReq image){
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
                    Double weight = row.getCell(3).getNumericCellValue();
                    Double discount = row.getCell(4).getNumericCellValue();
                    Integer dis = discount.intValue();
                    String description = row.getCell(5).getStringCellValue();
                    Double category = row.getCell(6).getNumericCellValue();
                    Integer idcate = category.intValue();
                    Double brand = row.getCell(7).getNumericCellValue();
                    Integer idbrand = brand.intValue();
                    Double design = row.getCell(8).getNumericCellValue();
                    Integer iddesign = design.intValue();
                    Double handType = row.getCell(9).getNumericCellValue();
                    Integer idhandtype = handType.intValue();
                    Double necktype = row.getCell(10).getNumericCellValue();
                    Integer idnecktype = necktype.intValue();
                    String materials = row.getCell(11).getStringCellValue();
                    String [] mate = materials.split(",");
                    String color_size_quanity = row.getCell(12).getStringCellValue();
                    String [] color_size = color_size_quanity.split(",");
                    Product product = new Product();
                    product.setCode(code);
                    product.setName(name);
                    product.setPrice(BigDecimal.valueOf(price));
                    product.setWeight(weight);
                    product.setDiscount(dis);
                    product.setDescription(description);
                    product.setCategory(Category.builder().id(idcate).build());
                    product.setBrand(Brand.builder().id(idbrand).build());
                    product.setDesign(Design.builder().id(iddesign).build());
                    product.setHandType(HandType.builder().id(idhandtype).build());
                    product.setNeckType(NeckType.builder().id(idnecktype).build());
                    product.setStatus(0);
                    product.setCreateDate(new Date());
                    productRepository.save(product);
                    ProductImage productImage = new ProductImage();
                    productImage.setStatus(0);
                    productImage.setMainImage(true);
                    productImage.setUrl(url);
                    productImage.setProduct(Product.builder().id(product.getId()).build());
                    productImageRepository.save(productImage);

                    for (String material:mate) {
                        ProductdetailMaterial productdetailMaterial = new ProductdetailMaterial();
                        productdetailMaterial.setProduct(Product.builder().id(product.getId()).build());
                        productdetailMaterial.setMaterial(Material.builder().id(Integer.parseInt(material)).build());
                        productDetailMaterialRepository.save(productdetailMaterial);
                    }
                    for (String color_size_quantity :color_size) {
                        String [] mang = color_size_quantity.split("-");
                        ProductdetailColorSize productdetailColorSize = new ProductdetailColorSize();
                        productdetailColorSize.setProduct(Product.builder().id(product.getId()).build());
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

    public List<Product> getAllBanChay(){
        return productRepository.getAllBanChay();
    }

    public List<Product> getAllbyFilter(
            Integer IdColor,Integer IdSize,Integer IdMaterial,
            Integer IdCategory, Integer IdBrand , Integer IdHandType,
            Integer IdNeckType, Integer IdDesign,
            Double min ,Double max ,
            Integer soLuong,Integer soLuong1
    ){
        return productRepository.getAllByFilter(IdColor,IdSize,IdMaterial,IdCategory,IdBrand, IdHandType,IdNeckType,IdDesign,min,max,soLuong,soLuong1);
    }

}
