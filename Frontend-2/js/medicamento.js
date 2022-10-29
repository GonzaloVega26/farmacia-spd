
const listaBodyMedicamento = document.getElementById("listaBodyMedicamento")

fetch('http://localhost:8080/medicamento/get-all', {
    method: 'GET', // or 'PUT'
  })
    .then((response) => response.json())
    .then((data) => {
        console.log("MEDICAMENTOS")
      console.log('Success:', data);
      getMedicamentoInformation(data)
    })
    
    .catch((error) => {
      console.error('Error:', error);
    });

function getMedicamentoInformation(data){
    let arrayTR =[]
    
        data.forEach(medicamento => {
            console.log(medicamento)
            const tableRow = document.createElement("tr");
            for (const atributo in medicamento) {
                let valor = medicamento[atributo]
                const tableData = document.createElement("td");
                if(atributo == "laboratorio"){
                    tableData.innerHTML = valor.id;
                }else {
                    tableData.innerHTML = valor;
                }
                tableRow.appendChild(tableData);
                arrayTR.push(tableRow)
            }
            listaBodyMedicamento.replaceChildren(...arrayTR); //Spread -Operator no se como funciona pero funciona;
        });
    
}