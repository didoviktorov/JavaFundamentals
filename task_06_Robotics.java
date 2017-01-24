import java.io.*;
import java.util.*;

public class task_06_Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> products = new ArrayDeque<>();
        String[] robs = reader.readLine().split(";");
        String startTime = reader.readLine();
        Robot[] robots = new Robot[robs.length];

        for (int i = 0; i < robs.length; i++) {
            String[] tokens = robs[i].split("-");
            String name = tokens[0];
            int processingTime = Integer.parseInt(tokens[1]);
            robots[i] = new Robot(name, processingTime, startTime);
        }

        String product = reader.readLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = reader.readLine();
        }
        while (!products.isEmpty()) {
            boolean productTaken = false;

            for (Robot robot : robots) {
                robot.updateStatus();

                if (!robot.busy() && !productTaken) {
                    robot.process(products.poll());
                    productTaken = true;
                }
            }

            if (!productTaken) {
                String toBack = products.poll();
                products.offer(toBack);
            }
        }
    }
}

class Robot {
    private String name;
    private int processingTime;
    private boolean isBusy;
    private SimpleClock robotClock;
    private SimpleClock endTime;


    public Robot (String name, int processingTime, String start) {
        this.name = name;
        if (processingTime == 0) {
            this.processingTime = processingTime + 1;
        } else {
            this.processingTime = processingTime;
        }

        this.robotClock = new SimpleClock(start);
        this.isBusy = false;
    }

    public void process(String product) {
        if (this.isBusy) {
            return;
        }
        System.out.printf("%s - %s %s\n", this.name, product, this.robotClock.getTime());
        this.endTime = new SimpleClock(this.robotClock);
        this.endTime.addSeconds(this.processingTime);
        this.isBusy = true;
    }

    public void updateStatus() {
        this.robotClock.tick();

        if (this.busy()) {
            if (this.robotClock.equals(this.endTime)) {
                this.isBusy = false;
            }
        }
    }

    public boolean busy() {
        return this.isBusy;
    }
}

class SimpleClock {
    private byte hours;
    private byte minutes;
    private byte seconds;

    public SimpleClock(String startTime) {
        StringTokenizer clockTokenizer = new StringTokenizer(startTime, ":");

        this.hours = Byte.valueOf(clockTokenizer.nextToken());
        this.minutes = Byte.valueOf(clockTokenizer.nextToken());
        this.seconds = Byte.valueOf(clockTokenizer.nextToken());
    }

    public SimpleClock(SimpleClock otherClock) {
        this.hours = otherClock.hours;
        this.minutes = otherClock.minutes;
        this.seconds = otherClock.seconds;
    }

    public boolean equals(SimpleClock otherClock) {
        return ((this.hours == otherClock.hours)
                && (this.minutes == otherClock.minutes)
                && (this.seconds == otherClock.seconds));
    }

    public void tick() {
        this.seconds += 1;
        if (this.seconds == 60) {
            this.seconds = 0;
            this.minutes += 1;
        }
        if (this.minutes == 60) {
            this.minutes = 0;
            this.hours += 1;
        }
        if (this.hours == 24) {
            this.hours = 0;
        }
    }

    public String getTime() {
        String seconds = this.seconds < 10 ? ("0" + this.seconds) : String.valueOf(this.seconds);
        String minutes = this.minutes < 10 ? ("0" + this.minutes) : String.valueOf(this.minutes);
        String hours = this.hours < 10 ? ("0" + this.hours) : String.valueOf(this.hours);

        return String.format("[%s:%s:%s]", hours, minutes, seconds);
    }

    public void addSeconds(int seconds) {
        for (int i = 0; i < seconds; i++) {
            this.tick();
        }
    }
}


