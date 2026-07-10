package com.reactivo.proyecto.utils;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ReservationFilters {

    private ReservationFilters(){

    }

    public static final Predicate<ReservationFilters> isValidReservation = event -> event.getPrice()
            > 0 && !event.getEmails().isEmpty();

    public static final Consumer<ReservationEvent> printReservation =
            event -> System.out.println("Procesando el evento valido: " + event.toString());

}
