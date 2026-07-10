package com.reactivo.proyecto.controller;


import com.reactivo.proyecto.ReservationEvent;
import com.reactivo.proyecto.utils.ReservationFilters;
import reactor.core.publisher.Flux;

import java.util.List;

public class ReservationController {


    public Flux<ReservationEvent> streamReservations(){

        ReservationEvent r1 = new ReservationEvent("1", "Belen", 150.0, List.of("mabe@gmail.com"));
        ReservationEvent r2 = new ReservationEvent("2", "Juan", 0.0, List.of("juan@gmail.com"));
        ReservationEvent r3 = new ReservationEvent("3", "Tannya", 250.0, List.of("tannya@gmail.com"));
        ReservationEvent r4 = new ReservationEvent("4", "Paulo", 100.0, List.of("paulo@gmail.com"));
        ReservationEvent r5 = new ReservationEvent("5", "Alisson", 300.0, List.of("alisson@gmail.com"));
        ReservationEvent defaultReservation =  new ReservationEvent("0", "generico", 20.0, List.of("default@aero.com"));

        return Flux.just(r1, r2, r3, r4, r5)
                .filter(ReservationFilters.isValidReservation)
                .doOnNext(ReservationFilters.printReservation)
                .defaultIfEmpty(defaultReservation);
    }


}
