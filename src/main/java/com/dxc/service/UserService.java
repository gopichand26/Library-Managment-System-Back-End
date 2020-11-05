package com.dxc.service;

import java.util.List;
import java.util.Optional;

import com.dxc.model.User;
import com.dxc.model.UserDto;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(int id);

    User findOne(String username);

    User findById(int id);

    UserDto update(UserDto userDto);
	
}
