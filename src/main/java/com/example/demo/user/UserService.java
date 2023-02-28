package com.example.demo.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Component // tell compiler this class is spring bean
@Service //tell compiler it's not only spring bean but also a service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getUsers(){
        /*
        return List.of(
            new Users(1L,"TestName", 0,18,"test@uci.edu")
        );
        */
        return userRepository.findAll();
    }

    public void addNewUser(Users u) {
        Optional<Users> userOpt = userRepository.findUserByEmail(u.getEmail());
        if(userOpt.isPresent()){
            throw new IllegalStateException("email used");
        }
        userRepository.save(u); // save to db
        //System.out.println(u);
    }

    public void deleteUser(Long uid) {
        boolean exist = userRepository.existsById(uid);
        if(!exist){
            throw new IllegalStateException("user with uid = " + uid + " doesn't exist");
        }
        userRepository.deleteById(uid);
    }

    @Transactional
    public void updateCoinByID(Long uid, Integer coin) {
        Users users = userRepository.findById(uid).orElseThrow(() -> new IllegalStateException("user with uid = " + uid + " doesn't exist"));
        if(coin != null && coin >= 0){
            users.setCoins(coin);
        }
    }
}
