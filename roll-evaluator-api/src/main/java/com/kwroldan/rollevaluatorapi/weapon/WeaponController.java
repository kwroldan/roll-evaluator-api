package com.kwroldan.rollevaluatorapi.weapon;

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
@RequestMapping("api/some-resources")
public class WeaponController {
    @Autowired
    private WeaponService weaponService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<Weapon>> list() {
        Iterable<Weapon> weapons = weaponService.list();
        return createHashPlural(weapons);
    }

    private Map<String, Iterable<Weapon>> createHashPlural(Iterable<Weapon> weapons) {
        Map<String, Iterable<Weapon>> response = new HashMap<String, Iterable<Weapon>>();
        response.put("weapons", weapons);
        return response;
    }
}