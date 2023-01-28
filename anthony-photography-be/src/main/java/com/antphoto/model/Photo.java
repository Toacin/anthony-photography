package com.antphoto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "photo")
public class Photo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double price;


    @Lob
    @Column(length = 100000)
    private byte[] image;

    @ManyToMany(mappedBy = "photos", fetch = FetchType.LAZY)
    private List<User> users;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PHOTO_TAG",
            joinColumns = @JoinColumn(name = "photoId"),
            inverseJoinColumns = @JoinColumn(name = "tagId")
    )
    private List<Tag> tags;

    @OneToOne(fetch = FetchType.LAZY)
    private Photo highResPhotoId;

    private Integer categoryId;

    public Photo() {
    }

    public Photo(Integer id, Double price, byte[] image, Photo highResPhotoId, Integer categoryId) {
        this.id = id;
        this.price = price;
        this.image = image;
        this.highResPhotoId = highResPhotoId;
        this.categoryId = categoryId;
    }

    public Photo(Integer id, Double price, byte[] image, List<User> users, List<Tag> tags, Photo highResPhotoId, Integer categoryId) {
        this.id = id;
        this.price = price;
        this.image = image;
        this.users = users;
        this.tags = tags;
        this.highResPhotoId = highResPhotoId;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

//    @JsonBackReference
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }

//    @JsonManagedReference
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Photo getHighResPhotoId() {
        return highResPhotoId;
    }

    public void setHighResPhotoId(Photo highResPhotoId) {
        this.highResPhotoId = highResPhotoId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(id, photo.id) && Objects.equals(price, photo.price) && Arrays.equals(image, photo.image) && Objects.equals(users, photo.users) && Objects.equals(tags, photo.tags) && Objects.equals(highResPhotoId, photo.highResPhotoId) && Objects.equals(categoryId, photo.categoryId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, price, users, tags, highResPhotoId, categoryId);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", price=" + price +
                ", image=" + Arrays.toString(image) +
                ", users=" + users +
                ", tags=" + tags +
                ", highResPhotoId=" + highResPhotoId +
                ", categoryId=" + categoryId +
                '}';
    }
}
