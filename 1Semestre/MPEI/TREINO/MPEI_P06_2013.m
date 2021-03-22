%% Exercício das casinhas

%estado 1 = senhorio
%estado 2 = inquilino

gostoDeMeninas = [1-0.03 0.03;
    0.12 1-0.12]';

% b

v0 = [0.56 0.44]';

v1 = gostoDeMeninas*v0

% c 
%Tu = u
% Tu - u = 0
% T(I - u) = 0;
% Matriz é singular , nao pode (??)

M = [gostoDeMeninas - eye(length(gostoDeMeninas)); ones(1 , length(gostoDeMeninas))];
% vetor de resultados 
x = [zeros(length(gostoDeMeninas), 1) ; 1];

res = M\x

%fORMA MENOS FORMAL

gostoDeMeninas^100 * v0
gostoDeMeninas^101 * v0


%% Exercicio de loja de informatica
% POISSON


