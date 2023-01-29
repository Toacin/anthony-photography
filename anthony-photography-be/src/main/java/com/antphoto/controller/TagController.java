package com.antphoto.controller;

import com.antphoto.model.Tag;
import com.antphoto.repository.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {
    @Autowired
    TagsRepository repository;

    @GetMapping("/api/tags")
    public List<Tag> getAllTags() {
        List<Tag> tags = repository.findAll();
        return tags;
    }

    @GetMapping("/api/tags/{id}")
    public Tag getSingleTag(@PathVariable Integer id) {
        Tag tag = repository.getReferenceById(id);
        return tag;
    }

    @GetMapping("/api/tags/category/{categoryId}")
    public List<Tag> getTagByCategoryId(@PathVariable Integer categoryId) {
        List<Tag> tags = repository.findAllByCategoryId(categoryId);
        return tags;
    }

    @PostMapping("/api/tags")
    public Tag addTag(@RequestBody Tag requestTag) {
        Tag newTag = repository.save(requestTag);
        return newTag;
    }

    @PutMapping("/api/tags/{id}")
    public Tag updateTag(@RequestBody Tag updatedTag, @PathVariable Integer id) {
        Tag tempTag = repository.getReferenceById(id);
        updatedTag.setId(tempTag.getId());
        repository.save(updatedTag);
        return updatedTag;
    }

    @DeleteMapping("/api/tags/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTag(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
