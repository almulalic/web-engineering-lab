package ba.edu.ibu.library.core.service;

import ba.edu.ibu.library.core.model.User;
import ba.edu.ibu.library.core.repository.UserRepository;
import ba.edu.ibu.library.exceptions.repository.ResourceNotFoundException;
import ba.edu.ibu.library.rest.dto.UserDTO;
import ba.edu.ibu.library.rest.dto.UserRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<UserDTO> getUsers() {
    List<User> users = userRepository.findAll();

    return users.stream().map(UserDTO::new).collect(Collectors.toList());
  }

  public UserDTO getUserById(String id) {
    Optional<User> user = userRepository.findById(id);

    if (user.isEmpty()) {
      throw new ResourceNotFoundException("The user with the given ID does not exists.");
    }

    return new UserDTO(user.get());
  }

  public UserDTO filterByEmail(String email) {
    Optional<User> user = userRepository.findFirstByEmailLike(email);
    return user.map(UserDTO::new).orElse(null);
  }

  public UserDTO addUser(UserRequestDTO payload) {
    User user = userRepository.save(payload.toEntity());
    return new UserDTO(user);
  }

  public UserDTO updateUser(String id, UserRequestDTO payload) {
    Optional<User> user = userRepository.findById(id);

    if (user.isEmpty()) {
      throw new ResourceNotFoundException("The user with the given ID does not exists.");
    }

    User updatedUser = payload.toEntity();
    updatedUser.setId(id);
    updatedUser = userRepository.save(updatedUser);
    return new UserDTO(updatedUser);
  }

  public void deleteUser(String id) {
    Optional<User> user = userRepository.findById(id);
    user.ifPresent(userRepository::delete);
  }
}
