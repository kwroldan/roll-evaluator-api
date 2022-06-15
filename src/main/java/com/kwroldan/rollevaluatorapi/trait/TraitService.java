package com.kwroldan.rollevaluatorapi.trait;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraitService {
    @Autowired
    private TraitRepository traitRepository;

    public Iterable<Trait> list() {
        return traitRepository.findAll();
    }

    public Optional<Trait> findById(Long id) {
        return traitRepository.findById(id);
    }

    public Trait create(Trait trait) {
        return traitRepository.save(trait);
    }

    public Optional<Trait> traits(Trait traits) {
        Optional<Trait> foundTrait = traitRepository.findById(traits.getId());

        if (foundTrait.isPresent()) {
            Trait updatedTraits = foundTrait.get();
            updatedTraits.setName(traits.getName());
            updatedTraits.setPveRating(traits.getPveRating());
            updatedTraits.setPvpRating(traits.getPvpRating());

            traitRepository.save(updatedTraits);
            return Optional.of(updatedTraits);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        traitRepository.deleteById(id);
    }

}