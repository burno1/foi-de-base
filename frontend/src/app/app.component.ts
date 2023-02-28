import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {PhraseService} from "./phrase.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'f no chat';

  constructor(private http: HttpClient, private phrasesService: PhraseService) {
  }

  ngOnInit(): void {
    this.phrasesService.getPhrases().subscribe(({phrases}) => {
      this.title = phrases[this.getRandomInt(phrases.length-1)]
    })

  }

  getRandomInt(max:number):number  {
    const min = 0;
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min) + min); // The maximum is exclusive and the minimum is inclusive
  }


}
