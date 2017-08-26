package cscie55.hw1.elevator;

public class Elevator {
    // Number of floors in building
    static final int field = 7;
    private int currentFloor;
    private boolean upDir;
    private int passengersPerFloor[];
    private int numPassengers;

    // 0 Argument Constructor
    public Elevator() {
        upDir = true;
        currentFloor = 1;
        numPassengers = 0;
        // initialize the array to 1 more than the number of
        // floors so that we don't have to do any conversion
        // 0-th element in array is not used - or could be the
        // basement in future
        passengersPerFloor = new int[field+1];
    }

    // move method that moves the elevator
    // one floor based on the elevator's current direction
    // Once the elevator moves, any passengers are assumed to
    // get off the elevator and the passengers destined to the
    // current floor is 0'd out
    public void move() {
        if (upDir) {
            currentFloor++;

            if (atTop()) {
                changeDir();
            }
        } else {
            currentFloor--;

            if (atGround()) {
                changeDir();
            }
        }

        numPassengers -= passengersPerFloor[currentFloor];
        passengersPerFloor[currentFloor] = 0;
    }

    // Public method to add passengers with a specific floor destination
    public void boardPassenger(int destinationFloor) {
        if (destinationFloor <= field && destinationFloor >=1){
            passengersPerFloor[destinationFloor]++;
            numPassengers++;
        }
    }

    public int currentFloor() {
        return this.currentFloor;
    }

    // Returns the number of passengers in the elevator
    public int passengers() {
        return this.numPassengers;
    }

    @Override
    public String toString() {
        int numP = passengers();
        return ("Floor " + currentFloor + ": " + numP + (numP == 1 ? " passenger" : " passengers"));
    }

    //////////////////////////////////////////////////////////////
    /// PRIVATE HELPER FUNCTIONS

    // Determine if the elevator is at the top floor
    private boolean atTop() {
        if (currentFloor == field)
            return true;
        return false;
    }

    // Determines if elevator is at the ground floor
    private boolean atGround() {
        if (currentFloor == 1)
            return true;
        return false;
    }

    // Changes the elevator direction
    private void changeDir() {
        upDir = !upDir;
    }

}
