package com.example.chapter1.controller;

import com.example.chapter1.Entry.UserEntry;
import org.apache.tomcat.jni.Error;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    static Map<Long, UserEntry> users = Collections.synchronizedMap(new HashMap<Long, UserEntry>());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserEntry> getUserList() throws Exception {

        List<UserEntry> userEntries = new ArrayList<UserEntry>(users.values());

        throw new Exception("未知错误");

//        return userEntries;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserEntry getUser(@PathVariable("id") Long id) {
        return users.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addUser(@ModelAttribute UserEntry user) {
        users.put(user.getId(), user);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute UserEntry user) {

        UserEntry userEntry = users.get(id);

        userEntry.setName(user.getName());
        userEntry.setAge(user.getAge());

        users.put(id, userEntry);

        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {

        users.remove(id);

        return "success";
    }
}
