%% Exercicio 4a)
p= 0;
m = 365;
N = 1e5;
n = 0;
while p <= 0.5;
   n = n +1;
   anis = randi([1 m] , n , N);
   res= true(1,N);
   for i = 1:N
       res(i) = length(unique(anis(:,i)))<n;
   end
   p = sum(res)/N;
end

No_Pessoas = n

%% Exercicio 4b)
clear all;

p = 0;
m = 365;
N = 1e5;
n = 0;

while p <= 0.9;
   n = n +1;
   anis = randi([1 m] , n , N);
   sucesso = 0;
   for i = 1:N
       if length(unique(anis(:,i)))<n 
          sucesso = sucesso + 1;              
       end  
   end
   p = sucesso/N;
end

No_Pessoas = n