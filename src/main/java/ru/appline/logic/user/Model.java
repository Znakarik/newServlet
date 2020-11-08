package ru.appline.logic.user;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {
    private static final Model INSTANCE = new Model();
    private final Map<Integer, User> model;

    public static Model getInstance() {
        return INSTANCE;
    }

    private Model() {
        model = new HashMap<>();
        model.put(1, new User("Вася", "Барабыкин", 10_000));
        model.put(2, new User("Николай", "Октапьевич", 15_000));
        model.put(3, new User("Ленкач", "Мишкин", 10_000));
    }

    public void add(User user, int id) {
        model.put(id, user);
    }

    public Map<Integer, User> getFromList() {
        return model;
    }

    public User findById(Integer id) {
        return model.get(id);
    }

    public void deleteById(Integer id){
        model.remove(id);
    }
}
