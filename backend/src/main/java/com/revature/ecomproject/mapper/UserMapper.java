package com.revature.ecomproject.mapper;

import com.revature.ecomproject.dto.UserRequestDTO;
import com.revature.ecomproject.dto.UserResponseDTO;
import com.revature.ecomproject.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserMapper {

    /**
     * Converts a UserRequestDTO object to a User object.
     * @param userRequestDTO UserRequestDTO object
     * @return User object
     */
    public static User toUser(UserRequestDTO userRequestDTO) {
        User user = new User();

        user.setUsername(userRequestDTO.getUsername());
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());

        return user;
    }

    /**
     * Converts a User object to a UserResponseDTO object.
     * @param user User object
     * @return UserResponseDTO object
     */
    public static UserResponseDTO toUserResponseDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId(user.getId());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setFirstName(user.getFirstName());
        userResponseDTO.setLastName(user.getLastName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setRole(user.getRole());
        userResponseDTO.setCreatedAt(user.getCreatedAt());
        userResponseDTO.setUpdatedAt(user.getUpdatedAt());

        return userResponseDTO;
    }

    /**
     * Converts a list of User objects to a list of UserResponseDTO objects.
     * @param users List of User objects
     * @return List of UserResponseDTO objects
     */
    public static List<UserResponseDTO> toUserResponseDTOList(List<User> users) {
        return users.stream()
            .map(UserMapper::toUserResponseDTO)
            .toList();
    }

    /**
     * Converts an Optional<User> object to an Optional<UserResponseDTO> object.
     * @param userOptional Optional<User> object
     * @return Optional<UserResponseDTO> object
     */
    public static Optional<UserResponseDTO> toUserResponseDTOOptional(Optional<User> userOptional) {
        return userOptional.map(UserMapper::toUserResponseDTO);
    }

}
