package com.simas.demo.repo;

import com.simas.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query("{nama: /^?0/}")
    List<User> findUserByNama(String nama);
}
