package com.kwroldan.rollevaluatorapi.weapon;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponService {
    @Autowired
    private WeaponRepository weaponRepository;

    public Iterable<Weapon> list() {
        return weaponRepository.findAll();
    }

    public Optional<Weapon> findById(Long id) {
        return weaponRepository.findById(id);
    }

    public Weapon create(Weapon weapon) {
        return weaponRepository.save(weapon);
    }

    public Optional<Weapon> update(Weapon weapons) {
        Optional<Weapon> foundWeapon = weaponRepository.findById(weapons.getId());

        if (foundWeapon.isPresent()) {
            Weapon updatedWeapons = foundWeapon.get();
            updatedWeapons.setName(weapons.getName());
            updatedWeapons.setImageUrl(weapons.getImageUrl());

            weaponRepository.save(updatedWeapons);
            return Optional.of(updatedWeapons);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        weaponRepository.deleteById(id);
    }

}