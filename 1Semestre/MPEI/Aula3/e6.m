%% Exercicio 6a)
p = 1/1000;
n = 8000;
k = 7;

pdefeito = nchoosek(n, k) * p^k * (1 - p)^(n-k)

%% Exercicio 6b)

clear all;
close all;

p = 1/1000;
n = 8000;
k = 7;

lambda = n*p;

pDef =(lambda^k)/(factorial(k))*exp(-lambda)


