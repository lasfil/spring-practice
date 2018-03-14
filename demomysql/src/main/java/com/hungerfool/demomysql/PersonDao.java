package com.hungerfool.demomysql;

import java.util.List;  

import org.springframework.data.jpa.repository.JpaRepository;  
  
public interface PersonDao extends JpaRepository<Person, Long>{  
  
    List<Person> findByName(String name);  
} 
