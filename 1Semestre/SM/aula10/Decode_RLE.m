function img_ = Decode_RLE(N , M , z)
    img_ = zeros(N * M , 1 , 'uint8');

    ii = 0;
    for i = 1:2:length(z)
        pix = z(i);
        count = z(i + 1);
        for idx = ii+1 : count + ii
           img_(idx) = pix; 
        end
        ii = count + ii;
    end

    img_ = reshape(img_ , M , N)';
end