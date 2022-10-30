const tableBodyEmpleados = document.getElementById("listaBodyEmpleados");

//Carga Inicial de todos los datos 
fetch('http://localhost:8080/empleado/get-all', {
    method: 'GET', // or 'PUT'
    
  })
    .then((response) => response.json())
    .then((data) => {
      console.log('Success:', data);
      getEmpleadoInformation(data,tableBodyEmpleados)
    })
    
    .catch((error) => {
      console.error('Error:', error);
    });

function getEmpleadoInformation(data,tabla){
    let arrayTR =[]
    if(!data.length) {
        tabla.replaceChildren(...[])
        return undefined;
    }else{
        data.forEach(empleado => {
            const tableRow = document.createElement("tr");
            for (const atributo in empleado) {
                let valor = empleado[atributo]
                const tableData = document.createElement("td");
                if(atributo == "domicilio" || atributo === "genero"){
                    tableData.innerHTML = valor.id;
                }else {
                    tableData.innerHTML = valor;
                }
                tableRow.appendChild(tableData);
                arrayTR.push(tableRow)
            }
            tabla.replaceChildren(...arrayTR); //Spread -Operator no se como funciona pero funciona;
        });
    }
    
}


const inputIdDomicilio = document.getElementById("inputDomicilio");
const tableBodyEmpleadosFiltrado = document.getElementById("listaBodyEmpleadosFiltrada");

inputIdDomicilio.addEventListener("keyup", ({ key }) => {
  if (key === "Enter") {
    const idDomicilioBuscado = inputIdDomicilio.value;
    if(idDomicilioBuscado){
        fetch(
          "http://localhost:8080/empleado/get-query/" + idDomicilioBuscado
        )
          .then((response) => response.json())
          .then((data) => {
            console.log('Success:', data);
            getEmpleadoInformation(data,tableBodyEmpleadosFiltrado)
          });
      }
    }
});
