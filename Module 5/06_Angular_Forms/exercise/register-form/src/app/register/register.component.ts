import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public registers: FormGroup;
  public comparePassword(c: AbstractControl) {
    const v = c.value;
    return (v.registerPassword === v.registerConfirmPassword) ? null : {
      passWordDoNotMatch: true
    };
  }
  constructor(private _fb:FormBuilder) { }

  ngOnInit(): void {
    this.registers = this._fb.group({
    registerEmail: ['',[Validators.required],[Validators.email]],
      pwGroup: this._fb.group({
        registerPassword: '',
        registerConfirmPassword: ''
      }, {validators: this.comparePassword}),
    registerCountry:['',Validators.required],
    registerAge : ['',[Validators.required, Validators.min(18)]],
    registerGender : ['',Validators.required],
    registerPhone : ['',[Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]]
});

  }

  onSubmit() {
    console.log(this.registers.value)
  }
}
