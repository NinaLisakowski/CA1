package dto;

import entities.Joke;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carol
 */
public class JokeListDTO {
    private List<JokeDTO> dtoList = new ArrayList<>();

    public JokeListDTO(List<Joke> jokes) {
        for (Joke joke : jokes) {
            dtoList.add(new JokeDTO(joke));
        }
    }

    public List<JokeDTO> getDtoList() {
        return dtoList;
    }
    
}
