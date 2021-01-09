package com.movie.base;

import com.movie.base.initialization.*;

import com.movie.base.payment.Payment;
import com.movie.base.payment.PaymentMode;
import sun.security.krb5.internal.Ticket;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class BookingReservation {

    static{

    }

    static ScreenCapacity screenCapacity = new ScreenCapacity();

    static PaymentMode payment = new PaymentMode();

    static ShowTimings showTimings = new ShowTimings();

    static Movie movie = new Movie("TENET", "2hrs 30mins", "2020");

    static TicketPrices ticketPrices = new TicketPrices();

    static ScreenRow[][] screenRows = new ScreenRow[10][10];

    public static void main(String[] args) {


        initBookingCounter();

        Scanner scanner = new Scanner(System.in);

        System.out.println("---WELCOME TO MOVIEBUFF.COM----");
        String movieName = scanner.nextLine();

        System.out.println("YOUR MOVIE IS "+ movieName);

        String numberOfSeats = scanner.nextLine();


        Date[] movieTimesAvailable = showTimings.getMovieTime();

        System.out.println("Available Movie Timings are: "+ Arrays.toString(movieTimesAvailable));

        //Display Available seats

        ScreenRow[][] screenRows = screenCapacity.getScreenRows();

        System.out.println("Screen Rows Available" + Arrays.deepToString(screenRows));

        //Display price
        System.out.println("Ticket Prices: "+ticketPrices.getTicketPrice());


        //Accept Payment Mode
        System.out.println("Enter Payment Cash/Card Only");
        String paymentMode = scanner.nextLine();


        System.out.println("Accepted Payment Type "+payment.getPaymentType());

        boolean paymentAccepted = false;
        for(int i=0; i < 2; i++){
            if (paymentMode.equals(payment.getPaymentType())) {

                System.out.println("Payment is succesfull");
                paymentAccepted = true;
            }
        }

        System.out.println("Your Ticket is confirmed");

    }

    //init the screen capacity at 100
    public static void initBookingCounter(){
        screenCapacity.setScreenRows(initScreenCapacity(screenCapacity));
        showTimings.setMovieTime(new Date[]{new Date(10), new Date(11), new Date(12), new Date(13)});
        ticketPrices.setTicketPrice(BigDecimal.valueOf(6.25));

        Payment[] payments = new Payment[2];
        payments[0] = Payment.CASH;
        payments[1] = Payment.CARD;
        payment.setPaymentType(payments);
       // payment.setPaymentType(Payment.CARD);
    }

    public static ScreenRow[][] initScreenCapacity(ScreenCapacity screenCapacity){


        char row = 'A';

        for(int i =0; i < 10; i++){

            for(int  j = 0; j < 10; j++){
                    screenRows[i][j] = new ScreenRow(row, "" + (j + 1));
                }

                row++;
        }

       return screenRows;

    }
}
