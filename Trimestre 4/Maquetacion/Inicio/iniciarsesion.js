const usuario1 = {
    nombre: 'vendedor',
    contraseña:'vendedor',
    nombrea: 'admin',
    contraseñaa: 'admin',
    nombreb: "bodeguero",
    contraseñab: "bodeguero"
};

document.getElementById('ingreso').addEventListener('submit',function(event){
    event.preventDefault();

    const inputNombre = document.getElementById('user').value;
    const inputContraseña = document.getElementById('contra').value;

    if (inputNombre === usuario1.nombre && inputContraseña === usuario1.contraseña && inputNombre !== usuario1.nombrea && inputContraseña !== usuario1.contraseñaa){

        window.location.href = '../Vendedor/pagina.html';
    }
    else if(inputNombre === usuario1.nombrea && inputContraseña === usuario1.contraseñaa && inputNombre !== usuario1.nombre && inputContraseña !== usuario1.contraseña){
        window.location.href = '../Administrador/pagina.html';
    }
    else if(inputNombre === usuario1.nombreb && inputContraseña === usuario1.contraseñab && inputNombre ){
        window.location.href = '../Bodeguero/pagina.html';
    }
    else {
    
        window.location.href = 'ingresom.html';
    }
});




