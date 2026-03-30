package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {

    private List<AddressBook> list = new ArrayList<>();
    private int counter = 1;

    // Create
    public AddressBook addContact(AddressBookDTO dto) {
        AddressBook contact = new AddressBook(
                counter++,
                dto.name,
                dto.address,
                dto.phone
        );
        list.add(contact);
        return contact;
    }

    // Get All
    public List<AddressBook> getAll() {
        return list;
    }

    // Get By ID
    public AddressBook getById(int id) {
        return list.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Update
    public AddressBook update(int id, AddressBookDTO dto) {
        AddressBook contact = getById(id);
        if (contact != null) {
            contact.setName(dto.name);
            contact.setAddress(dto.address);
            contact.setPhone(dto.phone);
        }
        return contact;
    }

    // Delete
    public boolean delete(int id) {
        return list.removeIf(c -> c.getId() == id);
    }
}