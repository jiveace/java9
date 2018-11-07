package academy.learn.discrete.privatemethods.Main;

import academy.learn.discrete.privatemethods.interfaces.RemoteControllable;
import academy.learn.discrete.privatemethods.models.Light;
import academy.learn.discrete.privatemethods.models.Television;

import java.util.List;

public class Main {

    public static void main(String[] args) {

//        var l = new Light("Porch");
//        l.turnOn();
//
//        var t = new Television("Living Room");
//        t.reset();
//
//        System.out.println(t.getStatus());
//        System.out.println(t.getDetailedStatus());

        List<RemoteControllable> devices = List.of(
                new Light("Pool Light"),
                new Light("Back Light"),
                new Television("Guest TV"),
                new Television("Main TV")
        );
        turnAllOff(devices);

        // Why access a constant via method call - I don't understand
        System.out.println(RemoteControllable.getSystemStatus());
        System.out.println(RemoteControllable.systemStatus);
    }

    public static void turnAllOff(List<RemoteControllable> devices) {
        devices.forEach(p -> p.turnOff());
    }
}
