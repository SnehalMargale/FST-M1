package Activities.Activity6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Activity6 {

    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(10);
        plane.onboard("Snehal");
        plane.onboard("Shreeraj");
        plane.onboard("Sayali");

        System.out.println("TakeOff Time: "+ plane.takeOff());
        System.out.println("Passenger List: "+ plane.getPassengers());
        Thread.sleep(5000);
        plane.land();
        System.out.println("Last time landed: "+ plane.getLastTimeLanded());
        System.out.println("Passenger List: "+ plane.getPassengers());

    }
}

    class Plane {
        private List<String> passengers;
        private int maxPassengers;
        private Date lastTimeTookOf;
        private Date lastTimeLanded;

        public Plane(int maxPassengers)
        {
            passengers = new ArrayList<>();
            maxPassengers = maxPassengers;
        }

        public void onboard(String passenger){
            passengers.add(passenger);
        }
        public Date takeOff(){
            lastTimeTookOf = new Date();
            return lastTimeTookOf;
        }
        public void land(){
            lastTimeLanded= new Date();
            passengers.clear();
        }
        public Date getLastTimeLanded(){
            return lastTimeLanded;
        }
        public List getPassengers(){
            return passengers;
        }
    }


