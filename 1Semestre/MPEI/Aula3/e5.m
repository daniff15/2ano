%% probabilidade de se despenhar com 2 motores

%Ex 5. plot 
clear all;
close all;

n = 2;
k = 2;
p = logspace(-3 , log10(1/2) , 100);


p2Motores = nchoosek(n , k) .* p.^k .* (1-p).^(n-k);

n=4;
k=3;

p4Motores = 0;
p4Motores = p4Motores + nchoosek(n , k) .* p.^k .*(1-p).^(n-k);

k=4;

p4Motores =nchoosek(n , k) .* p.^k .*(1-p).^(n-k) + p4Motores;


figure(1);
hold on;
plot(p , p2Motores);
plot(p , p4Motores);
grid on
axis([0 0.5 0 0.35]);
xlabel('x');
ylabel('pX');
title("Grafico Funcao de Probabilidade de X (Simulado)");
hold off;


