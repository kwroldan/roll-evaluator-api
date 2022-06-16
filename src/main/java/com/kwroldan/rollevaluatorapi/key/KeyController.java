package com.kwroldan.rollevaluatorapi.key;

import java.util.Map;
import java.util.HashMap;

import com.kwroldan.rollevaluatorapi.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("api/abrakadabra/key")
public class KeyController {
    @Autowired
    private KeyService keyService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<Key>> list() {
        Iterable<Key> keys = keyService.list();
        return createHashPlural(keys);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Key> read(@PathVariable Long id) {
        Key key = keyService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));
        return createHashSingular(key);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Key> create(@Validated @RequestBody Key key) {
        Key createdKey = keyService.create(key);
        return createHashSingular(createdKey);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Key> update(@RequestBody Key key, @PathVariable Long id) {
        Key updatedKey = keyService
                .update(key)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));

        return createHashSingular(updatedKey);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        keyService.deleteById(id);
    }

    private Map<String, Key> createHashSingular(Key key) {
        Map<String, Key> response = new HashMap<String, Key>();
        response.put("key", key);

        return response;
    }

    private Map<String, Iterable<Key>> createHashPlural(Iterable<Key> keys) {
        Map<String, Iterable<Key>> response = new HashMap<String, Iterable<Key>>();
        response.put("keys", keys);

        return response;
    }
}
