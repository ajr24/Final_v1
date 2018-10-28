import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Airport } from '../model/airport.model';
import {Observable} from 'rxjs/Observable'

@Injectable()
export class AirportService {

    constructor(private http: HttpClient) { }

    airport: Airport[];
    
    resourceUrl: string;

    apiUrl = 'http://localhost:9000/travel/';


     getAirports() : Observable<any> {
        this.resourceUrl = ` ${this.apiUrl}airports`;
        return this.http.get<any>(this.resourceUrl);
    }
    
   /* getAirports() : Observable<Airport[]> {
        this.resourceUrl = ` ${this.apiUrl}airports`;
        return this.http.get<Airport[]>(this.resourceUrl);
    }*/


}
