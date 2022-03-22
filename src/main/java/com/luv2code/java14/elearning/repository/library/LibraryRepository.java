package com.luv2code.java14.elearning.repository.library;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.java14.elearning.entity.library.Library;
import com.luv2code.java14.elearning.entity.library.LibraryKey;

public interface LibraryRepository extends JpaRepository<Library, LibraryKey>{

}
