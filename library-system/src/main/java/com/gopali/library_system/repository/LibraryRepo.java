package com.gopali.library_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gopali.library_system.model.Book;

@Repository
public interface LibraryRepo extends JpaRepository<Book, Integer>{
    
}
