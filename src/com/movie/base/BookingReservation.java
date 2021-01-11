package com.movie.base;

import com.movie.base.initialization.*;

import com.movie.base.payment.Payment;
import com.movie.base.payment.PaymentMode;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Arrays;

import java.util.Scanner;
import java.util.UUID;


public class BookingReservation {

    //SOLID Principles

    static ScreenCapacity screenCapacity = new ScreenCapacity();

    static PaymentMode payment = new PaymentMode();

    static ShowTimings showTimings = new ShowTimings();

    static Movie movie = new Movie("TENET", "2hrs 30mins", "2020");

    static TicketPrices ticketPrices = new TicketPrices();

    static int screenSize ;



    static ScreenRow[][] screenRows;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the initial size");
        screenSize = scanner.nextInt();

        ScreenCapacity.INIT_CAPACITY = screenSize;

        int rowsColumns = (int) Math.sqrt(screenSize);
        screenRows = new ScreenRow[rowsColumns][rowsColumns];

        initBookingCounter();

        System.out.println("---WELCOME TO MOVIEBUFF.COM----");
        String movieName = scanner.nextLine();

        System.out.println("YOUR MOVIE IS "+ movieName);

        System.out.println("----------------------------");
        System.out.println("Enter the number of tickets ");
        String numberOfSeats = scanner.nextLine();

        LocalTime[] movieTimesAvailable = showTimings.getMovieTime();

        System.out.println("Available Movie Timings are: "+ Arrays.toString(movieTimesAvailable));

        //Display Available seats
        System.out.println("Pick a Time");

        String pickdTime = scanner.nextLine();

        System.out.println("Picked Time is "+ pickdTime);
        System.out.println("----------------------------");

        ScreenRow[][] screenRows = screenCapacity.getScreenRows();

        System.out.println("Screen Rows Available" + Arrays.deepToString(screenRows));

        System.out.println("Pick A Seat");

        String seatAlloc = scanner.nextLine();

        String[] seats = seatAlloc.split(" ");

        ScreenRow screenRow = new ScreenRow(seats[0].charAt(0), seats[1]);

        System.out.println("Seat Selected is ::"+ screenRow);

        System.out.println("-----------------------------");

        //Display price
        System.out.println("Ticket Prices: "+ticketPrices.getTicketPrice());


        //Accept Payment Mode
        System.out.println("Enter Payment Cash/Card Only");
        String paymentMode = scanner.nextLine();

        boolean paymentAccepted = false;
        for(int i=0; i < 2; i++){

            if (paymentMode.equalsIgnoreCase(payment.getPaymentType()[i].toString())) {

                System.out.println("Payment is succesfull");
                paymentAccepted = true;
                break;
            }
            else{
                System.out.println("Payment Declined");
            }
        }

        System.out.println("Booking Confirmation Code: "+ UUID.randomUUID());

        System.out.println("Your Ticket is confirmed for " + movieName + " at " + pickdTime + " : Number of Tickets "+ numberOfSeats );

    }

    //init the screen capacity at 100
    public static void initBookingCounter(){
        screenCapacity.setScreenRows(initScreenCapacity(screenCapacity));
        showTimings.setMovieTime(new LocalTime[]{LocalTime.parse("11:00"), LocalTime.parse("12:00"), LocalTime.parse("13:00")});
        ticketPrices.setTicketPrice(BigDecimal.valueOf(6.25));

        Payment[] payments = new Payment[2];
        payments[0] = Payment.CASH;
        payments[1] = Payment.CARD;
        payment.setPaymentType(payments);

    }


    public static ScreenRow[][] initScreenCapacity(ScreenCapacity screenCapacity){

        char row = 'A';

        int rC = (int) Math.sqrt(ScreenCapacity.INIT_CAPACITY);

        for(int i =0; i < rC; i++){

            for(int  j = 0; j < rC; j++){
                    screenRows[i][j] = new ScreenRow(row, "" + (j + 1));
                }

                row++;
        }

       return screenRows;

    }
}
