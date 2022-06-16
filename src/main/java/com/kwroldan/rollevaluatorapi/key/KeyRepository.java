package com.kwroldan.rollevaluatorapi.key;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyRepository extends CrudRepository<Key, Long> {
}