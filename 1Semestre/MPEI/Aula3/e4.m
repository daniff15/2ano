%% alinea a
N = 1e5;
n = 5;
p = 0.3;

exps = rand(n , N);
%espaco de amostragem = {0 1 2 3 4 5}
x = 0:5;

for defs = x
    result = exps < p;
    sucesso = sum(result) == defs;
    fx(defs + 1) = sum(sucesso)/N;
end

figure(1);
hold on;
stem(x,fx);
axis([-0.5 5.5 0 0.4]);
grid on
xlabel('x');
ylabel('pX');
title("Grafico Funcao de Probabilidade de X (Simulado)");

%% alinea b
figure(2);
FX = cumsum(fx);
FX = [0 0 FX 1 1];
x = -2:7;
stairs(x , FX)
hold on;
axis([-1 6 0 1]);
grid on
xlabel('x');
ylabel('pX');
title("Grafico Funcao de Probabilidade de X (Simulado)");


%% alinea c

N = 1e5;
n = 5;
p = 0.3;

exps = rand(n , N);
%espaco de amostragem = {0 1 2 3 4 5}
x = 0:5;

result = exps < p;
sucesso = sum(result) <= 2;
prob = sum(sucesso)/N;

fprintf('Probabilidade de no maximo serem duas defeituosas = %f\n' , prob)

% ou em vez de se fazer esta bosta toda podia logo fazer

fprintf('Prob ate 2 defs = %f\n' , sum(fx(1:3)))

%% b i)

N = 1e5;
n = 5;
p = 0.3;
x = 0:5;

for n_defeito = x
    i = n_defeito+1;
    px_prob(i)=(nchoosek(5 , n_defeito)* (p^n_defeito) * (1-p)^(n-n_defeito));
end

figure(5);
FX = cumsum(px_prob)
FX = [0 FX 1];
x = -1:6;
stairs(x , FX)
hold on;
axis([-1 6 0 1.2]);
grid on
xlabel('x');
ylabel('pX');
title("Grafico Funcao de Probabilidade de X (Simulado)");


%% bii)

fprintf('Maximo duas defs -> %f' , px_prob(1) + px_prob(2) + px_prob(3))