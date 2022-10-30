const inputDNI = document.getElementById("clienteDNI");

inputDNI.addEventListener("keyup", ({ key }) => {
  if (key === "Enter") {
    const dniClienteBuscado = inputDNI.value;
    console.log(dniClienteBuscado)
    if (dniClienteBuscado) {
      fetch("http://localhost:8080/cliente/get-one-dni/" + dniClienteBuscado)
        .then((response) => response.json())
        .then((cliente) => {
          console.log("Success:", cliente);
          llenarFormulario(cliente);
        })
        .catch((error) => {
          console.log(error);
          console.log("Usuario NO encontrado");
        });
    }
  }
});

// ELEMENTOS DEL FORMULARIO
const clienteNombre = document.getElementById("clienteNombre");
const clienteApellido = document.getElementById("clienteApellido");
const clienteFechaNac = document.getElementById("clienteFechaNac");
const clienteMail = document.getElementById("clienteMail");
const clienteTel = document.getElementById("clienteTel");
const clienteDireccion = document.getElementById("clienteDireccion");
const clienteCP = document.getElementById("clienteCP");
const departamentoSelect = document.getElementById("clienteDepto");
const pronvinciaSelect = document.getElementById("clienteProvincia");
const obraSocialSelect = document.getElementById("clienteOS");

function llenarFormulario(cliente) {
  clienteNombre.value = cliente.nombre;
  clienteApellido.value = cliente.apellido;
  clienteFechaNac.value = cliente.fechaNacimiento;
  clienteMail.value = cliente.mail;
  clienteTel.value = cliente.telefono;
  clienteDireccion.value = cliente.domicilio.calle + " " + cliente.domicilio.numero;
  clienteCP.value = cliente.domicilio.cp;

  //Select Departamento
  departamentoSelect.replaceChildren(...[]);
  const optionDepto = document.createElement("option");
  optionDepto.innerText = cliente.domicilio.departamento;
  departamentoSelect.appendChild(optionDepto);
  //Select Provincia
  const pronvinciaSelect = document.getElementById("clienteProvincia");
  pronvinciaSelect.replaceChildren(...[]);
  const optionPronvincia = document.createElement("option");
  optionPronvincia.innerText = cliente.domicilio.provincia;
  pronvinciaSelect.appendChild(optionPronvincia);

 
  const OSArray = cliente.obrasSociales;
  const planesObraSocialSelect = document.getElementById("planesOS");
  OSArray.forEach((OS) => {
    const optionOS = document.createElement("option");
    optionOS.innerText = OS.nombre;
    obraSocialSelect.appendChild(optionOS);
    const planesOSArray = OS.planesObrasSociales;
    planesOSArray.forEach((POS) => {
      const optionPOS = document.createElement("option");
      optionPOS.innerText = POS.descripcion;
      planesObraSocialSelect.appendChild(optionPOS);
    });
  });
}

const guardarBtn = document.getElementById("guardarCliente");
guardarBtn.addEventListener("click",  () => {
   crearDomicilio()

});


 function crearDomicilio(){
    const numero = clienteDireccion.value.split(" ").at(-1)
    const calle = clienteDireccion.value.replace(numero,"")
    const domicilio = {
        calle: calle,
        numero: numero,
        provincia: pronvinciaSelect.options[pronvinciaSelect.selectedIndex].text,
        departamento:departamentoSelect.options[departamentoSelect.selectedIndex].text,
        cp: clienteCP.value
    }
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
          crearCliente (data.id);
        })
        .catch((error) => {
          console.error('Error:', error);
        });
}

function crearCliente(idDomicilio){
    
  const cliente ={
    nombre : clienteNombre.value,
    apellido : clienteApellido.value,
    fechaNacimiento: clienteFechaNac.value,
    mail: clienteMail.value,
    dni: inputDNI.value,
    telefono:clienteTel.value,
    idDomicilio: idDomicilio,
    idGenero: 3
  }
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
    .catch((error) => {
      console.error('Error:', error);
    });
}