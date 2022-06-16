package com.kwroldan.rollevaluatorapi.pick;

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
@RequestMapping("api/community-picks")
public class PickController {
    @Autowired
    private PickService pickService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<Pick>> list() {
        Iterable<Pick> picks = pickService.list();
        return createHashPlural(picks);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Pick> read(@PathVariable Long id) {
        Pick pick = pickService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));
        return createHashSingular(pick);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Pick> create(@Validated @RequestBody Pick pick) {
        Pick createdPick = pickService.create(pick);
        return createHashSingular(createdPick);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Pick> update(@RequestBody Pick pick, @PathVariable Long id) {
        Pick updatedPick = pickService
                .update(pick)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));

        return createHashSingular(updatedPick);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        pickService.deleteById(id);
    }

    private Map<String, Pick> createHashSingular(Pick pick) {
        Map<String, Pick> response = new HashMap<String, Pick>();
        response.put("pick", pick);

        return response;
    }

    private Map<String, Iterable<Pick>> createHashPlural(Iterable<Pick> picks) {
        Map<String, Iterable<Pick>> response = new HashMap<String, Iterable<Pick>>();
        response.put("picks", picks);

        return response;
    }
}
