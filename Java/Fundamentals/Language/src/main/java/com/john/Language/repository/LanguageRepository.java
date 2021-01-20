package com.john.Language.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.john.Language.models.Lang;

public interface LanguageRepository extends CrudRepository<Lang, Long>{
	 List<Lang> findAll();
	    // this method finds books with descriptions containing the search string
	Optional<Lang> findById(Long id);
	    
	 void deleteById(Long id);
}
