%% Alinea a)

grupos = [1/3 1/4 0
    1/3 11/20 1/2
    1/3 1/5 1/2];

sum(grupos) %soma das colunas  = 1, logo trata-se de uma matriz estocastica

%% Alinea b)

%Temos 90 alunos
% A = 2 * (B+C)
% B = C
%A = 2 * 2B
%A = 4B <=> A + B + C = 90
%4B + B + B = 90 <=> B = 90/6 => 15
%A = 4B <=> A = 4*15 = 60

atual = [60/90 ; 15/90 ; 15/90];

%% Alinea c)

%ao fim de 30 aulas

W = grupos^30*atual;

alunos = W*90;

fprintf("Numeros de alunos em cada grupo: \nA- %f\nB- %f\nC- %f\n" , alunos(1) , alunos(2) , alunos(3));

%% Alinea d)

atual2 = [30/90 ; 30/90 ; 30/90];
W2 = grupos^30*atual2;

alunos2 = W2*90;

fprintf("Numeros de alunos em cada grupo: \nA- %f\nB- %f\nC- %f\n" , alunos2(1) , alunos2(2) , alunos2(3));

