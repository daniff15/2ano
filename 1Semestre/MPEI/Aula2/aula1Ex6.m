%% a
clear all;
def = 0.3;
amostra = 5;
N = 10000;
k = 3;
prob = defeito(def , amostra , N , k)

%% b
clear all;
def = 0.3;
amostra = 5;
N= 10000;
k = 3;

exps = rand(amostra , N) <= def;
results = sum(exps) <= k;
probs = sum(results)/N

%% c

clear all;
def = 0.3;
amostra = 5;
N = 10000;
k = 3;

for k=0:amostra
   prob(k +1) = defeito(def , amostra , N , k) ;
end

bar(0:amostra , prob)

function prob = defeito(def , amostra , N , k)
    exps = rand(amostra , N) <= def;
    results = sum(exps) == k;
    prob = sum(results)/N;
    
end




