function Save8bitStream(Filename, N , M , Stream)
    %filename = 'parede.rle';
    [Image , ColorMap] = imread('Parede_8bit.bmp');
    fid = fopen(Filename, 'w');
    fwrite(fid , N , 'uint16');
    fwrite(fid , M , 'uint16');
    fwrite(fid , 255*ColorMap , 'uint8');
    fwrite(fid , Stream , 'uint8');
    
    fclose(fid);
end