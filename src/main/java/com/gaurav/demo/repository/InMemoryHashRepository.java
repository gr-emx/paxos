package com.gaurav.demo.repository;

import com.gaurav.demo.repository.HashRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
@Profile("InMemory")
public class InMemoryHashRepository implements HashRepository {

    public Map<String, String> hashes = new LinkedHashMap<>();

    @Override
    public void put(String hash, String originalMessage) {
        hashes.put(hash,originalMessage);

    }

    @Override
    public String get(String hash) {
        return hashes.get(hash);
    }
}
