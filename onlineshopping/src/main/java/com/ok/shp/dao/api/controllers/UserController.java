package com.ok.shp.dao.api.controllers;

import java.util.List;

import javax.validation.Valid;

import com.ok.shp.dao.ProductRepository;
import com.ok.shp.dao.UserRepository;
import com.ok.shp.dao.api.controllers.methods.UserControllerMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ok.shp.entities.Product;
import com.ok.shp.entities.User;
import com.ok.shp.requests.AddMoneyRequest;
import com.ok.shp.requests.BuyProductRequest;
import com.ok.shp.requests.ChangeUserPasswordRequest;
import com.ok.shp.requests.CheckWalletRequest;
import com.ok.shp.requests.CreateUserRequest;
import com.ok.shp.requests.FindUserRequest;
import com.ok.shp.requests.LoginRequest;
import com.ok.shp.requests.UpdateUserRequest;
import com.ok.shp.responses.AddMoneyResponse;
import com.ok.shp.responses.BuyProductResponse;
import com.ok.shp.responses.ChangeUserPasswordResponse;
import com.ok.shp.responses.CheckWalletResponse;
import com.ok.shp.responses.CreateUserResponse;
import com.ok.shp.responses.DeleteUserResponse;
import com.ok.shp.responses.FindUserResponse;
import com.ok.shp.responses.LoginResponse;
import com.ok.shp.responses.UpdateUserResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    ProductRepository proRepo;


    @GetMapping
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable(value = "id") long userId) {
        return userRepo.findById(userId).get();
    }

    @PostMapping("/find")
    public FindUserResponse findUser(@RequestBody @Valid FindUserRequest request) {
        FindUserResponse response = new FindUserResponse();
        if (userRepo.existsById(request.getUserId())) {
            User user = userRepo.findById(request.getUserId()).get();

            UserControllerMethods.findUser(user, request, response);
        } else {
            response.setSuccess(false);
            response.setMessage("User doesn't exist!");
        }
        return response;
    }

    @GetMapping("/delete/{userId}")
    public DeleteUserResponse deleteUser(@PathVariable("userId") Long userId) {
        DeleteUserResponse response = new DeleteUserResponse();
        if (userRepo.existsById(userId)) {
            response.setSuccess(true);
            userRepo.deleteById(userId);
            response.setMessage("Deleted!");
        } else {
            response.setSuccess(false);
            response.setMessage("User doesn't exist!");
        }
        return response;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
        LoginResponse response = new LoginResponse();
        if (userRepo.existsById(request.getId())) {
            User user = userRepo.findById(request.getId()).get();
            if (BCrypt.checkpw(request.getPassword(), user.getSitePassword())) {
                if (user.getAdmin() == true) {
                    response.setSuccess(true);
                    response.setAdmin(true);
                    response.setMessage("Welcome! You are an admin.");
                } else {
                    response.setSuccess(true);
                    response.setAdmin(false);
                    response.setMessage("Welcome!");
                }

            } else {
                response.setSuccess(false);
                response.setMessage("Password or Id is wrong!");
            }
        } else {
            response.setSuccess(false);
            response.setMessage("User doesn't exist!");
        }
        return response;
    }

    @PostMapping("/update")
    public UpdateUserResponse update(@RequestBody @Valid UpdateUserRequest request) {
        UpdateUserResponse response = new UpdateUserResponse();
        if (userRepo.existsById(request.getUserId())) {
            User user = userRepo.findById(request.getUserId()).get();

            UserControllerMethods.updateUser(user, userRepo, request, response);
        } else {
            response.setSuccess(false);
            response.setMessage("Id doesn't exist!");
        }
        return response;
    }

    @PostMapping("/change-password")
    public ChangeUserPasswordResponse changePassword(@RequestBody @Valid ChangeUserPasswordRequest request) {
        ChangeUserPasswordResponse response = new ChangeUserPasswordResponse();
        if (userRepo.existsById(request.getUserId())) {
            User user = userRepo.findById(request.getUserId()).get();
            if (user.getSitePassword().equals(request.getOldPass())) {
                if (request.getNewPass().equals(request.getNewPassAgain())) {
                    response.setSuccess(true);
                    user.setSitePassword(request.getNewPass());
                    userRepo.save(user);
                    response.setMessage("Successfull!");
                } else {
                    response.setSuccess(false);
                    response.setMessage("New passwords doesn't match!");
                }
            } else {
                response.setSuccess(false);
                response.setMessage("Wrong old password!");
            }
        } else {
            response.setSuccess(false);
            response.setMessage("User doesn't exist!");
        }
        return response;
    }

    @PostMapping("/partial-update")
    public UpdateUserResponse partialUserUpdate(@RequestBody @Valid UpdateUserRequest request) {
        UpdateUserResponse response = new UpdateUserResponse();
        if (userRepo.existsById(request.getUserId())) {
            User user = userRepo.findById(request.getUserId()).get();
            if (request.getNewFirstName() != null) {
                user.setFirstName(request.getNewFirstName());
            }
            if (request.getNewLastName() != null) {
                user.setLastName(request.getNewLastName());
            }
            if (request.getNewEmail() != null) {
                user.setEmail(request.getNewEmail());
            }
            if (request.getNewPhoneNumber() != null) {
                user.setPhoneNumber(request.getNewPhoneNumber());
            }
            if (request.getNewHomeAddress() != null) {
                user.setHomeAddress(request.getNewHomeAddress());
            }
            response.setSuccess(true);
            userRepo.save(user);
            response.setMessage("Updated!");
        } else {
            response.setSuccess(false);
            response.setMessage("Id doesn't exist!");
        }
        return response;
    }

    @PostMapping("/buy-product")
    public BuyProductResponse buyProduct(@RequestBody BuyProductRequest request) {
        BuyProductResponse response = new BuyProductResponse();
        if (userRepo.existsById(request.getUserId())) {
            User user = userRepo.findById(request.getUserId()).get();
            if (proRepo.existsById(request.getProductId())) {
                Product product = proRepo.findById(request.getProductId()).get();
                if (product.getProductAmount() < request.getProductAmount()) {
                    response.setSuccess(false);
                    response.setMessage("Doesn't have much that product left! There is " + product.getProductAmount()
                            + " product left on the stock!");
                } else {
                    Long finalPrice = product.getProductPrice() * request.getProductAmount();
                    if (user.getWallet() < finalPrice) {
                        response.setSuccess(false);
                        response.setMessage(
                                "You don't have enough balance! You have " + user.getWallet() + "₺ on your wallet.");
                    } else {
                        user.setWallet(user.getWallet() - finalPrice);
                        product.setProductAmount(product.getProductAmount() - request.getProductAmount());
                        userRepo.save(user);
                        proRepo.save(product);
                        response.setSuccess(true);
                        response.setMessage("Successfully done!");
                    }
                }
            } else {
                response.setSuccess(false);
                response.setMessage("Product doesn't exist!");
            }

        } else {
            response.setSuccess(false);
            response.setMessage("User doesn't exist!");
        }
        return response;
    }

    @PostMapping("/add-money")
    public AddMoneyResponse addMoney(@RequestBody AddMoneyRequest request) {
        AddMoneyResponse response = new AddMoneyResponse();
        if (userRepo.existsById(request.getUserId())) {
            response.setSuccess(true);
            User user = userRepo.findById(request.getUserId()).get();
            user.setWallet(user.getWallet() + request.getAmount());
            userRepo.save(user);
            response.setMessage("Successfully done! Wallet: " + user.getWallet() + "₺");
        } else {
            response.setSuccess(false);
            response.setMessage("User doesn't exist!");
        }
        return response;
    }

    @PostMapping("/check-wallet")
    public CheckWalletResponse checkWallet(@RequestBody CheckWalletRequest request) {
        CheckWalletResponse response = new CheckWalletResponse();
        if (userRepo.existsById(request.getUserId())) {
            User user = userRepo.findById(request.getUserId()).get();
            response.setSuccess(true);
            response.setMessage(user.getWallet() + "₺ left.");
        } else {
            response.setSuccess(false);
            response.setMessage("User doesn't exist!");
        }
        return response;

    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse create(@RequestBody @Valid CreateUserRequest request) {

        CreateUserResponse response = new CreateUserResponse();
        User user = new User();

        UserControllerMethods.createUser(user, userRepo, request, response);

        return response;

    }


}
