import {Injectable} from '@angular/core';
import {Dictionary} from '../dictionary';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {

  constructor() {
  }

  dictionary: Dictionary[] = [{id: 1, word: "dog", mean: "con chó"}, {id: 2, word: "cat", mean: "con mèo"}, {
    id: 3,
    word: "mouse",
    mean: "con chuột"
  },
    {id: 4, word: "dragon", mean: "con rồng"}, {id: 5, word: "monkey", mean: "con khỉ"}, {
      id: 6,
      word: "snake",
      mean: "con rắn"
    }];

  getAll() {
    return this.dictionary;
  }

  getDictionaryByIndex(id: number): Dictionary {
    for (let dic of this.getAll()) {
      console.log('id nhan dc: ' + id);
      if (dic.id == id) {
        return dic;
      }
      // return this.dictionary.find(item => item.id === id);
    }
  }
}
