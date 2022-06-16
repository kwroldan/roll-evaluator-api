package com.kwroldan.rollevaluatorapi.pick;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickRepository extends CrudRepository<Pick, Long> {
}