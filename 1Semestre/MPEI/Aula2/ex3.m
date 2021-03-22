clear all
%% Exercicio 3a)

keys = 10;
T = 1000;
N = 1e5;
array = randi([0,T-1] , keys , N);

for i = 1:N
    res(i) = length(unique(array(: , i))) < keys;
end

resultado = sum(res)/N

%% Exercicio 3b)
clear all
keys = 10:10:100;
N = 1e5;
T = 1000;
index_prob = 1;
for k = keys
    sucesso = 0;
    array = randi([0,T-1] , k , N);
    for i = 1:N
        if length(unique(array(: , i))) < k;
           sucesso = sucesso + 1; 
        end    
    end
    probs(index_prob) = sucesso/N;
    index_prob = index_prob + 1;
end



plot(keys,probs)
xlabel('key')
ylabel('prob')
title('T = 1000')


%% Exercicio 3c)
clear all
keys = 50;
N = 1e5;
T = 100:100:1000;
index_prob = 1;

for t = T
    sucesso = 0;
    array = randi([0,t-1] , keys , N);
    for i = 1:N
        if length(unique(array(: , i))) == keys;
           sucesso = sucesso + 1; 
        end    
    end
    probs(index_prob) = sucesso/N;
    index_prob = index_prob + 1;
end

figure
plot(T,probs)
xlabel('T')
ylabel('prob')
title('keys = 50')

