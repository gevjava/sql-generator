import {Component, OnInit} from '@angular/core';
import {RuleConditionService} from "./rule-condition.service";
import {FormBuilder, Validators} from "@angular/forms";
import {saveAs} from "file-saver";
import {RuleService} from "../rule/rule.service";

@Component({
  selector: 'app-rulecondition',
  templateUrl: './rule-condition.component.html',
  styleUrls: ['./rule-condition.component.css']
})
export class RuleConditionComponent implements OnInit {

  conditions: any;
  conditionForm: any;
  rules: any;
  filename: string = "";

  constructor(private conditionService: RuleConditionService,
              private formBuilder: FormBuilder,
              private ruleService: RuleService
  ) { }

  ngOnInit(): void {
    this.initializeForm();
    this.getAllConditions();
    this.index();
  }

  sendRuleConditionData(){
    console.log(this.conditionForm);
    let conditionData = this.conditionForm.value;
    this.conditionService.sendData(conditionData).subscribe(response => {
      this.filename = response;
    });
  }


  initializeForm() {
    this.conditionForm = this.formBuilder.group({
      description: ['', Validators.required],
      name: ['', Validators.required],
      updateState: ['', Validators.required],
      rule_id: ['', Validators.required]
    });
  }

  getAllConditions(){
    this.conditionService.getAllConditions().subscribe(condition =>{
      this.conditions = condition;
    });
  }

  downloadFile() {
    this.conditionService.downloadSqlFile(this.filename).subscribe(file => saveAs(file, this.filename));
  }

  index(){
    this.ruleService.getAllRules().subscribe(response => {this.rules = response});
  }
}
