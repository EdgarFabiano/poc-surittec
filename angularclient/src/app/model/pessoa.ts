import {Endereco} from "./endereco";

export class Pessoa {

  id: string;
  nome: string;
  cpf: string;
  nascimento: string;
  curriculo: string;
  enderecos: Array<Endereco>;

}
