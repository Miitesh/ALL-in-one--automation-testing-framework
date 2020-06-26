package stepdef;

import java.util.HashMap;

import cucumber.api.Scenario;

public class Storage {

	private static final HashMap<Thread, Scenario> map = new HashMap<Thread, Scenario>();

    public static void putScenario(Scenario scenario) {
        map.put(Thread.currentThread(), scenario);
    }

    public static Scenario getScenario() {
        return map.get(Thread.currentThread());
    }
}
