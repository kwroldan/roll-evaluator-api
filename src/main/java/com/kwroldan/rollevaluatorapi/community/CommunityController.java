package com.kwroldan.rollevaluatorapi.community;

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
@RequestMapping("api/community")
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<Community>> list() {
        Iterable<Community> communities = communityService.list();
        return createHashPlural(communities);
    }

    private Map<String, Iterable<Community>> createHashPlural(Iterable<Community> communities) {
        Map<String, Iterable<Community>> response = new HashMap<String, Iterable<Community>>();
        response.put("communities", communities);
        return response;
    }
}