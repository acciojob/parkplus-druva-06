package com.driver.services;


import com.driver.DTO.responseDto.UpdateUserPasswordResponseDto;
import com.driver.model.User;

public interface UserService {

	void deleteUser(Integer userId);
	UpdateUserPasswordResponseDto updatePassword(Integer userId, String password);
    void register(String name, String phoneNumber, String password);
}
