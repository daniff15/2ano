function [X_atual] = markov_estadoEstacionario(T , v0 , limiar)

    

    N = length(T);
    if nargin ~= 3
       v0 = ones(N , 1)/N;
       limiar = 1e-5;
    end
    
    X_ant = v0;
    X_atual = T * X_ant;
    
    count = 1;
    
    while max(abs(X_ant - X_atual)) >= limiar
        X_ant = X_atual;
        X_atual = T * X_ant;
        % Contador so para vermos quantas vezes é feita a convergencia
        
        count = count + 1;
    end
end