package com.mohit.wearwhat.imageservice.controller;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mohit.wearwhat.imageservice.model.Image;
import com.mohit.wearwhat.imageservice.repository.ImageRepository;

@RestController
@RequestMapping("/images")
public class ImageController {

	@Autowired ImageRepository imageRepository;

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
	public String addImage(@RequestParam(value = "garmentId") String garmentId, MultipartFile file) throws IOException {
		Image image = new Image();
		image.setGarmentId(garmentId);
		image.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		image = imageRepository.save(image);
		return image.getId();
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET )
	public ResponseEntity<Object> getImage(@RequestParam(value = "name") String id) {
		Image image = imageRepository.findById(id).get();
		return ResponseEntity.ok().body(image);
	}
}
