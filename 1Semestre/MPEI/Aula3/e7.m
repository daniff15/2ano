%% Exercicio 7a)

lambda = 15;

k = 0;

pNenhuma = ((lambda^k) * exp(-lambda))/factorial(k)


%% Exercicio 7b)

lambda = 15;
k = 10;
px = 0;
for i = 0:k
    px = px + ((lambda^i) * exp(-lambda))/factorial(i);
end

fprintf('Prob de receber mais de 10 -> %f' , 1-px)