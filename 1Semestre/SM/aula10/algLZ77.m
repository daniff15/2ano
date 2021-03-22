%% Exercício 1
clear all
close all
clc

[Image , ColorMap] = imread('Arca_8bit.bmp');
[N , M] = size(Image);

[Symb , Freq] = ImageSymbols(Image);

%% Exercício 2

%Para 35 simbolos apenas precisamos de 6 bits, um numero menor que os 8
%bits que a pergunta indica
%Visto que log2(35) = 5.1(...) precisamos de arredondar para cima dando nos
%o valor de 6 bits pra represetnar os 35 simbolos que temos

%% Exercício 3
% Como os valores de Nw e Mw vêm em bytes temos de passa-los para Kb
% janDes = 0;
% janObs = 0;
% Nw = janDes/1000; %kb
% Mw = janObs/1000; %kb
% 
% img_LZ77 = EncodeImg_LZ77(Imagem , Nw , Mw);
