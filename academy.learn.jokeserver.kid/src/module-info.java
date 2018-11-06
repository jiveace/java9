module academy.learn.jokeserver.kid {
  requires academy.learn.jokeserver;

  provides academy.learn.jokeserver.JokeServer
          with academy.learn.jokeserver.kid.KidJokeServer;
}