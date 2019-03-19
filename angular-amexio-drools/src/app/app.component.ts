import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-amexio-drools';

  model: RechargeModel;
  connectionTypeDate: any[];

  constructor(private http: HttpClient) {
    this.model = new RechargeModel();
    this.connectionTypeDate = [];
    this.connectionTypeDate.push({'valuefield':1,'displayfield':'Postpaid'});
    this.connectionTypeDate.push({'valuefield':2,'displayfield':'Prepaid'});
  }

  finalStage(event:any){
    debugger;
    console.log(event);
    this.http.post("http://localhost:8081/api/execute",event.recharge).subscribe((resp)=>{
      this.model = Object.assign(resp);
    });
  }
}

class RechargeModel {
  mobileNo: number;
  name: String;
  connectionType: number;
  rechargeAmount: number;
  discount: number;
  payableAmount: number;
}