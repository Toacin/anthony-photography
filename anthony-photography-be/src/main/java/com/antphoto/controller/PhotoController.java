package com.antphoto.controller;

import com.antphoto.model.Photo;
import com.antphoto.repository.PhotoRepository;
import com.antphoto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotoController {
    @Autowired
    PhotoRepository repository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/photos")
    public List<Photo> getAllPhotos() {
        List<Photo> photoList = repository.findAll();
        return photoList;
    }

    @GetMapping("/api/photos/{id}")
    public Photo getOnePhoto(@PathVariable Integer id){
        Photo photo = repository.getReferenceById(id);
        return photo;
    }

    @GetMapping("/api/photos/user/{userId}")
    public List<Photo> getUserPhotos(@PathVariable Integer userId){
        List<Photo> photos = repository.getPhotosByUserId(userId);
        return photos;
    }


}
