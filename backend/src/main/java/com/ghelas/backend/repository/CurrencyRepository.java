package com.ghelas.backend.repository;

import com.ghelas.backend.model.entity.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {
}
