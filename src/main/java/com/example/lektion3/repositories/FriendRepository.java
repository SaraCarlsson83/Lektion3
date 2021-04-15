package com.example.lektion3.repositories;

import com.example.lektion3.models.Friend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Long> {

    List<Friend> findByFirstName(String firstName);
    List<Friend> findByLastName(String lastName);
    List<Friend> findByPhone(String phone);
    List<Friend> findByStreetAdress(String streetAress);
    List<Friend> findByFirstNameAndLastName(String firstName, String lastName);

}
