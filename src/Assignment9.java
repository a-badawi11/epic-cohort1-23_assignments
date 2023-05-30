/**
 * Create three different methods of getStudentById where:
 * 1.	First one uses Unchecked exception if the user with provided id was not found (RunTimeException)
 * 2.	Second one uses checked exception
 * 3.	Third one uses Optional return type
 */

import java.util.*;

public class Assignment9 {

    public static void main(String[] args) {

        try {
            User user = findUserByIdV2(2);
            System.out.println("user.getName() = " + user.getName());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Optional<User> user = findUserByIdV3(3);
        user.ifPresent(u -> System.out.println(u.getName()));

        findUserById(2);
    }

    private static User findUserById(int id) {
        if (id != 3) {
            throw new UserNotFoundExceptionRuntime("User with id " + id + " couldn't be found");
        }
        return new User(3, "Ahmad");
    }

    private static User findUserByIdV2(int id) throws UserNotFoundException {
        if (id != 3) {
            throw new UserNotFoundException("User with id " + id + " couldn't be found");
        }
        return new User(3, "Ahmad");
    }

    private static Optional<User> findUserByIdV3(int id) {
        if(id == 3) {
            return Optional.of(new User(3, "Mohammad"));
        }
        return Optional.empty();
    }
}
