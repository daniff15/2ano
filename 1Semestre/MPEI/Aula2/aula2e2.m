%% Exercicio 2a)
clear all
n = 20;
m = 100;
N = 1e5;
lancamentos = randi(100 , 20 , N);

for i = 1:N
    res(i) = length(unique(lancamentos(: , i))) == 20;
end

resultado = sum(res)/N

%% Exercicio 2b)
clear all
n = 20;
m = 100;
N = 1e5;
lancamentos = randi(100 , 20 , N);

for i = 1:N
    res(i) = length(unique(lancamentos(: , i)))<20;
end

resultado = sum(res)/N

%% Exercicio 2c)
clear all

n = 10:10:100;
N = 1e5;
index_probS=1;
for setas = n
    sucessos1000 = 0;
    lancamentos = randi(1000 , setas , N);
    for i = 1:N
        if length(unique(lancamentos(: , i)))< setas;
            sucessos1000 = sucessos1000 + 1;
        end
    end 
    probs(index_probS) = sucessos1000/N;
    index_probS = index_probS +1;
end

figure(1)
subplot(1,2,1)
plot(n , probs , "r*-")
xlabel('n')
ylabel('prob')
title('m = 1000')

n = 10:10:100;
N = 1e5;
index_probS=1;

for setas = n
    sucessos10000 = 0;
    lancamentos = randi(10000 , setas , N);
    for i = 1:N
        if length(unique(lancamentos(: , i)))< setas;
            sucessos10000 = sucessos10000 + 1;
        end
    end 
    probs(index_probS) = sucessos10000/N;
    index_probS = index_probS +1;
end

subplot(1 , 2, 2)
plot(n , probs)
xlabel('n')
ylabel('prob')
title('m = 10000')

%% Exercicio 2d)
clear all
m = [200 500 1000 2000 5000 10000 20000 50000 100000];
n = 100;
N = 1e5;
index_probS = 1;
for alvos = m
    sucessos10000 = 0;
    lancamentos = randi(alvos , n , N);
    for i = 1:N
        if length(unique(lancamentos(: , i)))< n
            sucessos10000 = sucessos10000 + 1;
        end
    end 
    probs(index_probS) = sucessos10000/N;
    index_probS = index_probS +1;
end


figure(2)
plot(m,probs)
xlabel('m')
ylabel('prob')
title('n = 100')