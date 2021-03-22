n_tentativas = 10000;

p_andre = 0.20;
p_erro_sabendo_andre = 0.01;

p_bruno = 0.30;
p_erro_sabendo_bruno = 0.05;

p_carlos = 0.50;
p_erro_sabendo_carlos = 0.001;

%1 - André
%2 - Bruno
%3 - Carlos
progs = [ones(1, p_andre*100) 2*ones(1, p_bruno*100) 3*ones(1, p_carlos*100)];

progs = progs(randperm(length(progs)));

index = randi(length(progs), n_tentativas, 1);

andre = 0;
erro_andre = 0;
bruno = 0;
erro_bruno = 0;
carlos = 0;
erro_carlos = 0;

for k = 1 : length(index)
    p = progs(index(k));
    
    erro = rand();
    
    if (p == 1)
        andre = andre + 1;
        if (erro < p_erro_sabendo_andre)
            erro_andre = erro_andre + 1;
        end
    end
    
    if (p == 2)
        bruno = bruno + 1;
        if (erro < p_erro_sabendo_bruno)
            erro_bruno = erro_bruno + 1;
        end
    end
    
    if (p == 3)
        carlos = carlos + 1;
        if (erro < p_erro_sabendo_carlos)
            erro_carlos = erro_carlos + 1;
        end
    end
end

% a)

% prob de ser do Carlos sabendo que o programa tem erro

%Pelo Teorema de Bayes
% P(Carlos|erro) = (P(erro|Carlos) * P(Carlos)) / P(erro)

p_carlos = carlos / length(index);
p_erro = (erro_carlos + erro_bruno + erro_andre) / length(index);

prob_carlos_sabendo_erro = (p_erro_sabendo_carlos * p_carlos) / p_erro;
disp(prob_carlos_sabendo_erro)

% b)
p_andre = andre / length(index);
p_bruno = bruno / length(index);

prob_andre_sabendo_erro = (p_erro_sabendo_andre * p_andre) / p_erro;
prob_bruno_sabendo_erro = (p_erro_sabendo_bruno * p_bruno) / p_erro;

if (prob_andre_sabendo_erro > prob_bruno_sabendo_erro && prob_andre_sabendo_erro > prob_carlos_sabendo_erro)
    disp("André");

elseif (prob_bruno_sabendo_erro > prob_carlos_sabendo_erro)
    disp("Bruno");
    
else
    disp("Carlos");
end
    
    
    
    
    
    