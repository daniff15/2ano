%% Exercicio 3

clear all;
close all;

Ta = 0.001;
f0 = 1;
Np = 6;
bk = zeros(100,1); %se metesse 1000 aqui e em baixo ficava muito definido
bk(1:2:100) = 4./((1:2:100)*pi);
%bk = [0 4/pi 0 4/(3*pi) 0 4/(pi*5) 0 4/(pi*7) 0 4/(pi*9) 0 4/(pi*11) 0 4/(13*pi) 0 4/(15*pi) 0 4/(17*pi) 0 4/(19*pi)]';  
ak = zeros(size(bk));

[x,t] = fourier_coefs(Ta , f0 , Np , ak , bk);

figure(1);
plot(t,x);
grid;

%% Exercicio 4



Ta = 0.001;
Np = 10;
bk = [0 0 0 0 0];
ak = [1 0.5 0.25 0.125 0.0625];
f0 = 1;
[x,t] = fourier_coefs(Ta,f0,Np,ak, bk);

figure(1);
plot(t, x);
xlabel("Tempo(s)");
ylabel("x(t)");
title("Par");
ak = [0 0 0 0 0];
bk = [1 0.5 0.25 0.125 0.0625];
f0 = 1;
Ta = 0.001;
Np = 10;

[x,t] = fourier_coefs(Ta,f0,Np,ak, bk);
figure(2);
plot(t, x);
xlabel("Tempo(s)");
ylabel("x(t)");
title("Impar");
%% Exercicio 6
clear all;
Ta = 0.001;
f0 = 1;
Np = 10;
N = 100;
x2 = [0: N-1 N:-1:1-N -N:-1 0: N-1 N:-1:1-N -N:-1 0: N-1 N: -1 : 1]/100;

% f0 = 1; T0 = 1/f0;
% N = 100;
% x2 = [0:N-1 N:-1:1-N -N:-1]/N;
% Ta = 1/400;
% t = (0:4*N-1)*Ta;
% Resolucao do bitLei

[a , b] = coefsE5(x2);
[x , t] = fourier_coefs(Ta , f0 , Np , a , b);
plot(t , x);
% fiz batota xD, vi q tinham de ter tamanho 1000 e fiz ate ter

y = [0 : N-1 0 0:N-1 0 0:N-1 0 0:N-1 0 : N-1 0 0:N-1 0 0:N-1 0 0:N-1 0 : N-1 0 0:N-8]/100;
[a , b] = coefsE5(y);
[y , t] = fourier_coefs(Ta , f0 , Np , a , b);
figure(5);
plot(t,y);
% grid;

%fazer a funcao coefE5 e retorna os coefs desta x.