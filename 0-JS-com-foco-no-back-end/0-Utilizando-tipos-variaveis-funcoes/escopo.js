// O JavaScript trabalha com três escopos:

// Global
// Bloco
// Função


let estudante; //acesso global

if (1 > 0) { //escopo de bloco
    estudante = 'Luciana';
    console.log(1,estudante);
}

//estudante = 'Theo';
console.log(2,estudante);


if (1 > 0) {
    let professor = 'Luciana';
    console.log(3,professor);
}

professor = 'Theo'; //JS cria VAR caso se omita o tipo
console.log(4,professor);

//escopo de função
function cumprimentar() {
    const nome = 'Camila'; // variável local
    const cumprimento = 'Olá'; // variável local
    console.log(`${cumprimento}, ${nome}!`); // “Olá, Camila!”
  }
  
  // as variáveis não podem ser acessada de fora da função
  console.log(`${cumprimento}, ${nome}!`); // Dará erro de “not defined” no console
  
