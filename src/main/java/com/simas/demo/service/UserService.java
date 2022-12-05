package com.simas.demo.service;

import com.simas.demo.entity.User;
import com.simas.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    protected UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String insertUser(User user) {
        try {
            userRepository.save(user);
        }catch (Exception e) {
            return "error";
        }
        return "success";
    }

    public String insertConsumeUser(User user) {
        try {
            org.springframework.http.HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            RestTemplate restTemplate = new RestTemplate(getClientFactory());
            org.springframework.http.HttpEntity<User> request = new HttpEntity<>(user);
            String response = restTemplate.postForObject("http://localhost:8080/user", request, String.class);
            return response;
        }catch (Exception e) {
            return "error";
        }
    }

    public HttpComponentsClientHttpRequestFactory getClientFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        factory.setReadTimeout(5000);
        return factory;
    }

    public String updateUser(User user) {
        try {
            userRepository.save(user);
        }catch (Exception e) {
            return "error";
        }
        return "success";
    }

    public List<User> getUserByName(String user) {
        return userRepository.findUserByNama(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public String deleteById(String id) {
        try {
            userRepository.deleteById(id);
        }catch(Exception e) {
            return "error";
        }
        return "success";
    }
}
