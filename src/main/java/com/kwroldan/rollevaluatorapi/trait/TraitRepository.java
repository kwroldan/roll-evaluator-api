package com.kwroldan.rollevaluatorapi.trait;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraitRepository extends CrudRepository<Trait, Long> {
}