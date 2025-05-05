export interface Usuario {
    id: number;
    num_doc: string;
    nombres: string;
    apellidos: string;
    direccion: string;
    email: string;
    num_tel: string;
    fec_nac: string; 
    password: string;
    tipodoc_id: number;
    rol_id: number;
    tipodoc: {
        id: number;
        name : string;
    }
    rol: {
        id: number;
        name: string;
      };

}

