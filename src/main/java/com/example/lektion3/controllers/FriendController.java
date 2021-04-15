package com.example.lektion3.controllers;

import com.example.lektion3.models.Friend;
import com.example.lektion3.repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/friend")
public class FriendController {

    @Autowired
    private FriendRepository friendRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addFriend(@RequestParam String firstName, @RequestParam String lastName,
                                          @RequestParam String phone, @RequestParam String streetAdress){
        Friend friend = new Friend();
        friend.setFirstName(firstName);
        friend.setLastName(lastName);
        friend.setPhone(phone);
        friend.setStreetAdress(streetAdress);
        friendRepository.save(friend);
        return "Vännen är tillagd";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Friend> allFriends(){
        return friendRepository.findAll();
    }

    @GetMapping(path="/findByFirstName")
    public @ResponseBody Iterable<Friend> findByFirstName(String name){
        return friendRepository.findByFirstName(name);
    }

    @GetMapping(path="/findByLastName")
    public @ResponseBody Iterable<Friend> findByLastName(String name){
        return friendRepository.findByLastName(name);
    }

    @GetMapping(path="/findAllByFirstAndLastName")
    public @ResponseBody Iterable<Friend> findByFirstAndLastName(String firstName, String lastName ){
        return friendRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping(path="/findOneByFirstAndLastName")
    public @ResponseBody Friend findOneByFirstAndLastName(String firstName, String lastName ){
        return friendRepository.findByFirstNameAndLastName(firstName, lastName).stream().findFirst().orElse(null);
    }

    @GetMapping(path="/addBestFriend")
    public @ResponseBody String addBestFriend(Long myId, String firstName, String lastName){
        Friend myself = null;
        Optional<Friend> me = friendRepository.findById(myId);
        if(me.isPresent()){
            myself = me.get();
        }
        Friend temp = findOneByFirstAndLastName(firstName,lastName);
        if (temp !=null){
            myself.setBestFriend(temp);
            return "Vännen är tillagd som bästa vän";
        }
        else
            return "Den vännen fanns inte i din telefonbok";
    }

}
