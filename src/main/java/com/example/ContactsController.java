package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Elena on 03.07.2016.
 */

@RestController
public class ContactsController {
    @Autowired
    private ContactsRepository repository;

    @RequestMapping("/contacts/read")
    @ResponseBody
    public List<Contacts> readContact() {
        List<Contacts> list = new CopyOnWriteArrayList<Contacts>();

        Iterable<Contacts> contact = repository.findAll();
        for (Contacts customer : contact) {
            list.add(customer);
        }
        return list;

    }

    @RequestMapping(value="/contacts")
    @ResponseBody
    public List<Contacts> filtrContact(@RequestParam(value="nameFilter", required=false) String nameFilter) {

        List<Contacts> contact = repository.findByNameNotContaining(nameFilter);

        return contact;
    }
}
