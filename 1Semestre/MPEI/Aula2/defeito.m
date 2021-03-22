function prob = defeito(def , amostra , N , k)
    exps = rand(amostra , N) <= def;
    results = sum(exps) == k;
    probs = sum(results)/N
    
end