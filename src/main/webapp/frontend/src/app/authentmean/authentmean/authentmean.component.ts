import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {saveAs} from "file-saver";
import {AuthentmeanService} from "./authentmean.service";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-authentmean',
  templateUrl: './authentmean.component.html',
  styleUrls: ['./authentmean.component.css'],
  providers: [DatePipe]
})
export class AuthentmeanComponent implements OnInit {

  means: any;
  meanForm: any;
  filename: string = "";
  nowDate = new Date();


  constructor(private meanService: AuthentmeanService, private formBuilder: FormBuilder, private datePipe: DatePipe) {
  }

  ngOnInit(): void {
    this.initializeForm();
    this.getAllMeans();
  }

  sendMeanData() {
    let meanData = this.meanForm.value;
    this.meanService.sendData(meanData).subscribe(response => {
      this.filename = response;
    })
  }

  initializeForm() {
    let currentDateTime = this.datePipe.transform(this.nowDate, 'MM/dd/yyyy hh:mm:ss');
    this.meanForm = this.formBuilder.group({
      createdDate: [currentDateTime, Validators.required],
      createdBy: ['', Validators.required],
      description: ['', Validators.required],
      lastUpdateBy: ['', Validators.required],
      name: ['', Validators.required],
      updateState: ['', Validators.required]
    });
  }

  getAllMeans() {
    this.meanService.getAllMeans().subscribe(means => {
      this.means = means;
    });
  }

  downloadFile() {
    this.meanService.downloadSqlFile(this.filename).subscribe(file => saveAs(file, this.filename));
  }
}
