package com.example.webapp.service.Interfaces;

import com.example.webapp.model.User;
import java.util.List;

public interface UserService {
    public User getUserById(int id);
    public List<User> getAllUsers();
    public void addUser(User user);
    public void deleteUser(int id);
    public List<User> userGtList(int id);
}
