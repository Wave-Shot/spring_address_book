package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.service.AddressBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    // Create
    @PostMapping("/create")
    public ResponseEntity<AddressBook> create(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.addContact(dto));
    }

    // Get All
    @GetMapping("/get")
    public ResponseEntity<List<AddressBook>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // Get by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBook> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBook> update(
            @PathVariable int id,
            @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean deleted = service.delete(id);
        return ResponseEntity.ok(deleted ? "Deleted" : "Not Found");
    }
}