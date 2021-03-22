%% Exercicio 5
clear all;
%a
N = 10;
m = 2;

exps = randi([1 6], m , N);
soma = sum(exps);
sucesso = soma == 9;
% for i=1:N;
%     sucesso(i) = soma(i) == 9; a linha de cima faz exatamente a mesma
% end                             coisa q este for todo

probA = sum(sucesso)/N

%b
B = rem(exps(2,:) , 2) == 0;
probB = sum(B)/N

%c

C = exps(1,:) == 5 | exps(2,:) == 5;
probC = sum(C)/N

%d
D = exps(1,:) ~= 1 & exps(2,:) ~= 1;
probD = sum(D)/N

%ou
%D = min(exps)>1;
