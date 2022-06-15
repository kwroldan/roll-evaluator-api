package com.kwroldan.rollevaluatorapi.trait;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("api/traits")
public class TraitController {
    @Autowired
    private TraitService traitService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<Trait>> list() {
        Iterable<Trait> traits = traitService.list();
        return createHashPlural(traits);
    }

    private Map<String, Iterable<Trait>> createHashPlural(Iterable<Trait> traits) {
        Map<String, Iterable<Trait>> response = new HashMap<String, Iterable<Trait>>();
        response.put("traits", traits);
        return response;
    }
}