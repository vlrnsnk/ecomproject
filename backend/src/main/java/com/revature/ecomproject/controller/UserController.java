package com.revature.ecomproject.controller;

import com.revature.ecomproject.dto.UserRequestDTO;
import com.revature.ecomproject.dto.UserResponseDTO;
import com.revature.ecomproject.mapper.UserMapper;
import com.revature.ecomproject.model.User;
import com.revature.ecomproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    /**
     * Get all users
     * @return List of all users
     */
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers().stream()
            .map(userMapper::toUserResponseDTO)
            .collect(Collectors.toList());
    }

    /**
     * Get user by id
     * @param id User id
     * @return User with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
            .map(userMapper::toUserResponseDTO)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Create user
     * @param user User object
     * @return Created user
     */
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        User user = userMapper.toUser(userRequestDTO);
        User createdUser = userService.createUser(user);
        UserResponseDTO userResponseDTO = userMapper.toUserResponseDTO(createdUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    /**
     * Update user
     * @param id User id
     * @param user User object
     * @return Updated user
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        User user = userMapper.toUser(userRequestDTO);
        User updatedUser = userService.updateUser(id, user);
        UserResponseDTO userResponseDTO = userMapper.toUserResponseDTO(updatedUser);

        return ResponseEntity.ok(userResponseDTO);
    }

    /**
     * Delete user
     * @param id User id
     * @return Deleted user
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Get user by username
     * @param username User username
     * @return User with the given username
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<UserResponseDTO> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username)
            .map(userMapper::toUserResponseDTO)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get user by email
     * @param email User email
     * @return User with the given email
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDTO> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email)
            .map(userMapper::toUserResponseDTO)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

}
