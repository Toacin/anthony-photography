package com.antphoto.controller;

import com.antphoto.model.Photo;
import com.antphoto.repository.PhotoRepository;
import com.antphoto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/api/photos")
    public Photo createPhoto(@RequestBody Photo photo){
        Photo newPhoto = repository.save(photo);
        return newPhoto;
    }

    @PutMapping("/api/photos/{id}")
    public Photo updatePhoto(@RequestBody Photo photo, @PathVariable Integer id){
        Photo updatedPhoto = repository.getReferenceById(id);
        photo.setId(updatedPhoto.getId());
        repository.save(photo);
        return photo;
    }


}
