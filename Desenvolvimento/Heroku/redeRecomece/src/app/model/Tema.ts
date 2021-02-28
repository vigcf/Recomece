import { Postagem } from "./Postagem";

export class Tema{
    public idTema: number;
    public categoria: string;
    public nome: string;
    public postagem: Postagem[]
}