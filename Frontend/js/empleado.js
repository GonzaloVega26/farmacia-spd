const tableBodyEmpleados = document.getElementById("listaBodyEmpleados");

fetch('http://localhost:8080/empleado/get-all', {
    method: 'GET', // or 'PUT'
  })
    .then((response) => response.json())
    .then((data) => {
      getEmpleadoInformation(data)
    })
    .catch((error) => {
      console.error('Error:', error);
    });

function getEmpleadoInformation(data){
    
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
        }
        tableBodyEmpleados.appendChild(tableRow);
    });
}

function getEmpleadosByIdDomicilio(){
    let idDomicilio = document.getElementById()
    fetch('http://localhost:8080/empleado/get-query/'+idDomicilio, {
        method: 'GET', // or 'PUT'
      })
        .then((response) => response.json())
        .then((data) => {
          getEmpleadoInformation(data)
        })
        .catch((error) => {
          console.error('Error:', error);
        });
}

    // <tr>
	// 						<th scope="row">001</th>
	// 						<td>Ignacio</td>
	// 						<td>Ramet</td>
	// 						<td>22/09/2000</td>
	// 						<td>40246358</td>
	// 						<td>ignacioramet@gmail.com</td>
	// 						<td>261 602 6369</td>
	// 						<td>$ 89,669.00</td>
	// 						<td>Noche</td>
	// 						<td>316</td>
	// 						<td>01</td>
	// 					  </tr>