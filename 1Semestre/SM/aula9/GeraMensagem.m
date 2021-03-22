function [NumBits,NumBPS] = GeraMensagem(f,CompMesg,nBits)
    f = f/100;
    N = length(f);
    indexs = randi([1,N],1,CompMesg);

    NumBits = 0;
    for i = indexs
        NumBits = NumBits + nBits(i);
    end

    NumBPS = sum(f .* nBits);

    %Minha maneira:
    %NumBPS = 0;
    %for c = 1:N
    %    NumBPS = NumBPS + (sum(indexs==c) * nBits(c));
    %end
    %NumBPS = NumBPS / CompMesg;
end

%     f = f/100;
%     NumBits = 0;
%     for n = 1:CompMesg;
%         q = rand();
%         i = sum(q < cumsum(f)) + 1;
%         NumBits = NumBits + nBits(i);
%     end
%     NumBPS = NumBits / CompMesg