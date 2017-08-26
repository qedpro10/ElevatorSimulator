package cscie55.hw1.elevatortest;

import cscie55.hw1.elevator.Elevator;

public class ElevatorTest {
    public static void main(String[] args) {

        /// create elevator
        Elevator ev = new Elevator();

        // board 2 passengers for the 3rd floor
        ev.boardPassenger(3);
        ev.boardPassenger(3);

        // board 1 passenger for the 5th floor
        ev.boardPassenger(5);

        System.out.println(ev.toString());
        for (int i=0; i<12; i++) {
            ev.move();
            System.out.println(ev.toString());
        }

    }
}
