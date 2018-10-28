import { Component, OnInit } from '@angular/core';
import { StatusService } from '../service/status.service';
import { Status } from '../model/status.model';
@Component({
  selector: 'app-monitor-list',
  templateUrl: './monitor-list.component.html',
  styleUrls: ['./monitor-list.component.css']
})
export class MonitorListComponent implements OnInit {

  constructor(private statusService: StatusService) { }

  status: Status[];
    
  ngOnInit() {
      this.statusService.getStatus().subscribe(
            data => {
            this.status = data;
            }
        );
  }

}
