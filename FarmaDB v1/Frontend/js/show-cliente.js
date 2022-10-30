/* MOSTRAR CLIENTES */
const tableBodyCliente = document.getElementById("listaBodyCliente");

fetch('http://localhost:8080/cliente/get-all', {
    method: 'GET', // or 'PUT'
    
  })
    .then((response) => response.json())
    .then((data) => {
        console.log('CLIENTES')
        console.log('Success:', data);
		console.log(data.length);
      getClienteInformation(data,tableBodyCliente)
    })
    
    .catch((error) => {
      console.error('Error:', error);
    });

function getClienteInformation(data,tabla){
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