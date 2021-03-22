%% Ex 2
frequencias = [14 64 5 10 7];
CompMesg = 5;
nBits = repmat(ceil(log2(5)),5,1);

[NumBits,NumBPS] = GeraMensagem((frequencias)',CompMesg,nBits);

%% Ex 3
CompMesg = 5;
nBits = ([2 2 3 2 3])';

[NumBits,NumBPS] = GeraMensagem((frequencias)',CompMesg,nBits);