import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Status } from '../model/status.model';
import {Observable} from 'rxjs/Observable'

@Injectable()
export class StatusService {

    constructor(private http: HttpClient) { }

    resourceUrl: string;

    apiUrl = 'http://localhost:9000/travel/';


    getStatus() : Observable<Status[]> {
        this.resourceUrl = ` ${this.apiUrl}monitor`;
        return this.http.get<Status[]>(this.resourceUrl);
    }



}
