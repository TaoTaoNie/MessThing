/**
 * @author leetHuam
 * @version 1.0
 */
public class GreenhouseControls extends Controller {
    private boolean light = false;
    public class LightOn extends Event {
        public LightOn(long delayTime) {super(delayTime);}
        public void action() {
            light = true;
        }
        public String toString() {return "Light is on";}
    }

    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }

    private boolean water = false;
    public class WaterOn extends Event {
        public WaterOn(long delayTime) {super(delayTime);}
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "Greenhouse water is on";
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = false;
        }

        @Override
        public String toString() {
            return "Greenhouse water is off";
        }
    }
    private String thermostat = "Day";
    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event{
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bing!";
        }
    }
    public class Restart extends Event {
        private Event[] events;
        public Restart(long delayTime, Event[] events) {
            super(delayTime);
            this.events = events;
            for (Event event : events)
                addEvent(event);
        }

        @Override
        public void action() {
            for(Event event : events) {
                event.action();
                addEvent(event);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting system";
        }
    }
    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }

    private boolean fan = true;
    public class FanOpen extends Event {
        public FanOpen(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            fan = true;
        }

        @Override
        public String toString() {
            return "Fan is on";
        }
    }

    public class FanClose extends Event {
        public FanClose(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            fan = false;
        }

        @Override
        public String toString() {
            return "Fan is off";
        }
    }

    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        gc.addEvent(gc.new Bell(900));
        Event[] events = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new FanOpen(900),
                gc.new FanClose(1000),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000,events));
        if (args.length == 1) {
            gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
        }
        gc.run();
    }
}


