package com.gaurav.demo.repository;

public interface HashRepository {
    void put(String hash, String originalMessage);
    String get(String hash);
}
