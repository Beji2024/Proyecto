import { Subcategoria } from './subcategoria';

export interface Producto {
  id_pro: number;
  nombre: string;
  cantidad: number;
  precio_venta: number;
  precio_compra: number;
  material: string;
  color: string;
  talla: number;
  sub_mer: number;
  imagen: string;   //  importante
  subcategoria?: any; 
}
