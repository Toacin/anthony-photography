package com.antphoto.controller;

import com.antphoto.model.Photo;
import com.antphoto.model.Tag;
import com.antphoto.repository.PhotoRepository;
import com.antphoto.repository.TagsRepository;
import com.antphoto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhotoController {
    @Autowired
    PhotoRepository repository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TagsRepository tagsRepository;

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

    @GetMapping("/api/photos/category/{categoryId}")
    public List<Photo> getCategoryPhotos(@PathVariable Integer categoryId) {
        List<Photo> photos = repository.getPhotosByCategoryId(categoryId);
        return photos;
    }

    @PutMapping("/api/photos/tags/{photoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addTagsToPhoto(@PathVariable Integer photoId, @RequestBody int[] arrayOfTagIds) {
        System.out.println("made to photo tag method");
        for (int i=0; i<arrayOfTagIds.length; i++) {
            tagsRepository.addTagsToPhoto(photoId, arrayOfTagIds[i]);
        }
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

    @DeleteMapping("/api/photos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePhoto(@PathVariable Integer photoId) {
        repository.deleteById(photoId);
    }
}
