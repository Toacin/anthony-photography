package com.antphoto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToMany(mappedBy = "photos")
    private List<User> users;

    @ManyToMany
    @JoinTable(name = "PHOTO_TAG",
            joinColumns = @JoinColumn(name = "photoId"),
            inverseJoinColumns = @JoinColumn(name = "tagId")
    )
    private List<Tag> tags;

    @OneToOne
    private Photo highResPhotoId;

    public Photo() {
    }

    public Photo(Integer id, Double price, byte[] image, Photo highResPhotoId) {
        this.id = id;
        this.price = price;
        this.image = image;
        this.highResPhotoId = highResPhotoId;
    }

    public Photo(Integer id, Double price, byte[] image, List<User> users, List<Tag> tags, Photo highResPhotoId) {
        this.id = id;
        this.price = price;
        this.image = image;
        this.users = users;
        this.tags = tags;
        this.highResPhotoId = highResPhotoId;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(id, photo.id) && Objects.equals(price, photo.price) && Arrays.equals(image, photo.image) && Objects.equals(users, photo.users) && Objects.equals(tags, photo.tags) && Objects.equals(highResPhotoId, photo.highResPhotoId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, price, users, tags, highResPhotoId);
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
                '}';
    }
}
