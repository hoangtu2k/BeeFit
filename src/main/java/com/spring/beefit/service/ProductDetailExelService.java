package com.spring.beefit.service;

import com.spring.beefit.entity.*;
import com.spring.beefit.repository.*;
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

@Service
public class ProductDetailExelService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final ProductDetailMaterialRepository productDetailMaterialRepository;
    private final ProductDetailColorSizeRepository productDetailColorSizeRepository;

    public ProductDetailExelService(
            ProductRepository productRepository,
            ProductImageRepository productImageRepository,
            ProductDetailMaterialRepository productDetailMaterialRepository,
            ProductDetailColorSizeRepository productDetailColorSizeRepository
    ) {
        this.productRepository = productRepository;
        this.productImageRepository = productImageRepository;
        this.productDetailMaterialRepository = productDetailMaterialRepository;
        this.productDetailColorSizeRepository = productDetailColorSizeRepository;
    }

    public void importExel(MultipartFile file) throws IOException {
        try(InputStream inputStream =  file.getInputStream()){
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // get sheet đầu tiên
            for (Row row: sheet) {
                //Đọc dữ liệu từng hàng cho vào csdl
               if (row.getRowNum() > 0){
                   long timestamp = Instant.now().getEpochSecond();
                   String codeG = "SP" + timestamp;
                   String code = codeG;
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
                   product.setPrice(BigDecimal.valueOf(price));
                   product.setDescription(description);
                   product.setDiscount(dis);
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
}
