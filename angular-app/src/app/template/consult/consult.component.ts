import { Component, OnInit } from '@angular/core';

import axios from 'axios';

@Component({
  selector: 'app-consult',
  templateUrl: './consult.component.html',
  styleUrls: ['./consult.component.scss']
})
export class ConsultComponent implements OnInit {

  public myLocation: string
  public now: string
  public clinics: [{
    id: number,
    name: string,
    location: string,
    formatedLocation: string,
    distance: string,
    value: number
  }]


  async ngOnInit() {
    this.myLocation = "Av. Angélica, 2565"
    this.now = this.nowDate()
    await axios.get('http://localhost:8080/clinics?address=' + this.myLocation)
      .then(response => {
        this.clinics = response.data
      }) 
  }

  nowDate() {
    const date = new Date()
    const year = date.getFullYear()
    const month = date.getMonth() > 10
      ? date.getMonth()
      : '0' + (date.getMonth() + 1)
    const day = date.getDate() > 10
      ? date.getDate()
      : '0' + date.getDate()
    const fullDate = `${year}-${month}-${day}`
    
    return fullDate
  }

  chooseClinic(event: Event) {
    const target = event.target as HTMLElement
    if(target.nodeName === 'TR') {
      const input = target.querySelector("input") as HTMLInputElement
    }
  }
}
