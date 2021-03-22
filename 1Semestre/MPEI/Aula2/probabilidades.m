function prob = probabilidades(p, n ,N, k)
    lancamentos = rand(n,N) > p;
    sucessos= sum(lancamentos)==k;
    prob= sum(sucessos)/N;
end