import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Phrases} from "./model";

@Injectable({
  providedIn: 'root'
})
export class PhraseService {
  private phrasesUrl : string = '/foi-de-base/assets/data.json'

  constructor(private http: HttpClient) { }

  public getPhrases():Observable<Phrases>{
    // @ts-ignore
    return this.http.get(this.phrasesUrl);
  }
}
