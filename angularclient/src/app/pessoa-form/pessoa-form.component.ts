import {Component} from '@angular/core';
import {Pessoa} from "../model/pessoa";
import {ActivatedRoute, Router} from "@angular/router";
import {PessoaService} from "../service/pessoa.service";
import {Constants} from "../util/constants";

@Component({
  selector: 'app-pessoa-form',
  templateUrl: './pessoa-form.component.html',
  styleUrls: ['./pessoa-form.component.css']
})
export class PessoaFormComponent {

  pessoa: Pessoa;

  constructor(private route: ActivatedRoute, private router: Router, private pessoaService: PessoaService) {
    this.pessoa = new Pessoa();
  }

  onSubmit() {
    this.pessoa.nascimento = this.formatData(this.pessoa.nascimento);
    this.pessoaService.save(this.pessoa).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/' + Constants.LISTAGEM_PESSOAS]);
  }

  formatData(s: string): string{
    let year = s.charAt(4) + s.charAt(5) + s.charAt(6) + s.charAt(7);
    let month = s.charAt(2) + s.charAt(3);
    let day = s.charAt(0) + s.charAt(1);

    return year + "-" + month + "-" + day + "T02:00:00.001+0000";
  }

}
