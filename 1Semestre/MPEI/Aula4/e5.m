%% Alinea a) e b)

% 3 estados - sol , nuvens , chuva

tempo = [0.7 0.2 0.3
    0.2 0.3 0.3
    0.1 0.5 0.4];

% atual = [1 0 0];

% segundo e terceiro dia de sol correpondem a 1 e 2 transicoes
p_5b = 1 * tempo(1,1) * tempo(1,1)
w = sum(tempo^1.*atual');
% faco só a sum disto e meto em transposta para me dar
%matriz estados x 1

% fprintf("Estar sol no segundo dia sabendo q teve no primeiro - %f\n" , w(1));
% 
% w2 = sum(tempo^2.*atual');
% 
% fprintf("Estar sol no terceiro dia sabendo q teve no segundo - %f\n" , w2(1));
% 
% fprintf("Estar sol no segundo e no terceiro dia - %f\n", w(1) * w2(1));

%% Alinea c)

atual = [1 0 0];

% w = (tempo^1.*atual);
% 
% fprintf("Nao chover no segundo dia sabendo q teve sol no primeiro - %f\n" ,1 -w(3));
% 
% w2 = sum((tempo^2.*atual)'); %so para ficar a matriz mais bonita
% 
% fprintf("Nao chover no terceiro dia sabendo q teve sol no primeiro - %f\n" ,1-w2(3));
% 
% fprintf("Nao chover no segundo e no terceiro dia - %f\n", (1-w(3)) * (1 - w2(3)));

% p_c = P(sol) * P(sol->sol) + 
%P(sol) * P(sol->sol) * P(sol->nuvens) + 
%P(sol) * P(sol->nuvens) * P(nuvens->sol) + 
%P(sol) * P(sol->nuvens) * P(nuvens->nuvens) + 

p_c = 1 * tempo(1,1)*tempo(1,1) + 1*tempo(1,1)*tempo(2,1) + 1*tempo(2,1)*tempo(1,2) + 1*tempo(2,1)*tempo(2,2)
%% Alinea d)

atual = [1;0;0];
contSol = atual(1);
contNuvens = atual(2);
contChuva = atual(3);

for i=2:31
    atual=tempo*atual;
    contSol = contSol + atual(1);
    contNuvens = contNuvens + atual(2);
    contChuva = contChuva + atual(3);
end

[contSol contNuvens contChuva]


%% Alinea e)

atual = [0;0;1];
contSol = atual(1);
contNuvens = atual(2);
contChuva = atual(3);

for i=2:31
    atual=tempo*atual;
    contSol = contSol + atual(1);
    contNuvens = contNuvens + atual(2);
    contChuva = contChuva + atual(3);
end

[contSol contNuvens contChuva]


%% Alinea f)

%primerio dia é sol
atual = [1;0;0];
cont = 0.1*atual(1) + 0.3*atual(2) + 0.5*atual(3);


for i=2:31
    atual=tempo*atual;
    cont = cont + 0.1*atual(1) + 0.3*atual(2) + 0.5*atual(3);
end
%primeiro dia é chuvas

atual = [0;0;1];
cont2 = 0.1*atual(1) + 0.3*atual(2) + 0.5*atual(3);


for i=2:31
    atual=tempo*atual;
    cont2 = cont2 + 0.1*atual(1) + 0.3*atual(2) + 0.5*atual(3);
end
[cont cont2]