%% Exercício 1a)

N = 1e5;
n= 8;
p1 = 0.2/100;
p2 = 0.5/100;
pa = 1/100;

c1 = sum(rand(n , N) < p1);
c2 = sum(rand(n , N) < p2);
ca = sum(rand(n , N) < pa);

def = c1 + c2 + ca>=1;

prob1a = sum(def)/N

%% Exercício 1b)
bd = 0;

for i=1:N
    if (c1(i)==0 && c2(i)==0 && ca(i)==1)
        bd = bd + 1;
   end
end
prob1b=bd/sum(def>0)

%% Exercício 2a)
defb = c1 + c2 + ca;

prob2a = sum(defb == 0)/N

%% Exercício 2b) 
k = 0; %brinquedos sem defeito
prob2b = nchoosek(n , k) .* (p1+p2+pa).^k .* (1-(p1+p2+pa)).^(n-k)

%% Exercício 2c)

for n = 2:20
    c1 = sum(rand(n , N) < p1);
    c2 = sum(rand(n , N) < p2);
    ca = sum(rand(n , N) < pa);
    def = c1 + c2 + ca;
    probs(n - 1) = sum(def == 0)/N;
end
n = 2:20;
plot(n , probs);

%% Exercício 2d)

% Exercicio para se fazer no relatorio e explicar o que observamos

%% Exercício 3)

%a)
clearvars
N=1e5;
n=8;
p1=0.002;
p2=0.005;
pm=0.01;
X=0:8;
px=zeros(1,9);
lancamentos1=rand(n,N)<p1;
lancamentos2=rand(n,N)<p2;
lancamentosm=rand(n,N)<pm;
x=sum(lancamentos1)+sum(lancamentos2)+sum(lancamentosm);
for i=X
   sucessos= x==i;
   px(i+1)=sum(sucessos)/N;
end

figure(2)
stem(X,px), xlabel("x"), ylabel("px(x)");
axis([-1 9 0 1])
grid on

%b)
%probabilidade de X>=2 <=> 1-(prob(X==0) + prob(X==1))
prob3b = 1-(px(1) + px(2))

%c)
media=sum(px.*X)
variancia=sum(px.*X.^2)-media^2
desvio=sqrt(variancia)

%d)
n=16;
X=0:16;
px=zeros(1,17);
lancamentos1=rand(n,N)<p1;
lancamentos2=rand(n,N)<p2;
lancamentosm=rand(n,N)<pm;
x=sum(lancamentos1)+sum(lancamentos2)+sum(lancamentosm);
for i=X
   sucessos= x==i;
   px(i+1)=sum(sucessos)/N;
end
figure(3)
stem(X,px), xlabel("x"), ylabel("px(x) para n=16");
axis([-1 17 0 1])
grid on

probXmaior2=1-(px(1) + px(2))

Dmedia=sum(px.*X)
Dvariancia=sum(px.*X.^2)-Dmedia^2
Ddesvio=sqrt(Dvariancia)



%% Exercício 4
%alinea a)
N = 1e5;
n= 20;
p1 = 0.2/100;
p2 = 0.5/100;
pa = 0.1/100;

c1 = rand(n , N) < p1;
c2 = rand(n , N) < p2;
ca = rand(n , N) < pa;
caixa20 = c1 + c2 + ca; %cada coluna corresponde a uma caixa
comercializadas = 0;

c20aleatorio = caixa20(randperm(20 , 1) , :); %ao usar randperm(20,1) estamos a criar uma matriz 1 x 1
%que nos vai fornecer um valor random entre 1 e 20, ao usarmos esse valor
%em caixa20 vai-nos dar uma linha random para cada coluna criando assim a
%matriz c20aleatorio(1 x N)

for i = 1 : N
    if(c20aleatorio(i) == 0)
        comercializadas = comercializadas + 1;
    end
end

prob_comercializada = comercializadas/N;
fprintf("Probabilidade de caixas serem comercializadas - %d\n" , prob_comercializada)


%alinea b)
N = 1e5;
n= 20;
p1 = 0.2/100;
p2 = 0.5/100;
pa = 0.1/100;

c1 = sum(rand(1 , N) < p1);
c2 = sum(rand(1 , N) < p2); 
ca = sum(rand(1 , N) < pa);%usa-se em vez de n em rand(n, N) 1 por causa q so queremos a probabilidade 
%de um brinquedo ter defeito para podermos usar essa probabilidade para ver se nas caixas quantos 
%brinquedos vao ter defeito
def = c1 + c2 + ca;

prob_defeito = sum(def)/N; %prob de um brinquedo ter defeito
%probabilidade inicializada 
m = 0;
p = 0;
while (p <= 0.9)
    m = m +1;
    % se houver numeros >1 entao sao brinquedos com defeito
    %agora vamos escolher brinquedos aleatorios da matriz caixas
    %e preencher cada coluna de amostras, se houver nºs > 1 entao ha
    %defeitos , basicamente vai servir para ao escolher random brinquedos
    %de cada caixa, ver se a caixa pode ou nao ser comercializada
    caixas=rand(n,N)<prob_defeito;    %linha: brinquedo
                        %coluna: caixa
                        %valor 1: brinquedo com defeito
    amostras = zeros(m,N);
    for col = 1:N    %percorrer cada caixa
        lin=1;
        for i = randperm(20,m)%i percorrera os numeros de linhas aleatorias da 
                               %matriz caixa, que vao representar os brinquedos
            amostras(lin,col)=caixas(i,col);%que serão testados nessa caixa amostras: matriz
                                  %em que cada coluna representa uma caixa,contendo 
                                  %essa coluna os brinquedos que serão testados, os brinquedos têm valor 1 se sao defeituosos
            lin = lin +1;
        end
    end
    %randperm(n, m) - faz um vetor de numeros desde 1 ate 20, e faz m
    %numeros entre esses valores
     
    defeituosas = sum(caixas);
    bons = 0;
    
    %percorrer defeituosas(brinquedos) e amostras(caixas) para ver se ha
    %brinquedos defeituosos
    for caixa = 1:N
        if(defeituosas(caixa)==0)   %ver se os brinquedos tem defeito
            bons=bons+1;
        end
        for j = 1:m
            if( amostras(j , caixa)~=0 )    %retirar caixas com defeito para nao serem comercializadas
                N =N-1;
            end
        end
    end
    p = bons/N;
end %quando acabar vai acabar com um m maior, logo tem de se tirar um 


fprintf("O numero minimo de m para se poder atingir o objetivo é %d." , m);


