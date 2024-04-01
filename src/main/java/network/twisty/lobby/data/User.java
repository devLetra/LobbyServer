package network.twisty.lobby.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private final String name;
    private boolean pvp;

}
