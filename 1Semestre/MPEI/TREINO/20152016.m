%MATRIZ COM ORDEM LEXICOGRÁFICA (???)
H = [0 1/4 1/4 1/4 1/4 0;
    0 1/3 0 1/3 0 1/3;
    1/2 1/2 0 0 0 0;
    0 1/2 0 0 1/2 0;
    1/2 1/2 0 0 0 0;
    1/5 1/5 1/5 1/5 1/5 0]';

%% Pergunta a)
% Estimativa page rank ao fim de 3 iteraçoes
r_0 = 1/6*ones(6 , 1); % Vetor inicial
r_3 = H^3 * r_0
%sum(r_3) - verificacao para se ver se se esta a perder alguma info
%se der um nao se perdeu nada e tamos a fazer bem, somos os maiores
%Viva Portugal

%% b)

% represente num grafico a estimativa do page rank

N = 100; %tanto faz desde que seja suficiente
r_final = H ^N * r_0;

N = 101;
r_final2 = H ^N * r_0;

[r_final r_final2]
%Para vermos a diferenca das casas decimais podiamos fazer 
%r_final - r_final2 e ver em que ordem em quais é q eram diferentes
%Podemos concluir que para N = 100 ja atingiu o estado estacionario

%% c)

N = 100;
r_n = zeros(length(r_0), N);
r = r_0;

for k = 1: N
   r = H*r;
   r_n(:,k) = r;
end

plot(1:N , r_n);
title("pageRank em funçao do numero de iteracoes")
xlabel("Iteração");
ylabel("pageRank");
legend('A', 'B', 'C' , 'D', 'E' , 'F');
%Grafico deu diferente do stor xD
%Alguma merda deve tar mal, provavelmente os valores

%Se quisessemos saber o maior pageRank
%% c)
[maximo , idx_max] = max(r_n(:, 100)) %acho eu
%Se quisessemos saber o maior pageRank

%% Exercício 2
% PROBLEMA DO TERRORISTA
% Matriz da forma canónica
% Vamos meter os estados absorventes no fim
% Estado -> país
% 1- Iraque
% 2 - Franca
% 3 - Suíça
% 4 - Brasil
% 5 - EUA
% 6 - Israel

Al_Qaeda = [0.7 0.2 0 0.1 0 0;
    0.1 0 0.6 0.3 0 0;
    0 0.3 0.1 0.4 0.2 0;
    0 0 0 0.1 0.4 0.5;
    0 0 0 0 0 1;
    0 0 0 0 0 1]';

atual = [0 1/2 1/2 0 0 0];

%% Exercicio 2b)

% Valor esperado do numero de meses necessarios para um terrorista
% inicialmente no iraque vir  terminar os seus dias em Israel ou nos EUA

%Transicoes entre estados nao absorventes 4 linhas e 4 colunas

Q = Al_Qaeda(1:4, 1:4);

F = inv(eye(length(Q)) - Q);

%Somas das colunas da nos o tempo media ate à absorcao

tMedioAteAAbsorcao = sum(F(: , 1))

%% 2C) 

%terrorista no iraque estar nos estados unidos passados 5 meses 
%terrorista no brasil e estar no israel passado 50 meses

T5meses = Al_Qaeda^5;
T50meses = Al_Qaeda^50;
%versao 1
fprintf('P(Iraque->EUA em 5 meses) = %.3f\n' , T5meses(5 , 1));
%versao 2
%v5 = T5 .* [1 0 0 0 0 0]'; 
%fprintf('P(Iraque->EUA em 5 meses) = %.3f\n' , v5(5 , 1));
%nao funcemina



