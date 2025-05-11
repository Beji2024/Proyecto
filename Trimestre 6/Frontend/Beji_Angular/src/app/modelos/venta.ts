export interface Venta {
    id: number;
    nombre_cli: string;
    direccion_cli: string;
    correo_cli: string;
    num_tel_cli: string;
    num_doc_cli: string;
    cantidad: number;
  
    producto_id: number;
    vendedor_id: number;
  
    producto: {
      id: number;
      nombre: string;
      precio: number;
    };
  
    vendedor: {
      id: number;
      nombres: string;
      apellidos: string;
    };
  }