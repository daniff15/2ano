function px = fMassaprob(n , N , k, p)
    lanca = rand(n, N) < p;
    sucessos = sum(lanca) == k;
    px = sum(sucessos)/N;
end