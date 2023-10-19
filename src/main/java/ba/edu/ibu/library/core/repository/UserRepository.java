package ba.edu.ibu.library.core.repository;

import ba.edu.ibu.library.core.model.User;
import ba.edu.ibu.library.core.model.enums.UserType;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

  @Aggregation(
    pipeline = """
                 { $match:  { _id:  { $exists: true } } }
               """
  )
  List<User> findAllCustom();

  @Query(
    value = "{email:'?0'}",
    fields = "{'id':  1, 'firstName':  1, 'lastName':  1, 'email':  1, 'username':  1, 'userType':  1}"
  )
  Optional<User> findByEmailCustom(String email);

  Optional<User> findFirstByEmailLike(String emailPattern);

  List<User> findByEmailAndUserTypeOrderByCreationDateDesc(String email, UserType username);
}
