package com.kwroldan.rollevaluatorapi.pick;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PickService {
    @Autowired
    private PickRepository pickRepository;

    public Iterable<Pick> list() {
        return pickRepository.findAll();
    }

    public Optional<Pick> findById(Long id) {
        return pickRepository.findById(id);
    }

    public Pick create(Pick pick) {
        return pickRepository.save(pick);
    }

    public Optional<Pick> update(Pick picks) {
        Optional<Pick> foundPick = pickRepository.findById(picks.getId());

        if (foundPick.isPresent()) {
            Pick updatedPicks = foundPick.get();
            updatedPicks.setName(picks.getName());
            updatedPicks.setImageUrl(picks.getImageUrl());
            updatedPicks.setFirstTrait(picks.getFirstTrait());
            updatedPicks.setSecondTrait(picks.getSecondTrait());
            updatedPicks.setComment(picks.getComment());

            pickRepository.save(updatedPicks);
            return Optional.of(updatedPicks);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        pickRepository.deleteById(id);
    }

}