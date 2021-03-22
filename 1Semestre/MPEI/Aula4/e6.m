%% Alinea a)

estados = [0.8 0 0 0.3 0
    0.2 0.6 0 0.2 0
    0 0.3 1 0 0
    0 0.1 0 0.4 0
    0 0 0 0.1 1];

%% maneira do stor 
%estado 3 e 5 sao absorventes vai definir ja no estado canonico
%estado 3 e 5 tem de ficar no fundo, logo 3 e 4 trocam de posicao
%matriz 1 2 4 3 5
estados2 = [0.8 0.2 0 0 0
    0 0.6 0.1 0.3 0 
    0.3 0.2 0.4 0 0.1 
    0 0 0 1 0 
    0 0 0 0 1]' %fez em linha por ser mais facil e depois fez a transposta.
        

% T = | Q 0 |
%     | R I |

% nas proximas alineas ao usar esta matriz, dentro do for, nao meteu a
% matriz elevada as transicoes.
%% Alinea b)

atual = [1;0;0;0;0];
probabilidades = zeros(1, 100);
for n = 1:100
    w = estados^n*atual;
    probabilidades(n) = w(2);
end

plot([1:100] , probabilidades)

%% Alinea c)

atual = [1;0;0;0;0];
probabilidades1 = zeros(1, 100);
for n = 1:100
    w = estados^n*atual;
    probabilidades1(n) = w(3);
end
figure(3);
plot([1 : 100] , probabilidades1)
hold on;
atual = [1;0;0;0;0];
probabilidades2 = zeros(1, 100);
for n = 1:100
    w = estados^n*atual;
    probabilidades2(n) = w(5);
end

plot([1:100] , probabilidades2);
hold off;
legend("Estado 3" , "Estado 5");

%% Alinea d)e)f)

%usando a matriz do stor

Q = estados2(1:3 , 1:3)

F = inv(eye(3) - Q)

medAbs = sum(F)

%% Alinea g)

%valores teoricos

R = estados2(4:5 , 1:3)
B = R*F

[B(1,1) B(2,1)]
%comecando no primeiro estado transitorio cair no primeiro estado
%absorvente(3) e a probabilidade de comecando no primeri oestado
%transitorio cair no segundo estado absorvente(5);


