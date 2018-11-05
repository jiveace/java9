package academy.learn.jokeserver.kid;

import academy.learn.jokeserver.JokeServer;
import academy.learn.jokeserver.kid.internal.Filter;

import java.util.List;

/**
 * Created by Frank J. Mitropoulos.
 */
public class KidJokeServer implements JokeServer {

    private List<String> jokes = List.of(
           "\"Even the man with three H's would be proud of the way we buried this young, promising talent.\" - Broken Matt Hardy",
            "You are only half the man that I am, and I have only half the brain that you do!",
            "Win if you can, lose if you must, but always cheat.\"",
            "If you put a letter 's' in front of hitman you have my exact opinion of Bret Hart",
            "Jannety tried to jump through the window to escape did you see that!"
    );

    private static int getRandomInteger(int maximum, int minimum){ return ((int) (Math.random()*(maximum - minimum))) + minimum; }

    public String getJoke() {
        int index = getRandomInteger(jokes.size(),0) ;
        return Filter.clean(jokes.get(index));
    }

    public int availableJokes() {
        return jokes.size();
    }

    public String name() {
        return "Kid Joke Server";
    }

}
