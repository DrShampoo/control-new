package entities.events;

import entities.controls.Test;

import java.util.List;

public class ThirdControlEvent extends ControlEvent {
    public ThirdControlEvent(List<Test> tests) {
        super(tests);
    }


    @Override
    public String toString() {
        return "Control event №3: the result - " + this.isSessionPassed();
    }
}
