function img_rle = EncodeImage_RLE(Image)
    [N , M] = size(Image);
    x = Image';
    x = reshape(x, 1, N*M); %Tudo numa linha
    img_rle = zeros(0,0,'uint8');
    i = 1;
    L = N*M;

    while i < L
        c = x(i);
        j = 1;
        while (i + j <= L && x(i+j) == c)
           j = j + 1; 
        end

        img_rle(end + 1) = c;
        img_rle(end+ 1) = j;
        i = i + j;
    end
end