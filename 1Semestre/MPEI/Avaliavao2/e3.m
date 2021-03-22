%% Exercício 3

% Estado A - 1
% Estado M - 2
% Estado O - 3
% Estado R - 4
% Estado . - 5
           %a  %m  %o  %r  %.
palavras = [0 0.2 0.1 0.3 0.4
            0.7 0 0.3 0 0
            0 0.2 0 0.3 0.5
            0.7 0 0.3 0 0
            0 0 0 0 1]'

set_of_letters = 'amor.';
N = 1e5;
n = [Inf, 8 , 6 , 4];
clc
fid= fopen('C:\Users\HP OMEN\Documents\MATLAB\MPEI\Avaliavao2\wordlist-preao-20201103.txt','r');
dicionario= textscan(fid,'%s');
fclose(fid);
dicionario= dicionario{1,1};

countA = 0;
countM = 0;
countO = 0;
countR = 0;
count = 0;
for i=1:length(dicionario)
    word=dicionario{i};
    if(min(ismember(word,set_of_letters)))
        count = count + 1;
        if(dicionario{i}(1) == 'a')
            countA = countA + 1;
        elseif(dicionario{i}(1) == 'm')
            countM = countM + 1;
        elseif(dicionario{i}(1) == 'o')
            countO = countO + 1;
        elseif(dicionario{i}(1) == 'r')
            countR = countR + 1;
        end
    end
end

prob1A = countA/count;
prob1M = countM/count;
prob1O = countO/count;
prob1R = countR/count;

vetor = [prob1A prob1M prob1O prob1R 0];

for i = n
    geradas={};
    for k = 1:N
        state = crawl(palavras, discrete_rnd([1 2 3 4 5] , vetor), 5 , i);
        state = state(1 : length(state)-1);
        geradas{k} = set_of_letters(state);
    end
    
    letras = {};
    
    for v=1:length(dicionario)
        verificacao = min(ismember(dicionario{v} , set_of_letters));
        if (verificacao)
            letras{end + 1} = dicionario{v};
        end
    end
    
    palavraPT = ismember(geradas , letras);
    
    probPT = sum(palavraPT)/N
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