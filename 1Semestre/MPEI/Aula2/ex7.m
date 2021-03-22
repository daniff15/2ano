%% Exercicio 7a)
N = 10000;
pA = 0.2;
pB = 0.3;
pC = 0.5;
pEsA = 0.01;
pEsB = 0.05;
pEsC = 0.001;

probs = [ones(1 , pA * 100) 2*ones(1, pB * 100) 3*ones(1, pC*100)];

probs = probs(randperm(length(probs)));
index = randi(length(probs), N,1);

andre = 0;
erro_andre = 0;
bruno = 0;
erro_bruno = 0;
carlos = 0;
erro_carlos = 0;

for i=1:length(index)
    p = probs(index(i));
    
    erro = rand();
    
    if p == 1
       andre = andre + 1;
       if erro < pEsA
           erro_andre = erro_andre + 1;
       end
    end
    
    if p == 2
       bruno = bruno + 1;
       if erro < pEsB
           erro_bruno = erro_bruno + 1;
       end
    end
    
    if p == 3
       carlos = carlos + 1;
       if erro < pEsC
           erro_carlos = erro_carlos + 1;
       end
    end
end



%a

%usando a formula P(Carlos|erro) = (P(erro|Carlos) * P(Carlos)) / P(erro)

p_carlos = carlos / length(index);

p_erro = erro_andre + erro_bruno + erro_carlos / length(index);

pCarlosKerro = (pEsC * p_carlos)/p_erro 



%b

p_andre = andre / length(index);
p_bruno = bruno / length(index);

p_andreKerro = (p_andre * pEsA)/p_erro; 
p_brunoKerro = (p_bruno * pEsB)/p_erro;

if (p_andreKerro > p_brunoKerro && p_andreKerro > pCarlosKerro)
    disp("André")
    
elseif (p_brunoKerro > pCarlosKerro)
    disp("Bruno");
    
else
    disp("Carlos");
end



