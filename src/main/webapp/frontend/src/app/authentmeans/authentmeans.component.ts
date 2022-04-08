import {Component, Input, OnInit} from '@angular/core';
import {NgbModal, NgbModalConfig} from "@ng-bootstrap/ng-bootstrap";
import {FormBuilder, Validators} from "@angular/forms";
import {saveAs} from "file-saver";
import {AuthentmeansService} from "./authentmeans.service";

@Component({
  selector: 'app-authentmeans',
  templateUrl: './authentmeans.component.html',
  styleUrls: ['./authentmeans.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class AuthentmeansComponent implements OnInit {
  authentMeanses: any;
  authentMeans: any;
  authentMeansAddForm: any;
  authentMeansUpdateForm: any;
  content: any;
  filename = "";

  @Input() isChecked = false;

  constructor(private AuthentmeansService: AuthentmeansService, config: NgbModalConfig, private modalService: NgbModal,
              private formBuilder: FormBuilder) {
    config.backdrop = 'static';
    config.keyboard = false;
  }

  private initializeAddForm() {
    this.authentMeansAddForm = this.formBuilder.group({
      createdBy: ['', Validators.required],
      description: ['', Validators.required],
      lastUpdateBy: ['', Validators.required],
      name: ['', Validators.required],
      updateState: ['', Validators.required],
    });
  }

  private initializeUpdateForm() {
    this.authentMeansUpdateForm = this.formBuilder.group({
      id: ['', Validators.required],
      createdBy: ['', Validators.required],
      description: ['', Validators.required],
      lastUpdateBy: ['', Validators.required],
      name: ['', Validators.required],
      updateState: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.getAuthentmeansList();
    this.initializeAddForm();
    this.initializeUpdateForm();
  }

  updateCrypto({content}: { content: any }) {
    this.modalService.open(content, {size: 'xl', scrollable: true});

  }

  addAuthentmeans({content}: { content: any }) {
    this.modalService.open(content,{size: 'lg', scrollable: true});
    this.reloadData();
  }

  getAuthentmeansById(id: number) {
    this.AuthentmeansService.getAuthentmeans(id).subscribe(cryptoConfig => {
      this.authentMeans = cryptoConfig;
    });
  }

  reloadData() {
    this.authentMeanses = this.getAuthentmeansList();
  }


  getAuthentmeansList() {
    this.AuthentmeansService.getAuthentmeansList().subscribe(cryptoConfigs => {
      this.authentMeanses = cryptoConfigs;
    });
  }

  deleteAuthentmeansById(id: number) {
    this.AuthentmeansService.deleteAuthentmeansById(id).subscribe(response => {
      this.filename = response;
      this.reloadData();
    });
  }

  sendAuthentmeansData() {
    let authentMeansData = this.authentMeansAddForm.value;
    this.AuthentmeansService.sendAuthentmeansData(authentMeansData).subscribe(response => {
      this.filename = response;
      this.reloadData();
    });
  }

  updateAuthentmeans() {
    let authentMeansData = this.authentMeansUpdateForm.value;
    this.AuthentmeansService.updateAuthentmeans(authentMeansData).subscribe(response => {
      console.log(response);
      this.filename = response;
      this.reloadData();
    });
  }

  downloadFile() {
    this.AuthentmeansService.downloadFile(this.filename).subscribe(file => saveAs(file, this.filename));
  }
}
