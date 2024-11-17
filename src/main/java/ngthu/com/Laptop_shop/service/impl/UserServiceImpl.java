package ngthu.com.Laptop_shop.service.impl;

import ngthu.com.Laptop_shop.model.UserDtls;
import ngthu.com.Laptop_shop.repository.UserRepository;
import ngthu.com.Laptop_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDtls saveUser(UserDtls user) {
        user.setRole("ROLE_USER");
        String encodePassword =  passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);

       UserDtls saveUser = userRepository.save(user);


        return saveUser;
    }

    @Override
    public UserDtls getUserByEmail(String email) {


        return userRepository.findByEmail(email);
    }
}
