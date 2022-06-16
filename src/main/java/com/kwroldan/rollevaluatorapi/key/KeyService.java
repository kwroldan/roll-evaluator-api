package com.kwroldan.rollevaluatorapi.key;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyService {
    @Autowired
    private KeyRepository keyRepository;

    public Iterable<Key> list() {
        return keyRepository.findAll();
    }

    public Optional<Key> findById(Long id) {
        return keyRepository.findById(id);
    }

    public Key create(Key key) {
        return keyRepository.save(key);
    }

    public Optional<Key> update(Key keys) {
        Optional<Key> foundKey = keyRepository.findById(keys.getId());

        if (foundKey.isPresent()) {
            Key updatedKeys = foundKey.get();
            updatedKeys.setKey(keys.getKey());

            keyRepository.save(updatedKeys);
            return Optional.of(updatedKeys);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        keyRepository.deleteById(id);
    }

}