package com.anabiozzze.aviasale.repos;

import com.anabiozzze.aviasale.domain.Client;
import org.springframework.data.repository.CrudRepository;

// репозиторий, который позволит выводить все поля или искать их по идентификатору
public interface ClientRepo extends CrudRepository<Client, Integer> {
}
