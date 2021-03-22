function H = Entropia(texto)
    [Simbolos , Frequencia] = Alfabeto2(texto);
    H = 0;
    
    %H = sum(Frequencia .* (-log2(Frequencia)));
    
    for f= Frequencia
       H = H + (f * log2(1/f)); 
    end
end