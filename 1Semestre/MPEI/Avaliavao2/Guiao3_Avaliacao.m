%%
clear; clc;
% Estado A --> 1
% Estado M --> 2
% Estado O --> 3
% Estado R --> 4
% Estado . --> 5
matrizLetra = [ 'a' 'm' 'o' 'r' '.'];
%Exercicio 1
%a)

T=[0 0.25 0.25 0.25 0.25;
    0.5 0 0.5 0 0;
    0 1/3 0 1/3 1/3;
    0.5 0 0.5 0 0 ;
    0 0 0 0 0]';
resultado = crawl(T,randi(4),5,100);
palavra = string(matrizLetra( resultado(1:(end-1))));




%b)
N = 1e5;
tam = [0 8 6 4];
[lista, listaN8, listaN6, listaN4]= geraLista(matrizLetra, T, 5, tam, N);
[G1, NG1] = groupcounts(lista);
diferentes = length(G1)
[k,kI] = maxk(G1,5);
k2 = k/N*100;
tabela = table(NG1(kI), k, k2);
tabela.Properties.VariableNames{'k'}= 'Ocorrências';
tabela.Properties.VariableNames{'k2'}= 'Probabilidade (%)';
tabela.Properties.VariableNames{'Var1'}= 'Palavra';
tabela
clear tabela;
%d)
[palavrasPortuguesas, palavrasPortuguesasN8, palavrasPortuguesasN6, palavrasPortuguesasN4, importantes]= verificarPalavras(matrizLetra, lista, listaN8, listaN6, listaN4);
fprintf ("O número de palavras válidas em português é: %.5f\n", (palavrasPortuguesas/N) );

%e) alterado na função crawl
%f)
fprintf ("O número de palavras válidas em português, para n=8, é: %.5f\n", (palavrasPortuguesasN8/N) );
fprintf ("O número de palavras válidas em português, para n=6, é: %.5f\n", (palavrasPortuguesasN6/N) );
fprintf ("O número de palavras válidas em português, para n=4, é: %.5f\n", (palavrasPortuguesasN4/N) );

%2
T2= [0 0.2 0.1 0.3 0.4;
    0.7 0 0.3 0 0;
    0 0.2 0 0.3 0.5;
    0.7 0 0.3 0 0 ;
    0 0 0 0 0]';

[lista, listaN8, listaN6, listaN4]= geraLista(matrizLetra, T2, 5, tam, N);
[palavrasPortuguesas, palavrasPortuguesasN8, palavrasPortuguesasN6, palavrasPortuguesasN4, importantes]= verificarPalavras(matrizLetra, lista, listaN8, listaN6, listaN4);
[Ginf, NGinf] = groupcounts(lista);
[G8, NG8] = groupcounts(listaN8);
[G6, NG6] = groupcounts(listaN6);
[G4, NG4] = groupcounts(listaN4);
diferentes = length(Ginf)
diferentesN8 = length(G8)
diferentesN6 = length(G6)
diferentesN4 = length(G4)
[maximoInf, maximoInfIndex] = maxk(Ginf,5);
[maximo8, maximo8Index] = maxk(G8,5);
[maximo6, maximo6Index] = maxk(G6,5);
[maximo4, maximo4Index] = maxk(G4,5);
probMaximoInf = maximoInf/N*100;
probMaximo8 = maximo8/N*100;
probMaximo6 = maximo6/N*100;
probMaximo4 = maximo4/N*100;
tabela_Inf = table(NGinf(maximoInfIndex), maximoInf, probMaximoInf);
tabela_Inf.Properties.VariableNames{'maximoInf'}= 'Ocorrências';
tabela_Inf.Properties.VariableNames{'probMaximoInf'}= 'Probabilidade (%)';
tabela_Inf.Properties.VariableNames{'Var1'}= 'Palavras';
tabela_Inf
clear tabela_Inf
tabela_N8 = table(NG8(maximo8Index), maximo8, probMaximo8);
tabela_N8.Properties.VariableNames{'maximo8'}= 'Ocorrências';
tabela_N8.Properties.VariableNames{'probMaximo8'}= 'Probabilidade (%)';
tabela_N8.Properties.VariableNames{'Var1'}= 'Palavras';
tabela_N8
clear tabela_N8
tabela_N6 = table(NG6(maximo6Index), maximo6, probMaximo6);
tabela_N6.Properties.VariableNames{'maximo6'}= 'Ocorrências';
tabela_N6.Properties.VariableNames{'probMaximo6'}= 'Probabilidade (%)';
tabela_N6.Properties.VariableNames{'Var1'}= 'Palavras';
tabela_N6
clear tabela_N6
tabela_N4 = table(NG4(maximo4Index), maximo4, probMaximo4);
tabela_N4.Properties.VariableNames{'maximo4'}= 'Ocorrências';
tabela_N4.Properties.VariableNames{'probMaximo4'}= 'Probabilidade (%)';
tabela_N4.Properties.VariableNames{'Var1'}= 'Palavras';
tabela_N4
clear tabela_N4

fprintf ("O número de palavras válidas em português é: %.5f\n", (palavrasPortuguesas/N) );
fprintf ("O número de palavras válidas em português, para n=8, é: %.5f\n", (palavrasPortuguesasN8/N) );
fprintf ("O número de palavras válidas em português, para n=6, é: %.5f\n", (palavrasPortuguesasN6/N) );
fprintf ("O número de palavras válidas em português, para n=4, é: %.5f\n", (palavrasPortuguesasN4/N) );

%3


%% Funções
%gerar a lista de palavras consoante a matriz transição de estados

function [lista, listaN8, listaN6, listaN4]= geraLista(matrizLetra, T, ult, tam, N)
lista = strings(1, N)';
listaN8 = strings(1,N)';
listaN6 = strings(1,N)';
listaN4 = strings(1,N)';
for k=1:N
    resultado = crawl(T,randi(4),ult, tam(1));
    lista(k) = matrizLetra( resultado(1:(end-1)));
    resultado = crawl(T,randi(4),ult, tam(2));
    listaN8(k) = matrizLetra( resultado(1:(end-1)));
    resultado = crawl(T,randi(4),ult, tam(3));
    listaN6(k) = matrizLetra( resultado(1:(end-1)));
    resultado = crawl(T,randi(4),ult, tam(4));
    listaN4(k) = matrizLetra( resultado(1:(end-1)));
end
end

%verificar se as palavras estão no ficheiro
function [palavrasPortuguesas, palavrasPortuguesasN8, palavrasPortuguesasN6, palavrasPortuguesasN4, importantes]= verificarPalavras(matrizLetra, lista, listaN8, listaN6, listaN4)
file = fopen('C:\Users\HP OMEN\Documents\MATLAB\MPEI\Avaliavao2\wordlist-preao-20201103.txt','r');
dicionario = textscan(file,'%s');
dicionario = dicionario{1,1};
fclose(file);
importantes = strings(length(dicionario),1);
for alfa =1:(length(matrizLetra)-1)
for i = 1:length(dicionario)
     if (startsWith(dicionario{i,1},matrizLetra(alfa)))
         importantes(i) = dicionario{i,1};
     end
end
end
importantes = importantes(~strcmp(importantes(:,1),""),:);
[Ginf, NGinf] = groupcounts(lista);
[G8, NG8] = groupcounts(listaN8);
[G6, NG6] = groupcounts(listaN6);
[G4, NG4] = groupcounts(listaN4);
palavrasPortuguesas = 0;
palavrasPortuguesasN8 = 0;
palavrasPortuguesasN6 = 0;
palavrasPortuguesasN4 = 0;
for i = importantes'
if(strlength(i)>7)
    if(ismember(i,NGinf))
        palavrasPortuguesas = palavrasPortuguesas +Ginf(NGinf==i);
    end
    if(ismember(i,NG8))
        palavrasPortuguesasN8 = palavrasPortuguesasN8 +G8(NG8==i);
    end
    continue
end
if(strlength(i)>5)
    if(ismember(i,NGinf))
        palavrasPortuguesas = palavrasPortuguesas +Ginf(NGinf==i);
    end
    if(ismember(i,NG8))
        palavrasPortuguesasN8 = palavrasPortuguesasN8 +G8(NG8==i);
    end
    if(ismember(i,NG6))
        palavrasPortuguesasN6 = palavrasPortuguesasN6 +G6(NG6==i);
    end
    continue

else
    if(ismember(i,NGinf))
        palavrasPortuguesas = palavrasPortuguesas +Ginf(NGinf==i);
    end
    if(ismember(i,NG8))
        palavrasPortuguesasN8 = palavrasPortuguesasN8 +G8(NG8==i);
    end
    if(ismember(i,NG6))
        palavrasPortuguesasN6 = palavrasPortuguesasN6 +G6(NG6==i);
    end
    if(ismember(i,NG4))
        palavrasPortuguesasN4 = palavrasPortuguesasN4 +G4(NG4==i);
    end
    continue
end 
end
end
%% Gerador de palavras aleatórias
% Inputs:
% H - state transition matrix
% first - initial state
% last - terminal or absorving state
function state = crawl(H, first, last, n)
state = [first];
% keep moving from state to state until state "last" is reached:
if (n ~=0)
for controlo = 1:n
    state(end+1) = nextState(H, state(end));
    if (state(end) == last)
    break;
    end
end
else
    while (1)
    state(end+1) = nextState(H, state(end));
    if (state(end) == last)
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
probVector = H(:,currentState)'; % probVector is a row vector
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
state = states(i);
end


