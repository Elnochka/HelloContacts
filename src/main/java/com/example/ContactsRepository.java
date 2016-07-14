package com.example;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * Created by Elena on 03.07.2016.
 */
public interface ContactsRepository extends JpaRepository<Contacts, Long> {

    List<Contacts> findByNameNotLike(String name);
    List<Contacts> findByNameNotContaining(String name);

}
