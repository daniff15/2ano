% function cellKeys = geraChaves(N , iMin , iMax , chars , probs)
%     cellKeys = {};
%     n = 0;
%     sizeWord = randi([iMin iMax]);
%     palavra = "";
%     if nargin < 5
%         while n < sizeWord
%            idx = randi(length(chars));
%            palavra = palavra + chars(idx);
%         end
%         
%         for word = cellKeys
%             if(ismember(palavra , cellKeys))
%                continue 
%            else
%                cellKeys{end + 1} = palavra;
%                n = n + 1;
%            end
%         end
%     end
% end
% Nao faz sentido a minha, basicamente so tava a gerar uma palavra

%% Stor

function keys = geraChaves(N , iMin , iMax , chars , probs)
if nargin < 5
    probs = 1;
end
keys = {};
n = 0;
Nalpha = length(chars);
    while n < N
       tamanho = randi([iMin iMax]);
       if probs == 1
           idx = randi(Nalpha , 1 , tamanho);
       else
%            states = 1:length(chars);
%            for j = 1:length(states) 
%                U=rand();
%                i = 1 + sum(U > cumsum(probs));
%                idx(j) = states(i);
%            end
%STOR
           as = cumsum(probs);
           idx = zeros(1, tamanho);
           U = rand(1, tamanho);
           for i = 1:tamanho
              idx(i) = 1 + sum(U(i) > as); 
           end

       end

       key = chars(idx);
       %Explicaçáo disto na cena de explicaçao para a PL03
       if ~ismember(key , keys)
           n = n + 1;
           keys{n} = key;
       end
    end
end
