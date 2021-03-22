function [Simbolos , Frequencia] = Alfabeto2(texto)
    Simbolos = unique(texto);
    Frequencia = zeros(1 , length(Simbolos));
    i = 1;
    for letter = Simbolos
       count = length(strfind(texto , letter));
       Frequencia(i) = count/length(texto);
       i = i + 1;
    end
end

%Stor dentro do for
%Frequencia(idx) = length(find(tmp1 == tmp2(idx)));
%E as cenas tmp1 passou para codigo ASCII