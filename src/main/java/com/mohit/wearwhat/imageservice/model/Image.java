package com.mohit.wearwhat.imageservice.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "images")
public class Image {
	@Id
    private String id;
     
    private String garmentId;
         
    private Binary image;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGarmentId() {
		return garmentId;
	}

	public void setGarmentId(String garmentId) {
		this.garmentId = garmentId;
	}

	public Binary getImage() {
		return image;
	}

	public void setImage(Binary image) {
		this.image = image;
	}
    
}
