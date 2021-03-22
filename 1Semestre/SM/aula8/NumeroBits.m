function NumBits = NumeroBits(texto)
    [Simbolos , Frequencia] = Alfabeto2(texto);
    
    [Frequencia , idx] = sort(Frequencia , 'descend');
    
    Simbolos = Simbolos(idx); %Simbolos ordenados por frequencias.
    
    codificacao = {};
    codificacao{1} = '0';
    for i = 1: (length(Simbolos)-1)
        aux = repmat('1' , i);

        codificacao{end + 1} = strcat(aux(1, :), '0');
    end
    
    NumBits = 0;
    for letter = texto
        letra = strfind(Simbolos , letter);
        NumBits = NumBits + length(codificacao{letra});
    end
    
end