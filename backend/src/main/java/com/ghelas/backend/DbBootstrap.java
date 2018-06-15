package com.ghelas.backend;

import com.ghelas.backend.model.entity.Language;
import com.ghelas.backend.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbBootstrap implements CommandLineRunner {

    @Autowired
    LanguageRepository languageRepository;

    @Override
    public void run(String... args) throws Exception {
        languageRepository.save(new Language("ro", "ro_RO", "Română", true, true));
        languageRepository.save(new Language("en", "en_GB", "English", true, false));

    }
}
