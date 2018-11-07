package academy.learn.discrete.privatemethods.models;

import academy.learn.discrete.privatemethods.interfaces.RemoteControllable;

/**
 * Created by Frank J. Mitropoulos.
 */
public class Television implements RemoteControllable {

    String desc;

    public Television (String desc) {
        this.desc = desc;
    }

    @Override
    public String deviceDescription() {
        return desc;
    }

    @Override
    public void turnOn() {
        System.out.println("Turning " + desc + " on");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning " + desc + " off");
    }

    @Override
    public void reset() {
        System.out.println("Resetting " + desc);

    }

    @Override
    public void notifyUser() {
        System.out.println("User notifed about " + desc);
    }

    @Override
    public String toString() {
        return desc;
    }

    @Override
    public String getStatus() {
        return "Custom status";
    }

}