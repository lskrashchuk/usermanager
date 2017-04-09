import {Component, OnInit} from "@angular/core";
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {SearchService} from "./search.service";


@Component({
  selector: 'search-component',
  templateUrl: './search.component.html',
  styleUrls: ['../main.css'],

  providers: [ SearchService ]
})
export class SearchComponent implements OnInit {
  searchForm: FormGroup;
  loading: boolean = false;
  error: string = '';

  constructor(private searchService: SearchService, private router: Router) {
  }

  ngOnInit(): void {
    this.searchForm = new FormGroup({
      search: new FormControl('', Validators.required)
    });
  }

  onSubmit() {
    this.loading = true;
/*
    this.searchService.search(this.searchForm.value.search)
      .subscribe(
        result => result && this.router.navigate(['/']),
        error => {
          this.error = <any>error;
          this.loading = false;
        }
      );
*/
  }

}
