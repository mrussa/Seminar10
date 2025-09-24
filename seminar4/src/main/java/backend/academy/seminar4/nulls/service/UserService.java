package backend.academy.seminar4.nulls.service;

import backend.academy.seminar4.nulls.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

public class UserService {

    private final Map<Integer, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    /**
     * Необходимо отрефакторить код так, чтобы не столкнуться с NPE, если пользователя с userId не существует Можно
     * использовать Optional.ofNullable() и проверять результат в main()
     */
    public User findUserById(int userId) {
        return users.get(userId);
    }

    public String getUserEmail(int userId) {
        return findUserById(userId).getEmail();
    }

    public String getUserName(int userId) {
        return findUserById(userId).getName();
    }

    /**
     * Получение email или выброс исключения, если пользователь не найден
     */
    public String findUserEmailOrThrow(int userId) {
        return getUserEmail(userId);
    }

}
