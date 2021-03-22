function [Symb , Freq] = ImageSymbols(Image)

    Symb = [];
    [N , M] = size(Image);
    Image = reshape(Image, 1, N*M); %Tudo numa linha
    Symb = unique(Image);
    Freq = zeros(size(Symb));
    ind = 1;
    for c = Symb
        Freq(ind) = length(find(Image == c));
        ind = ind + 1;
    end

% Código que eu tinha feito inicialmente mas nao me davam valores "reais"
%     Symb = [];
%     [N , M] = size(Image);
%     Image = reshape(Image, 1, N*M); %Tudo numa linha
%     Symb = unique(Image);
%     Freq = zeros(size(Symb));
%     %idxi = 1;
%     for c = Image
%         idx = find(Symb == c);
%         if(ismember(c , Freq))
%             Freq(idx) = Freq(idx) + 1;
%         else
%             Freq(idx) = 1;
%         end
%         %idx(idxi) = find(Symb == c);
%         %idxi = idxi + 1;
%     end
end