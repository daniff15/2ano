%% Exercício 1
clear all
clc
[Image , ColorMap] = imread('Parede_8bit.bmp');
[N , M] = size(Image);
imshow(Image , ColorMap)


%% Exercício 2

img_rle = EncodeImage_RLE(Image);


%% Exercício 3

Save8bitStream('parede.rle' , N , M , img_rle);

% TAXA DE COMPRESSÃO
% NUMERO DE PIXEIS QUE NOS DERAM AGORA A DIVIDIR PELO NUMERO DE PIXEIS DA
% IMAGEM INICIAL

sizeImg_RLE = size(img_rle); %Da vetor 1 por nº de bits
sizeImg_RLE = sizeImg_RLE(2);
sizeInicial = N*M;

TaxaComp = sizeImg_RLE / sizeInicial;

fprintf ('TAXA DE COMPRESSAO --> %.2f %%\n' , TaxaComp * 100);


%% Exercício 4 

filename = 'parede.rle';
[N , M , z , CorLoad] = Load8bitStream(filename);

%% Exercício 5
% 
img_ = Decode_RLE(N , M , z);

img_ = reshape(img_ , M , N)';

imshow(img_, CorLoad);
% if N_ * M_ ~= sum(img_rle_(2:2:end))
%     error('BAD DATA');
%     quit;
% end
% 
% if ii ~= N_*M_
%     error('IMPOSSIBLE');
%     quit;
% end
% 
% img_ = reshape(img_ , N , M)';

% TOS tinha estas duas condiçoes de merda, dont know why



%% Exercício 6
clear all;
close all;
clc
[imgARCA , CorArca] = imread('Arca_8bit.bmp');
[N , M] = size(imgARCA); 
imgARCA_rle = EncodeImage_RLE(imgARCA);


sizeImgArca_RLE = size(imgARCA_rle); %Da vetor 1 por nº de bits
sizeImgArca_RLE = sizeImgArca_RLE(2);
sizeInicial = N*M;

TaxaComp = sizeImgArca_RLE / sizeInicial;

fprintf ('TAXA DE COMPRESSAO --> %.2f %%\n' , TaxaComp * 100);

% A taxa de compressao deste exercício foi 120% um valor superior a 100% o
% que nos permite afirmar que o algoritmo de compressão RLE, é um algoritmo mau
% pois quando a imagem fornecida em cada pixel muda de cor, vai fazer com
% que fique por exemplo com a sequencia (110 1 114 1 120 1 180 1) e antes
% apenas estava (110 114 120 180), logo com este algoritmo fez com que a
% imagemRLE criada ficasse com um tamanho superior à imagem inicial, que
% era exatamente o oposto do que queriamos fazer.

%Com a imagem 'Floresta.bmp' da-nos uma taxa de compressao de 35% o que é um valor bom para a taxa de compressão
%Quanto mais baixo o valor da taxa de compressão maior é o valor que a
%imagem comprimiu


%% 

cores = unique(CorLoad)