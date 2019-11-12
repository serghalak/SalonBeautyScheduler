package com.salon.repository.impl;


import com.salon.domain.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<Client,Long> {
}
