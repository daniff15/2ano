%% Exercicio 1
clear all;
close all;

load Mensagem.mat;
Mensagem
Simbolos = Alfabeto1(Mensagem);

[Simbolos , Frequencia] = Alfabeto2(Mensagem);
[Frequencia , idx] = sort(Frequencia , 'descend');


%% Eexercicio 3

%Numero de estados = length(Simbolos) = 9 
%Para termos o numero de bits necessarios para representar estes codigos
%Fazemos log2(9) = 3,15, arrendodamos para cima dando 4 bits para cada
%codigo
% C = 0000
% D = 0001
% Q = 0010
% R = 0011
% S = 0100
% V = 0101
% W = 0110
% X = 0111
% Z = 1000
% Para terem todos os numeros de bits tem de ter 4 todos sendo 4*9 o menor
% numero de bits possivel
% Quanto à ambiguidade concluimos que é nao ambiguo, pois têm todos o mesmo
% numero de bits e todos os codigos sao diferentes, logo a cada 4 bits
% corresponde um Simbolo.
% Quanto à instantaniedade, podemos concluir que é instantaneo, porque
% visto que caso o codigo comece no bit 0 temos de esperar pelos 3 bits
% seguintes para sabermos a q codigo se refere, Caso comece em 1 sabemos
% que vai corresponder ao codigo de Z


%% Exercico 4

NumBits = NumeroBits(Mensagem)

% O codigo binario gerado nao é ambiguo pois todas as combinaçoes terminam
% em 0 e sao diferentes, logo se comecar em 0 temos um codigo possivel para
% o caracter que tem mais frequencia, caso comece em 1 temos de esperar
% pelo proximo 0 para ver qual é o codigo, visto que so ha uma solucao possivel, não havendo ambiguidade.
% Em termos de instantaneidade, Nao é instantaneo visto que sempre que
% surge novo bit 1 é ncessario esperar pelos bits seguintes para se
% identificar a chegada de um novo simbolo.

%Caso as frequencias das letras variar muito de umas para as outras, o
%codigo mais eficiente, é o do codigo do exercício 4, mas caso as
%frequencias das letras forem relativamente parecidas e se o tamanho da string for muito grande,
%o codigo mais eficiente é o do exercicio 3.
%% Exercicio 6

H = Entropia(Mensagem)
