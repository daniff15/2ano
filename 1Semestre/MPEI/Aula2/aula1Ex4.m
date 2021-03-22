clear all 
N= 1e5; %nu´mero de experieˆncias
 p = 0.5; %probabilidade de cara
 n = 20; %nu´mero de lanc¸amentos
   
 for k = 0:n
    results(k + 1) = probabilidades(p, n , N, k);
 end
figure(1)
stem(0:n , results)
title('Nº Lançamentos : 20')

n=40
for k = 0:n
    results(k + 1) = probabilidades(p, n , N, k);
end
figure(2)
stem(0:n , results)
title('Nº Lançamentos : 40')

n=100
 for k = 0:n
    results(k + 1) = probabilidades(p, n , N, k);
 end
figure(3)
stem(0:n , results)
title('Nº Lançamentos : 100')


function prob = probabilidades(p, n ,N, k)
    lancamentos = rand(n,N) > p;
    sucessos= sum(lancamentos)==k;
    prob= sum(sucessos)/N;
end

% N= 1e5; %nu´mero de experieˆncias
% p = 0.5; %probabilidade de cara
% k = 6; %nu´mero de caras
% n = 15; %nu´mero de lanc¸amentos
% lancamentos = rand(n,N) > p;
% sucessos= sum(lancamentos)==k;
% probSimulacao= sum(sucessos)/N