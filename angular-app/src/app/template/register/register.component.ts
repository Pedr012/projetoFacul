import { Component } from '@angular/core';

import axios from 'axios';

@Component({
    selector: 'app-register',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
    public message: string
    public htmlScrolled: string

    public name: string
    public birth: string
    public sex = "Masculino"
    public phone: string
    public email: string
    public cpf: string
    public cep: string
    public address: string
    public number: number
    public password: string
    public repeatPassword: string

    choose(event: Event) {
        const target = event.target as HTMLButtonElement
        const bubble = document.querySelector('.bubble') as HTMLDivElement

        this.sex = target.innerText
        const locale = target.innerText === 'Masculino' ? 'left' : 'right'
        bubble.classList.remove('left')
        bubble.classList.remove('right')
        bubble.classList.add(locale)
    }

    findAddress() {
        let adjustment = this.cep
        adjustment = this.cep.replace(/\D/g, '')
        if (this.cep && adjustment.match(/^(\d{8})$/)) {
            axios.get(`https://viacep.com.br/ws/${this.cep}/json`)
                .then(response => {
                    this.address = response.data.logradouro
                })
        }
    }

    registerUser() {
        let dateBirth: Date
        if (this.birth) {
            const [day, month, year] = this.birth.split('/')
            dateBirth = new Date(parseInt(year), parseInt(month) - 1, parseInt(day))
        }

        const user = {
            name: this.name,
            birth: dateBirth,
            sex: this.sex,
            phone: this.phone,
            email: this.email,
            cpf: this.cpf,
            address: this.address,
            number: this.number,
            password: this.password
        }

        axios.post('http://localhost:8080/patients', user)
            .then(response => this.message = response.data)
            .catch(error => this.message = error.response.data)

        const html = document.querySelector("html") as HTMLHtmlElement
        this.htmlScrolled = `calc(${html.scrollTop}px + 4rem)`

        setTimeout(() => {
            this.message = null
        }, 2200)
    }
}
