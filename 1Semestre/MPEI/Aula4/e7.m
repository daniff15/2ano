%% Alinea a)

%pageRank calcula-se com 1/n
%em q n= numero de links de saida

pages = [0 1 0 0 0 0
    0 0 1/2 0 1/2 0
    0 0 0 1 0 0
    0 0 1 0 0 0
    1/3 1/3 0 0 0 1/3
    0 0 0 0 0 1]';

P = [1/6;1/6;1/6;1/6;1/6;1/6];
for i = 1:10
    P = pages*P;
end
P
%sum(P)
%Esta parte a seguir provavelmente esta mal
max = 0;
for d = 1:6
    if(P(d) > max)
        max = P(d);  
    end
end

if(max == P(1))
    fprintf("A)  pageRank\n");
end

if(max == P(2))
    fprintf("B)  pageRank\n");
end

if(max == P(3))
    fprintf("C)  pageRank\n");
end

if(max == P(4))
    fprintf("D)  pageRank\n");
end

if(max == P(5))
    fprintf("E)  pageRank\n");
end

if(max == P(6))
    fprintf("F)  pageRank\n");
end


%% Alinea b)

%Dead End = F
%Spider Trap = CD