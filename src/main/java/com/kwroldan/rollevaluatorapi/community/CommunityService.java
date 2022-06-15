package com.kwroldan.rollevaluatorapi.community;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {
    @Autowired
    private CommunityRepository communityRepository;

    public Iterable<Community> list() {
        return communityRepository.findAll();
    }

    public Optional<Community> findById(Long id) {
        return communityRepository.findById(id);
    }

    public Community create(Community community) {
        return communityRepository.save(community);
    }

    public Optional<Community> communities(Community communities) {
        Optional<Community> foundCommunity = communityRepository.findById(communities.getId());

        if (foundCommunity.isPresent()) {
            Community updatedCommunities = foundCommunity.get();
            updatedCommunities.setName(communities.getName());
            updatedCommunities.setImageUrl(communities.getImageUrl());
            updatedCommunities.setFirstTrait(communities.getFirstTrait());
            updatedCommunities.setSecondTrait(communities.getSecondTrait());
            updatedCommunities.setComment(communities.getComment());

            communityRepository.save(updatedCommunities);
            return Optional.of(updatedCommunities);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        communityRepository.deleteById(id);
    }

}