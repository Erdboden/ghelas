package com.ghelas.backend.repository;

import com.ghelas.backend.model.entity.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language, Long> {
}
