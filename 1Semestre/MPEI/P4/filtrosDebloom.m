%% Exercício 2 - Bloom Filters 

clc
fid= fopen('wordlist-preao-20201103.txt','r');
dicionario= textscan(fid,'%s')
fclose(fid);
dicionario= dicionario{1,1};

n = 8000;
m = 1000;
m2 = 10000;
k = 3;
BF = Inicializar(n);

for i = 1:m
    BF = Adicionar(dicionario{i} , BF , k);
end

contadorFN = 0;
for i = 1:m
    if Verificar(dicionario{i} , BF , k) == false;
        contadorFN = contadorFN + 1;
    end
end

fprintf("Numero de falsos negativos = %d\n" , contadorFN );

%% Exercício 3
contadorFP = 0
for i = m + 1:m+m2
    if Verificar(dicionario{i} , BF , k) == true;
        contadorFP = contadorFP + 1;
    end
end

fprintf("Numero de falsos positivos - %.3f%%\n", 100*contadorFP/m2)

%% Exercício 4

fprintf("Numero de falsos positivos teórica- %.3f%%\n", 100*(1-exp(-k*m/n))^k)


%% Exercício 5
contadorFP = zeros(1,8);
idx = 1;
for k = 3:10
    for i = m + 1:m+m2
        if Verificar(dicionario{i} , BF , k) == true;
            contadorFP(idx) = contadorFP(idx) + 1;
        end
    end
    idx = idx + 1;
end
figure(1)
plot(3:10 ,  100*contadorFP/m2 , "b-o");
legend("Measure");
hold on

contadorTeorico = zeros(1 , 8);
idx = 1;
for k = 3:10
    contadorTeorico(idx) = 100*(1-exp(-k*m/n))^k;
    idx = idx + 1;
end

plot(3:10 , contadorTeorico , "r-*");
legend("Teorica");
hold off;

%% Funções
function BF = Inicializar(n)
    BF = false(1 , n);
end

function BF = Adicionar(chave , BF , k)
    n = length(BF);
    for i = 1:k
        chave = [chave num2str(i)];
        h = DJB31MA(chave , 127);
        h = mod(h, n) + 1;
        BF(h) = true;
    end
end

function check = Verificar(chave , BF , k)
    n = length(BF);
    check = true;
    for i = 1:k
        chave = [chave num2str(i)];
        h = DJB31MA(chave , 127);
        h = mod(h, n) + 1;
        if BF(h) == false
            check = false;
            break
        end 
    end
end