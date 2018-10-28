import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Fare } from '../model/fare.model';
import {Observable} from 'rxjs/Observable'

@Injectable()
export class FlightFareService {

    constructor(private http: HttpClient) { }

    returnFare: Fare;
    resourceUrl: string;

    apiUrl = 'http://localhost:9000/travel/';


    getFare(source, destination):Observable<Fare> {
        this.resourceUrl = ` ${this.apiUrl}fares/` + `${source}` + `/${destination}`;
        return this.http.get<Fare>(this.resourceUrl);
    }


}
