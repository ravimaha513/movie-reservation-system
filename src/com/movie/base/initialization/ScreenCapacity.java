package com.movie.base.initialization;

public class ScreenCapacity extends ScreenInitialization{

    public static int INIT_CAPACITY  ;

    int numOfSeatsBooked;

    int numOfSeatsAvailable;

    ScreenRow[][] screenRows;



    public ScreenRow[][] getScreenRows() {
        return screenRows;
    }

    public void setScreenRows(ScreenRow[][] screenRows) {
        this.screenRows = screenRows;
    }

    public int getNumOfSeatsBooked() {
        return numOfSeatsBooked;
    }

    public void setNumOfSeatsBooked(int numOfSeatsBooked) {
        this.numOfSeatsBooked = numOfSeatsBooked;
    }

    public int getNumOfSeatsAvailable() {
        return numOfSeatsAvailable;
    }

    public void setNumOfSeatsAvailable(int numOfSeatsAvailable) {
        this.numOfSeatsAvailable = numOfSeatsAvailable;
    }


}
