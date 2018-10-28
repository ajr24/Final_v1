import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { FilterPipe } from 'ngx-filter-pipe';
import { TypeaheadModule } from 'ngx-bootstrap'

import { FlightFareService } from '../service/flight-fare.service';
import { AirportService } from '../service/airport.service';
import { Airport } from '../model/airport.model';
import { Fare } from '../model/fare.model';


@Component({
    selector: 'app-flight-fare',
    templateUrl: './flight-fare.component.html',
    styleUrls: ['./flight-fare.component.css']
})

export class FlightFareComponent implements OnInit {

    fare: Fare;
    formSubmitted = false;
    airportsInitialized = false;
    airports: string[];
    selectedDest: string = '';
    selectedOrigin: string = '';

    @ViewChild('orgTxt') orgTxt: ElementRef;

    constructor(private filterPipe: FilterPipe, private flightFareServcie: FlightFareService, private airportService: AirportService) {
    }

    ngOnInit() {
        this.airportsInitialized = false;
        this.airportService.getAirports().subscribe(
            data => {
                this.airports = data;
                this.airportsInitialized = true;
            }
        );
    }

    onSubmit() {
        this.formSubmitted = true;
        // Slice prefix of the origin which is code
        this.flightFareServcie.getFare(this.selectedOrigin.slice(1, 4), this.selectedDest.slice(1, 4)).subscribe(
            data => this.fare = data
        );
    }

    onReset() {
        this.selectedOrigin = '';
        this.selectedDest = '';
        this.fare = null;
    }


}
