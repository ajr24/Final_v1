import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { FlightFareComponent } from './flight-fare/flight-fare.component';
import { MonitorListComponent } from './monitor-list/monitor-list.component';

const routes: Routes = [
  {path:'flight', component: HomeComponent},
  {path:'fare', component: FlightFareComponent},
  {path:'list', component: MonitorListComponent}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
