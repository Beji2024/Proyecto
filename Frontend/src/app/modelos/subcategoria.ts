import { Categoria } from './categoria';

export interface Subcategoria {
  id_sub: number;
  nom_sub: string;
  cat_sub: number;
  categoria?: Categoria; //  Agrega esta línea para que Angular lo reconozca
}
