//package com.unoveo.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
//
//import java.util.List;
//
//public class Role {
//    @Id
//    private long id;
//    @Column(nullable = false)
//    private String username;
//    @ManyToMany(mappedBy = "roles")
//    private List<User> users;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//
//    public Role(long id, String username, List<User> users) {
//        this.id = id;
//        this.username = username;
//        this.users = users;
//    }
//
//    public Role() {
//    }
//}
