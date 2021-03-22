T = [0 0.5 0 0;
1 0 0.6 0.6;
0 0 0 0.4;
0 0.5 0.4 0]; %Matriz que ele tem nos exemplos

x0 = ones(4 , 1)/4;

x = markov_estadoEstacionario(T , x0 , 1e-6)
% Alguma coisa mal, pk corre infinitamente

%% Metodo algebrico - o q quer q isso queira dizer

N = length(T);
M = [T - eye(N); ones(1 , N)];

res = zeros(N, 1);
res(N + 1) = 1;

x_est = M\res;

[x_est x]
% Comparacao com o obtido com a funcao feita
%Pelo menos tudo igual ate a 4 casa