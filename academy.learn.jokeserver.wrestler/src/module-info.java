import academy.learn.jokeserver.wrestler.WrestlerJokeServer;

module academy.learn.jokeserver.wrestler {
  requires academy.learn.jokeserver;

  provides academy.learn.jokeserver.JokeServer
          with WrestlerJokeServer;
}