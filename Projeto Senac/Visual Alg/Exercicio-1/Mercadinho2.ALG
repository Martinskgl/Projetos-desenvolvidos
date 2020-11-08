Algoritmo "teste3"
// Disciplina  :  [Linguagem e Lógica de Programação] 
// Professor   : ?
// Descrição   : lanchonete
// Autor(a)    : Joao victor da silva martins
// Data atual  : 31/03/2020
Var

continuar:caractere
lanche1:caractere
lanche2:caractere
lanche3:caractere
lanche4:caractere
lanche5:caractere

valor1:inteiro
valor2:inteiro
valor3:inteiro
valor4:inteiro
valor5:inteiro

pedido:inteiro
Quantidade:inteiro





Inicio

lanche1 <- ("torrada simples com presunto e queijo")
   lanche2 <- ("Torrada completa com presunto e queijo")
   lanche3 <- ("Cachorro quente simples - Molho,salsicha e batata palha")
  lanche4 <- ("Cachorro quente completo - Molho,salsicha,milho,ervilha,queijo e batata")
lanche5 <- ("Cheeseburguer completo - Carne,queijo,tomate,cebola,alface,maionese,ketchup e mostarda")
valor1 <- 4
  valor2 <- 5
   valor3 <- 5
  valor4 <- 6
valor5 <- 8
  Escreval("Qual opção você deseja escolhar?")
   Escreval ("Opção 1 ",lanche1)
    Escreval("Opção 2 ", lanche2)
    escreval("Opção 3 ", lanche3)
   Escreval("Opção 4 ", lanche4)
 Escreval("Opção 5 ", lanche5)

escreval ("Qual número do seu pedido?")
leia (pedido)
escreval ("Quantos você deseja?")
leia (quantidade)

escolha pedido
   caso 1
    escreval ( "Você escolheu opção 1 ", lanche1)
    Escreval("O valor é R$ ", quantidade * valor1)
    caso 2
    escreval ( "Você escolheu opção 2 ", lanche2)
    escreval (" valor é R$ ",quantidade * valor2)
    caso 3
    Escreval ("Você escolheu opção 3 ", lanche3)
    Escreval ("O valor é R$ ", quantidade * valor3)
    caso 4
    Escreval ("Você escolheu opção 4 ", lanche4)
    Escreval ( "O valor é R$ ",quantidade * valor4)
    caso 5
    Escreval ("Você escolheu opção 5 ", lanche5)
    Escreval ( "O valor é R$ ", quantidade * valor5)
    fimescolha

Fimalgoritmo