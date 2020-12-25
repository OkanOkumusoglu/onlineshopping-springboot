package com.ok.shp.dao.api.controllers.methods;

import com.ok.shp.dao.UserRepository;
import com.ok.shp.entities.User;
import com.ok.shp.requests.CreateUserRequest;
import com.ok.shp.requests.FindUserRequest;
import com.ok.shp.requests.UpdateUserRequest;
import com.ok.shp.responses.CreateUserResponse;
import com.ok.shp.responses.FindUserResponse;
import com.ok.shp.responses.UpdateUserResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserControllerMethods {

    public static void findUser(User user, FindUserRequest request, FindUserResponse response) {
        response.setName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setHomeAddress(user.getHomeAddress());
        response.setSitePassword(user.getSitePassword());
        response.setWallet(user.getWallet());
        response.setAdmin(user.getAdmin());
        response.setSuccess(true);
        response.setMessage("Successful!");
    }

    public static void updateUser(User user, UserRepository userRepo, UpdateUserRequest request, UpdateUserResponse response) {
        user.setFirstName(request.getNewFirstName());
        user.setLastName(request.getNewLastName());
        user.setEmail(request.getNewEmail());
        user.setPhoneNumber(request.getNewPhoneNumber());
        user.setHomeAddress(request.getNewHomeAddress());
        userRepo.save(user);
        response.setSuccess(true);
        response.setMessage("Updated!");
    }

    public static void createUser(User user, UserRepository userRepo, CreateUserRequest request, CreateUserResponse response) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // Strength set as 12

        response.setFirstName(request.getFirstName());
        response.setLastName(request.getLastName());
        response.setPhoneNumber(request.getPhoneNumber());
        response.setEmail(request.getEmail());
        response.setHomeAddress(request.getHomeAddress());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        String encodedPassword = encoder.encode(request.getSitePassword());
        user.setSitePassword(encodedPassword);

        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setHomeAddress(request.getHomeAddress());
        user.setWallet(request.getWallet());
        user.setAdmin(request.getAdmin());
        userRepo.save(user);
        response.setId(user.getUserId());
        response.setMessage("User account has been created!");
        response.setSuccess(true);
    }
}
