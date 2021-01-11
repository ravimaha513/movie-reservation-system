package com.movie.base.initialization;

import com.movie.base.payment.Payment;

import java.math.BigDecimal;
import java.time.LocalTime;

public abstract class ScreenInitialization {

    ScreenRow[][] screenRows;

    public void initBookingCounter() {
        initScreenCapacity();
    }

    public ScreenRow[][] initScreenCapacity() {

        char row = 'A';

        int rC = (int) Math.sqrt(ScreenCapacity.INIT_CAPACITY);

        for (int i = 0; i < rC; i++) {

            for (int j = 0; j < rC; j++) {
                screenRows[i][j] = new ScreenRow(row, "" + (j + 1));
            }

            row++;
        }

        return screenRows;

    }
}
