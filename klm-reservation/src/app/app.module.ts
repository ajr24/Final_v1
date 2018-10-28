import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { TypeaheadModule } from 'ngx-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { FilterPipeModule } from 'ngx-filter-pipe';

import { AppComponent } from './app.component';
import { FlightFareComponent } from './flight-fare/flight-fare.component';
import { MonitorListComponent } from './monitor-list/monitor-list.component';
import { HomeComponent } from './home/home.component';
import { FlightFareService } from './service/flight-fare.service';
import { StatusService } from './service/status.service';
import { AirportService } from './service/airport.service';

@NgModule({
  declarations: [
    AppComponent,
    FlightFareComponent,
    MonitorListComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    FilterPipeModule,
    HttpClientModule,
    ReactiveFormsModule,
    TypeaheadModule.forRoot()
  ],
  providers: [FlightFareService, AirportService, StatusService],
  bootstrap: [AppComponent]
})
export class AppModule { }
