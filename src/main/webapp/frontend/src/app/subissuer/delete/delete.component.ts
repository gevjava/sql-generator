import {Component, OnInit} from '@angular/core';
import {DeleteService} from "./delete.service";
import {ActivatedRoute} from "@angular/router";
import {saveAs} from "file-saver";
import {FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  code: any;
  subIssuer: any;
  filename: string = "";
  subIssuerForm: any;

  constructor(
    private service: DeleteService,
    private router: ActivatedRoute,
    private formBuilder: FormBuilder
  ) {
  }

  ngOnInit(): void {
    this.code = this.router.snapshot.paramMap.get("code");
    this.initializeForm();
    this.getByCode(this.code)
  }

  delete() {
    console.log(this.subIssuerForm);
    let subIssuerData = this.subIssuerForm.value;
    this.service.deleteSubissuer(subIssuerData, this.code).subscribe(response => {
      this.filename = response;
    });
  }

  downloadFile() {
    this.service.downloadSqlFile(this.filename).subscribe(file => saveAs(file, this.filename));
  }


  getByCode(code: any) {
    this.service.getByCodeSubissuer(code).subscribe(resposne => {
      this.subIssuer = resposne;
    });
  }

  initializeForm() {
    this.subIssuerForm = this.formBuilder.group({
      name: ['', Validators.required],
      label: ['', Validators.required],
      code: ['', Validators.required]
    });
  }
}

// export class EditComponent implements OnInit {
//
//   code: any;
//   subIssuerForm: any;
//   filename: string = "";
//   subIssuer: any;
//
//   constructor(
//     private service: EditService,
//     private route: ActivatedRoute,
//     private formBuilder: FormBuilder) {
//   }
//
//   ngOnInit(): void {
//     this.code = this.route.snapshot.paramMap.get("code");
//     this.getByCode(this.code)
//     this.initializeForm();
//   }
//
//   updateSubIssuerData() {
//     console.log(this.subIssuerForm);
//     let subIssuerData = this.subIssuerForm.value;
//     this.service.edit(subIssuerData, this.code).subscribe(response => {
//       this.filename = response;
//     });
//   }
//
//   getByCode(code:any) {
//     this.service.getByCodeSubissuer(code).subscribe(resposne => {
//       this.subIssuer = resposne;
//     });
//   }
//
//   initializeForm() {
//     this.subIssuerForm = this.formBuilder.group({
//       acsId: ['', Validators.required],
//       authenticationTimeOut: [0, [Validators.required, Validators.pattern("^[0-9]*$")]],
//       defaultLanguage: ['', Validators.required],
//       codeSvi: ['', Validators.required],
//       currencyCode: ['', Validators.required],
//       name: ['', Validators.required],
//       authentMeans: ['', Validators.required],
//       label: ['', Validators.required],
//       personnalDataStorage: [0, Validators.required],
//       code: ['', Validators.required]
//     });
//   }
//
//   downloadFile() {
//     this.service.downloadSqlFile(this.filename).subscribe(file => saveAs(file, this.filename));
//   }
//
// }
