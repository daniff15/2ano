function T = DifImagem(Q)
    s = size(Q);
    T = Q;
    for y = 1: s(1) - 1
        for x = s(2) - 1
            T(y, x) = Q(y , x) - Q(y + 1, x);
        end
    end
    
    if nargout == 0
        figure
        subplot(1,2,1);
        imshow(Q);
        subplot(1,2,2);
        imshow(T);
end