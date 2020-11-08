Algoritmo "teste7"

                      //
//
// Descrição   : Calcule nota final aluno
// Autor(a)    : Joao victor da silva martins
// Data atual  : 31/03/2020

Var

     avaliacao1:inteiro
     avaliacao2:inteiro
     avaliacao3:inteiro
     totalnotaaluno:inteiro
     totalavaliacao:inteiro
     notafinal:inteiro
Inicio

Escreval("Digite nota da avaliação 1")
leia(avaliacao1)
Escreval ("Digite nota da avaliação 2")
leia(avaliacao2)
Escreval ("Digite nota da avaliação 3")
leia(avaliacao3)

totalavaliacao <- 3
  totalnotaaluno <- avaliacao1 + avaliacao2 + avaliacao3

 notafinal <-totalnotaaluno\totalnotaaluno
 
 Escreval("Sua média é", notafinal)


Fimalgoritmo