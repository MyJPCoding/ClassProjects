package com.john.Language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.john.Language.models.Lang;
import com.john.Language.repository.LanguageRepository;

@Service
public class LangService {
	
private final LanguageRepository languageRepository;
    
    public LangService(LanguageRepository bookRepository) {
        this.languageRepository = bookRepository;
    }
    // returns all the books
    public List<Lang> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a book
    public Lang createLanguage(Lang b) {
        return languageRepository.save(b);
    }
    // retrieves a book
    public Lang findLanguage(Long id) {
        Optional<Lang> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);    
    }
    
    public Lang updateLanguage(Long id, String name, String creator, String currentVersion) {
    	Lang language = new Lang( name, creator, currentVersion);
    	language.setId(id);
        return languageRepository.save(language); 

    }
}
