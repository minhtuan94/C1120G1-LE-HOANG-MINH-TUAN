import { Component, OnInit } from '@angular/core';
import {Dictionary} from "../../dictionary";
import {ActivatedRoute} from "@angular/router";
import {DictionaryService} from "../../service/dictionary.service";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
public dictionaryList: Dictionary;
  constructor(private activatedRoute: ActivatedRoute, private dictionaryService: DictionaryService) { }

  ngOnInit(): void {
    let index = this.activatedRoute.snapshot.params['id'];
    console.log('id:' + index);
    this.dictionaryList = this.dictionaryService.getDictionaryByIndex(index);
  }

}
