%% Ler do ficheiro u_item.txt

uitem = readcell('u_item.txt');

save uitem

%% Ler os filmes de cada user
udata=load("u.data"); % Carrega o ficheiro dos dados dos filmes 
% Fica apenas com as duas primeiras colunas
u= udata(1:end,1:2); 
clear udata;

users = unique(u(:,1)); % Extrai os IDs dos utilizadores 
Nu= length(users); % Numero de utilizadores
Set=cell(Nu,1);
for n = 1:Nu
    ind =find(u(:,1) == users(n));
    Set{n} = [Set{n} u(ind,2)];
end

save 'filmesPorUser' Set