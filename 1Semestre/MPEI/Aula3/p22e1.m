%criar matriz com a probabilidade de ficar com 1 face qq virada para cima
%como é um dado normal entao a prob de sair [1-6] =
%p(xi) = 1/6
px = ones(1,6)/6;
x=1:6;
subplot(2,2,[1,2]);
stem(x, px)
axis([0 6.5 0 1/6*1.2]);
xlabel('x');
ylabel('pX');
title("Grafico Funcao de massa de probabilidade de X");


%1b
%Fx = zeros(1,6);

%for i = 1 : 6
%  for j = 1 : i
%    Fx(i) += 1/6;
%  end
%end

Fx = cumsum(px);
Fx = [0 0 Fx 1 1];  
x = -1:8;

subplot(2,2,[3,4])

stairs(x,Fx);
axis([0 6.5 0 1.1]);
xlabel('x');
ylabel('FX');
title("Grafico Funcao de distribuicao acumulada de X");

hold off;

