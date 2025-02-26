package com.revature.ecomproject.controller;

import com.revature.ecomproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin(value="http://localhost:5173", allowCredentials = "false")
public class ProductController {

private ProductService productService;
@Autowired
public ProductController(ProductService productService){
  this.productService=productService;
}

// await for product entity, product DTO, product service
@PostMapping
public ResponseEntity<String> addProductHandler(@RequestBody String productToAdd){
  /*Optional<Product> productCreated=productService.addProduct(productToAdd);
  if (productCreated=.isPresent()){
    return ResponseEntity.status(HttpStatus.CREATED).body(productCreated=.get());
  }
  return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();*/
  return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
}

// await for productDTO and product service
@GetMapping
public ResponseEntity<String> getAllProductsHandler(){
 /* List<ProductDTO> emptyProduct=new ArrayList<>();
  Optional<List<OutGoingProductDTO>> productDTOList=productService.getAllProducts();
  if(productDTOList.isPresent()){
    return ResponseEntity.status(HttpStatus.OK).body(productDTOList.get());
  }*/
  return ResponseEntity.status(HttpStatus.OK).body("empty product list");
}

// await for product entity and product service
@GetMapping("/{productId}")
public ResponseEntity<String> getProductById(@PathVariable int productId){
 /* Optional<Product> productRetreived=productService.getProductById(productId);
  if(productRetreived.isPresent()){
    return ResponseEntity.status(HttpStatus.OK).body(productRetreived.get());
  }*/
  return ResponseEntity.status(HttpStatus.OK).body("product no found.");
}
@GetMapping("/categoryId")
  public ResponseEntity<List<String>> getAllProductByCategoryHandler(@PathVariable int categoryId){
    List<String> emptyProductByCategory=new ArrayList<>();
    /*Optional<List<OutGoingProductDTO>> productByCategoryList=productService.getAllProductByCategory(categoryId);

    if (productByCategoryList.isPresent()){
      return ResponseEntity.status(HttpStatus.OK).body(productByCategoryList.get());
    }*/
    return ResponseEntity.status(HttpStatus.OK).body(emptyProductByCategory);
  }

  // await for product DTO et service
  @PatchMapping
  public ResponseEntity<String> updateProduct(@RequestBody String ProductToUpdate){
   /* Optional<OutGoingProductDTO> productUpdated=productService.updateProduct(ProductToUpdate);
    if (productUpdated.isPresent()){
      return ResponseEntity.status(HttpStatus.OK).body(productUpdated.get());
    }*/
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<Void> deleteProduct(@PathVariable int productId){
   /* Optional<Integer> isdeleted=productService.deleteProduct(productId);
    if(isdeleted.isPresent()){
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }*/
    throw new IllegalArgumentException("product not found");
  }

}
