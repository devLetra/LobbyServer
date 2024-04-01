package network.twisty.lobby.data.cache;

import lombok.Getter;
import network.twisty.lobby.data.User;

import java.util.HashMap;

@Getter
public class UserCache {


    private final HashMap<String, User> user = new HashMap<>();

    public User getByUser(String name) {
        return user.get(name);
    }
}
