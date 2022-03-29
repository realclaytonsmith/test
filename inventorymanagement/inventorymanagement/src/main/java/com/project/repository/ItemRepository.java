package com.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
