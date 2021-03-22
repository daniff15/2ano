function [N , M, Stream , CorLoad] = Load8bitStream(Filename)
    fid = fopen(Filename , 'r');
    N = fread(fid , 1 , 'uint16');
    M = fread(fid , 1 , 'uint16');
    CorLoad = fread(fid , 256 * 3 , 'uint8');
    CorLoad = double(reshape(CorLoad , 256, 3))/255;
    %Passar para 256*3 o tamanho da cena das cores se nao nao funciona pk
    %as cores veem sempre em 3 colunas
    Stream = fread(fid, inf , 'uint8');
end