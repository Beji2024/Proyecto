import { Subcategoria } from './subcategoria';

export interface Producto {
  id_pro: number;            // coincide con tu PK en migración
  cantidad: number;
  nombre: string;
  talla: number;             // según tu definición en la migración
  precio_venta: number;
  precio_compra: number;
  material: string;
  color: string;
  sub_mer: number;           // FK a subcategoría
  subcategoria?: Subcategoria; // si traes la relación con with()
}
