package ba.edu.ibu.library.rest.controllers;

import ba.edu.ibu.library.core.service.UserService;
import ba.edu.ibu.library.rest.dto.UserDTO;
import ba.edu.ibu.library.rest.dto.UserRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
  private final UserService userService;

  public UserController(final UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/")
  public ResponseEntity<List<UserDTO>> getUsers() {
    return ResponseEntity.ok(userService.getUsers());
  }

  @RequestMapping(method = RequestMethod.GET, path = "/filter")
  public ResponseEntity<UserDTO> filterUser(
    @RequestParam String email
  ) {
    return ResponseEntity.ok(userService.filterByEmail(email));
  }

  @RequestMapping(method = RequestMethod.POST, path = "/register")
  public ResponseEntity<UserDTO> register(
    @RequestBody UserRequestDTO user
  ) {
    return ResponseEntity.ok(userService.addUser(user));
  }

  @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
  public ResponseEntity<UserDTO> register(
    @PathVariable String id,
    @RequestBody UserRequestDTO user
  ) {
    return ResponseEntity.ok(userService.updateUser(id, user));
  }

  @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
  public ResponseEntity<Void> deleteUser(
    @PathVariable String id
  ) {
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
