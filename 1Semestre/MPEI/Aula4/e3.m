%% Alinea a)

for i = 1 : 20
  r = rand(1, 20); % Generate 20 random numbers
  r = r / sum(r);  % Normalize so the sum is 1.
  
  T(:,i) = r';
end

%sum(T)

%% Alinea b)

x = [2 , 5 , 10 , 100];
atual = zeros(20,1);
atual(1) = 1;
for X = x
    w = T^X*atual;
    fprintf("%d transicões e estar no estado 20- %f\n", X , w(20));
end