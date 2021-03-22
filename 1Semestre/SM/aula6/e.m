%% 1
clear all;
close all;
Ta = 0.01;
N = 1000;
[x , t] = GeraSinal(N, Ta);

%% 2

figure(1);
[X,f] = Espectro(x , Ta); % myFunc
stem(f , abs(X)); zoom on;
%sound(x/max(abs(x)) , 20000);

%% 3

idx = find(abs(abs(f) - 1) > 0.1);
%Fazendo as cenas matematicas vao nos dar os intervalos em que 
%a frequencia vai ser igual a 1; ou seja os intervalos de -1.1 a -0.9 e os
%intervalos de 0.9 a 1.1, sendo estas as frequencias que queremos nao
%tocando nelas, so alterando o valor dos indices do find que sao os indices
%em que ha ruido.
X3 = X;
X3(idx) = 0;

X3 = Reconstroi(X3);

i = 1:N;
% 
figure(14);
plot(t(i), X(i) , 'r' , t(i) , X3(i) , 'b' , t(i) , sin(2*pi*t(i)) , 'ko'); zoom on;

%% 4

idx = find(abs(abs(f)-1) < 0.1);

X4 = X;
X4(idx) = 0;

X4 = Reconstroi(X4);
i = 1:N;
% 
figure(15);
plot(t , X4);
%plot(t(i), X(i) , 'r' , t(i) , X4(i) , 'b' , t(i) , sin(2*pi*t(i)) , 'ko'); zoom on;

%Funcao linear vai alterar apenas as amplitudes do espetro;
%Funçoes nao lineares vao gerar novas frequencias e nao vao alterar as
%frequencias ja existentes

%% 5

potSom = Potencia(X3); % signal (s)
%Sinal Deterministico

potRuido = Potencia(X4); % noise (n)
%Sinal Ruido
relacaoNatural = potSom/potRuido;
relacaoDB = 10*log10(potSom/potRuido);
% 
fprintf('SNR = %.3f \n',relacaoNatural);
fprintf('SNR = %.3f dB\n',relacaoDB);
% 
