%% Alínea a)

% Estado A - 1
% Estado M - 2
% Estado O - 3
% Estado R - 4
% Estado . - 5
           %a  %m  %o  %r  %.
palavras = [0 1/4 1/4 1/4 1/4
            1/2 0 1/2 0 0
            0 1/3 0 1/3 1/3
            1/2 0 1/2 0 0
            0 0 0 0 1]'

% sum(palavras)
letras = ['a' , 'm' , 'o' , 'r' , '.'];

state = crawl(palavras, randi(4), 5);
palavraGerada = letras(state(1:end-1))



%% Alínea b)

N = 1e5;
geradas = {};
count=[];

for i = 1:N
    state = crawl(palavras, randi(4), 5);
    palavra = letras(state(1:end-1));
      
    if(ismember(palavra,geradas))
        verificacao = ismember(geradas,palavra);      
        posicao = find(verificacao == true);            
        count(posicao) = count(posicao)+1;
    else
        geradas{end+1} = palavra;
        count(end+1) = 1; 
    end
end

diferente = length(count);
fprintf("Nº de palavras geradas diferentes - %d\n" , diferente);

probs = count/N;

[value , idx] = maxk(probs , 5); % temos os valores das probabilidades e dos indices onde as palavras com 
                                 % mais probabilidade de haver estão (geradas)
                                 
for i=1:5
    fprintf("Palavra - %s , Probabilidade(percentagem) - %.3f\n" , geradas{idx(i)} , value(i)*100);
end




%% Alínea c)
% Probabilidades teóricas
%P(o)*P(.)
%P(a)*P(.)
%P(m)*P(o)*P(.)
%P(r)*P(o)*P(.)
%P(r)*P(a)*P(.)
%probabilidades muito idênticas
%Probabilidade para a primeira letra é sempre a mesma = 1/4



p1 = 1/4 * palavras(5 , 3);                   %palavra 'o'
p2 = 1/4 * palavras(5 , 1);                   %palavra 'a'
p3 = 1/4 * palavras(3 , 2) * palavras(5 , 3); %palavra 'mo'
p4 = 1/4 * palavras(3 , 4) * palavras(5 , 3); %palavra 'ro'
p5 = 1/4 * palavras(1 , 4) * palavras(5 , 1); %palavra 'ra'

fprintf("Palavra - %s , Probabilidade(percentagem) - %.3f\n" , geradas{idx(1)} , p1*100);
fprintf("Palavra - %s , Probabilidade(percentagem) - %.3f\n" , geradas{idx(2)} , p2*100);
fprintf("Palavra - %s , Probabilidade(percentagem) - %.3f\n" , geradas{idx(3)} , p3*100);
fprintf("Palavra - %s , Probabilidade(percentagem) - %.3f\n" , geradas{idx(4)} , p4*100);
fprintf("Palavra - %s , Probabilidade(percentagem) - %.3f\n" , geradas{idx(5)} , p5*100);


%% Alínea d)

fid= fopen('C:\Users\HP OMEN\Documents\MATLAB\MPEI\Avaliavao2\wordlist-preao-20201103.txt','r');
N = 1e5;
dicionario= textscan(fid,'%s');
fclose(fid);
dicionario= dicionario{1,1};
palavraPT = 0;
letras = {};
set_of_letters = 'amor.';

for i=1:length(dicionario)
    verificacao = min(ismember(dicionario{i} , set_of_letters));
    if (verificacao)
        letras{end + 1} = dicionario{i};
    end
end

for j=1:N
    state = crawl(palavras, randi(4) , 5);
    state = state(1 : length(state)-1);
    geradas{j} = set_of_letters(state);
end

for k=1:N
    if(ismember(geradas{k} , letras))
        palavraPT = palavraPT + 1;
    end
end


probPT = palavraPT/N;

fprintf("A probabilidade de uma palavra ser portuguesa é de %.2f%s\n" , (probPT*100) , "%")



%% Alínea f)


n = [8 , 6 , 4];

for i = n
    geradas = {};
 
    for k = 1:N
        state = crawl(palavras, randi(4) , 5 , i);
        state = state(1 : length(state)-1);
        geradas{k} = set_of_letters(state);
          
    end
    
    palavraPT = 0;
    for m = 1:N
        if(ismember(geradas{m} , letras))
            palavraPT = palavraPT + 1;
        end
    end
    probPT = palavraPT/N
end



%% Funcoes
% Random walk on the Markov chain
% Inputs:
% H - state transition matrix
% first - initial state
% last - terminal or absorving state
function state = crawl(H, first, last, maxNum)
% the sequence of states will be saved in the vector "state"
% initially, the vector contains only the initial state:
state = [first];
% keep moving from state to state until state "last" is reached:  
    if (nargin == 3)
        while (1)
            state(end+1) = nextState(H, state(end));
            if (state(end) == last)
                break;
            end
        end
    end

    if (nargin == 4)
        while (1)
            state(end+1) = nextState(H, state(end));
            if (state(end) == last | length(state) == maxNum)
                break;
            end
        end
    end
end
% Returning the next state
% Inputs:
% H - state transition matrix
% currentState - current state
function state = nextState(H, currentState)
% find the probabilities of reaching all states starting at the current one:
    probVector = H(:,currentState); % probVector is a row vector
    n = length(probVector); %n is the number of states
% generate the next state randomly according to probabilities probVector:
    state = discrete_rnd(1:n, probVector);
end
% Generate randomly the next state.
% Inputs:
% states = vector with state values
% probVector = probability vector
function state = discrete_rnd(states, probVector)
    U=rand();
    i = 1 + sum(U > cumsum(probVector));
    state= states(i);
end
