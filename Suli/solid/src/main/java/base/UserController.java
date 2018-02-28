package base;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private List<Validator> validators;
    private UserService userService;


    public UserController(UserService userService, List<Validator> validators) {
        this.userService = userService;
        this.validators = validators;
    }

    public void createUser(String username) {
        if (validUserName(username)) {
            save(new User(username));
        }
    }

    private boolean validUserName(String userName) {
        boolean isItValid = false;
        if (validators == null || validators.isEmpty()) {
            isItValid = true;
        }

        for (Validator validator : validators) {
            if (!validator.isValid(userName)) {
                return isItValid;
            }
            isItValid = true;
        }
        return isItValid;
    }


    public void save(User user) {
        userService.save(user);
    }

}
