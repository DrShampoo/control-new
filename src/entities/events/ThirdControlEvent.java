package entities.events;

import entities.controls.Test;

import java.util.List;

public class ThirdControlEvent extends ControlEvent {
    public ThirdControlEvent(List<Test> tests) {
        super(tests);
    }


    @Override
    public String toString() {
        return "Control entities.event №3: total - " + this.isSessionPassed();
    }
}
