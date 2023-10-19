//package ba.edu.ibu.library.core.repository;
//
//import ba.edu.ibu.library.core.model.User;
//import org.springframework.stereotype.Repository;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Repository
//public class UserRepository {
//    private List<User> users;
//
//    public UserRepository() {
//        this.users = Arrays.asList(
//            new User("one", "two", "one.two@email.com", 19),
//            new User("three", "four", "three.four@email.com", 21)
//        );
//    }
//
//    public List<User> findAll() {
//        return users;
//    }
//
//    public User findbyEmail(String email) {
//        return users.stream()
//            .filter(x -> x.getEmail() == email)
//            .findFirst()
//            .orElse(null);
//    }
//}
