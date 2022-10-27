package com.fanter.samplebackend.rest;

import com.fanter.samplebackend.domain.User;
import com.fanter.samplebackend.exceptions.AddUserException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserRestController {
    List<User> users = new ArrayList<>();

    @PostConstruct
    public void initialize() {

        users.clear();
        users.add(new User("godking123", "joe@gmail.com", 27));
        users.add(new User("trouble1", "email1@gmail.com", 35));
        users.add(new User("meowmew", "miau@gmail.com", 13));

    }

    @GetMapping("/all")
    public List<User> getAllUsers() {

        return users;
    }

    @DeleteMapping("/delete/{userName}")
    public List<User> deleteUser(@PathVariable String userName) throws Exception {

       if (!users.removeIf(user -> user.getUserName().equals(userName))) {
           throw new Exception("User not found.");
       }
        return users;
    }

    @PostMapping("/adduser")
    public List<User> addUser(@RequestBody User user) throws AddUserException {
        if (user.getUserName().length() < 5) {
            throw new AddUserException("Username must be at least 5 long.");
        }
        if (!user.getEmail().contains("@")) {
            throw new AddUserException("Email must contain @ !");
        }
        if (user.getAge() < 0) {
            throw new AddUserException("Age must be greater than 0!");
        }
        users.add(user);
        return users;
    }
}
