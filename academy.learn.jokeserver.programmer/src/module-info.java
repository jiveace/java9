module academy.learn.jokeserver.programmer {
    requires academy.learn.jokeserver;

    provides academy.learn.jokeserver.JokeServer
            with academy.learn.jokeserver.programmer.CoderJokeServer;
}