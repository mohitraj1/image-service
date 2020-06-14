package com.mohit.wearwhat.imageservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mohit.wearwhat.imageservice.model.Image;

public interface ImageRepository extends MongoRepository<Image, String>{

}
