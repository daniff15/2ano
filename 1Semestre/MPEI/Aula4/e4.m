%% Alinea a

% estados
% A, B , C , D

p = 0.4;
q = 0.6;

% 4 estados, logo matriz 4x4

trans = [p^2 0 0 q^2
    (1-p)^2 0 0 q*(1-q)
    p*(1- p) 0 0 q*(1 - q)
    p*(1 - p) 1 1 (1 - q)^2];

%sum(trans)

%% Alinea b)
trans = [p^2 0 0 q^2
    (1-p)^2 0 0 q*(1-q)
    p*(1- p) 0 0 q*(1 - q)
    p*(1 - p) 1 1 (1 - q)^2];

atual = [1 0 0 0];

%w = trans^5.*atual;
x = [5 , 10 , 100 , 200];
for i = x
    w = trans^i.*atual;
    e = sum(w');
    fprintf("Para %d transicoes :\n" , i);
    fprintf("A para A - %f\n" , e(1));
    fprintf("A para B - %f\n" , e(2));
    fprintf("A para C - %f\n" , e(3));
    fprintf("A para D - %f\n" , e(4));
    fprintf("----------------\n");
end


%% Alinea c)
% trans * u = u; <=> (T-I)*u = 0
% sum(u) = 1
%u - matriz das probabilidades limite 

%eye(4) - matriz identidade 4x4
trans = [p^2 0 0 q^2
    (1-p)^2 0 0 q*(1-q)
    p*(1- p) 0 0 q*(1 - q)
    p*(1 - p) 1 1 (1 - q)^2];
H = [trans-eye(4) ; ones(1,4)]

a = [zeros(4 , 1) ; 1] %vetor dos termos independentes


v= H\a;

fprintf("Limites -> p(A) = %.8f p(B) = %.8f p(C) = %.8f p(D)= %.8f" , v)

