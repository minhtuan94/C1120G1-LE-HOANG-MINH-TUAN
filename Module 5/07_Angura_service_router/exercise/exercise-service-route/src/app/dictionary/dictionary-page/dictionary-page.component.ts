import { Component, OnInit } from '@angular/core';
import {Dictionary} from "../../dictionary";
import {DictionaryService} from "../../service/dictionary.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
dictionary: Dictionary[] = [];
  constructor(private dictionaryService: DictionaryService, private router: Router) { }

  ngOnInit(): void {
    this.dictionary = this.dictionaryService.getAll();
  }

  showDetail(index: number) {
    this.router.navigate(["/detail", index]);
  }
}
