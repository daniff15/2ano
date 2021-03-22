px = zeros(1,3);
px(1) = 90/100;
px(2) = 9/100;
px(3) = 1/100;

S = [0 0 5 50 100 101 101];

figure(1);
Fx = cumsum(px);
Fx = [0 0 Fx 1 1];
subplot(2,2,[1,2]);
stairs(S , Fx);
xlabel('x');
ylabel('pX');
title("Grafico Funcao de massa de probabilidade de X");

S2 = [5 50 100];
subplot(2,2,[3,4])
stem(S2 , px)
xlabel('x');
ylabel('pX');
title("Grafico Funcao de massa de probabilidade de X");