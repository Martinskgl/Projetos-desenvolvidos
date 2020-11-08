Algoritmo "teste2"
// Disciplina  :  [Linguagem e Lógica de Programação] 
// Professor   : ?
// Descrição   : Contabilizar horas trabalhadas
// Autor(a)    : Joao victor da silva martins
// Data atual  : 30/03/2020
Var

nomecolaborador:caractere
codigosetor1:real
codigosetor2:real
codigosetor3:real
codigosetor4:real
setorfuncionario:real
horastrabalhadas:real


Inicio

codigosetor1 <- 20,00
codigosetor2 <- 28,00
codigosetor3 <- 35,00
codigosetor4 <- 48,00

    Escreval ("Nome funcionário")
       leia(nomecolaborador)
          Escreval("Setor funcionário")
       leia(setorfuncionario)
       Escreval("Horas trabalhadas do funcionário")
leia(horastrabalhadas)

se (setorfuncionario = 1) entao
      escreval("salário R$", horastrabalhadas * codigosetor1)
       fimse
       se(setorfuncionario = 2) entao
          Escreval("Salário R$", horastrabalhadas * codigosetor2)
            fimse
           se (setorfuncionario = 3) entao
             Escreval("Salário R$", horastrabalhadas * codigosetor3)
               fimse
                 se(setorfuncionario = 4) entao
                   Escreval("Salário R$", horastrabalhadas * codigosetor4)
                    Fimse


Fimalgoritmo