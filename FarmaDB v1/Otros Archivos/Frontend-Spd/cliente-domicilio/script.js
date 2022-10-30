
const boton = document.getElementById("send-formulario");
boton.addEventListener("click",()=>{
  cargarFormulario()
});
  const domicilio = {
    provincia: "Mendoza",
    departamento: "Maipu",
    cp: 5513,
    calle: "Base Esperanza",
    numero: 1841,
    observaciones: ""
  
}
const cliente = {
  nombre: "Gonzalo",
  apellido: "Vega",
  dni: 40370142,
  fechaNacimiento: "26/02/1997",
  mail: "31gonzalovega@gmail.com",
  telefono: 2616954988,
  
}
async function cargarFormulario(){
  await crearDomicilio();
 

}

async function crearDomicilio(){
  fetch('http://localhost:8080/domicilio/create-domicilio', {
    method: 'POST', // or 'PUT'
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(domicilio),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log('Success:', data);
      cliente.idDomicilio = data.id;
    })
    .then(()=>{
      crearCliente();
    })
    .catch((error) => {
      console.error('Error:', error);
    });
}

async function crearCliente(){
  fetch('http://localhost:8080/cliente/create-cliente', {
    method: 'POST', // or 'PUT'
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(cliente),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log('Success:', data);
      
    })
    .then(()=>{
        window.location.href = "../index.html";
    })
    .catch((error) => {
      console.error('Error:', error);
    });
}
  