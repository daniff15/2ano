function y = Chorus(x,fa,MaxDelay, NumComp)

    N=length(x);
    y=zeros(N,1);

    for n=1:NumComp
        CurDelay= rand()*MaxDelay;
        dn=max( [1 round(CurDelay*fa)]); % CurDelay a dividir por Ta dá o numero de amostras 
        y(dn:end)=y(dn:end)+x(1:end-dn+1);
    end
   
    Px = x'*x/N;
    Py = y'*y/N;
    y = y*sqrt(Px/Py);
    
end

%y = max(abs(x))/max(abs(y))*y;  %Ajuste da Amplitude