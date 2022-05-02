package com.company.store.controller;

import com.company.store.entity.Product;
import com.company.store.service.ProductService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@ApiModel("Class to do requests at the database")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get/all")
    @ApiModelProperty("Method to get a list of all products")
    public ResponseEntity<List<Product>> findAll(){

        if(productService.findAll().size()>0){
            return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/get/{id}")
    @ApiModelProperty("Method to get a product by it id")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id){

        if(productService.findById(id)!=null){
            return new ResponseEntity<>(productService.findById(id),HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/save")
    @ApiModelProperty("Method to save a new product in the database")
    public ResponseEntity<Product> save(@RequestBody Product product){

        if(productService.findById(product.getId())!=null){//not exist the product
            return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiModelProperty("Method to delete a product by it id")
    public ResponseEntity delete(@PathVariable("id") Long id){
        if(productService.findById(id)!=null){//exist the product
            productService.delete(productService.findById(id));
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
