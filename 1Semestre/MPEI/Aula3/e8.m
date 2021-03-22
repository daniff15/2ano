lambda = 0.02;
k = 0;
n = 100;
lambda = lambda*100; % era 0.02 numa pagina e como querem para 100 multiplicam por 100
pNenhuma = ((lambda^k) * exp(-lambda))/factorial(k);

k = 1;

pUm = ((lambda^k) * exp(-lambda))/factorial(k);

fprintf("Probabilidade de no máximo ter 1 erro em cada 100 paginas -> %f" , pNenhuma + pUm)