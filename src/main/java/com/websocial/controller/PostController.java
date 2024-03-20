//package com.websocial.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin("*")
//@RequestMapping("/api/customers")
//public class CustomerController {
//    @Autowired
//    private CustomerService customerService;
//
//    @GetMapping()
//    public ResponseEntity<List<Customer>> findAll() {
//        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Customer> findById(@PathVariable Long id) {
//        return new ResponseEntity<>(customerService.findById(id),HttpStatus.OK);
//    }
//    @PostMapping("/{id}")
//    public ResponseEntity<?>save(@RequestBody Customer customer) {
//        customerService.save(customer);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?>delete(@PathVariable Long id) {
//        customerService.remove(id);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }
//}
