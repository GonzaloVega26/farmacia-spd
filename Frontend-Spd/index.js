let clientes=[];
const lista = document.getElementById("lista-clientes")

fetch('http://localhost:8080/cliente/get-all')
  .then((response) => response.json())
  .then((data) =>{
    clientes = data;
    console.log(data);
    
  })
  .then(()=>{
    fillList()
  }) 

  

  function fillList(){
    clientes.forEach(element => {
      console.log(element)
      const listItem = document.createElement("li");
      listItem.appendChild(document.createTextNode(element.nombre + "  " + element.apellido + " " + element.dni + " " + element.fechaNacimiento + " " + element.mail));
      lista.appendChild(listItem);
    });
  }
