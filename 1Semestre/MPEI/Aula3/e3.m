p = 0.5;
N = 10000;
n= 4; %numero de lancamentos
%cara é >0.5
matriz = rand(n, N);
x = 0:4;
%com funcao
% for i=1:5
%    k = i-1;
%    px(i) = fMassaprob(n , N , k , p);
% end
%sem funcao
for n_coroas = x
    result = matriz < p;
    sucessos = sum(result) == n_coroas;
    px(n_coroas + 1) = sum(sucessos)/N;
end

figure(1);
hold on;

x = 0:4;
stem(x,px);
axis([-1 5 0 0.4]);
grid on
xlabel('x');
ylabel('pX');
title("Grafico Funcao de Probabilidade de X (Simulado)");

%% 3b
valEsp = 0;
for n_coroas = x
    valEsp = valEsp + (n_coroas * px(n_coroas+1));   
end
%E[X] = valEsp
valEsp
E2 = 0;
for n_coroas = x
    E2 = E2 + (n_coroas^2 * px(n_coroas+1));
end

varianca = E2 - valEsp^2

dp = sqrt(varianca)