%% Exercicio 9a)
N = 1e5;
dp = 2;
m = 14;

classificacoes = dp.*randn(1,N) + m;

sucessos = (12<classificacoes & classificacoes<16);
pSim = sum(sucessos)/N

%% Exercicio 9b)

sucessos = (10 < classificacoes & classificacoes < 18);
pSim = sum(sucessos)/N

%% Exercicio 9c)

sucessos = (classificacoes>= 10);
pSim = sum(sucessos)/N

%% Exercicio 9d)

normcdf(16, 14, 2) - normcdf(12 ,14 ,2)
normcdf(18, 14, 2) - normcdf(10 ,14 ,2)
normcdf(20, 14, 2) - normcdf(10 ,14 ,2)

