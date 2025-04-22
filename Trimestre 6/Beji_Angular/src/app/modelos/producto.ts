import { Subcategoria } from './subcategoria';

export interface Producto {
  id: number;
  nombre: string;
  descripcion?: string;
  precio_venta: number;
  precio_compra: number;
  cantidad: number;
  talla?: string;
  material?: string;
  color?: string;
  sub_mer: number; // ID de la subcategoría (clave foránea)
  subcategoria?: Subcategoria; // Relación completa, si la estás trayendo anidada
}
