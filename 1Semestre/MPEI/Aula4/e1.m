%% Alinea a)

% 1 - ir a aula
% 2 - nao ir a aula

%coluna - estado atual , linha - estado seguinte
trans = [0.7 0.8
         0.3 0.2];
     
sum(trans); % aconselha fazer esta sum para ver se da tudo 1s

v = [1 ; 0];

%ao fim de n transicoes

w = trans^2*v; %2 transicoes

respa = w(1)

%% Alinea b)
trans = [0.7 0.8
         0.3 0.2];

v = [0 ; 1];

%ao fim de n transicoes

w = trans^2*v; %2 transicoes

respb = w(1)

%% Alinea c)

trans = [0.7 0.8
         0.3 0.2];
     
v = [1 ; 0];

w = trans^29*v

respc = w(1)


%% Alinea d)
trans = [0.7 0.8
         0.3 0.2];

res= zeros(1 , 30);

v = [0.85 ; 0.15];

res(1) = v(2);

for i = 2 : 30
    v = trans*v;
    res(i) = v(2);
end
x=1:30;
plot(x ,res)