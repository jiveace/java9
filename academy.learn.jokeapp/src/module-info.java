module academy.learn.jokeapp {

    requires academy.learn.jokeserver;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    uses academy.learn.jokeserver.JokeServer;

    opens academy.learn.jokeapp.ui
            to javafx.graphics, javafx.fxml;
}
