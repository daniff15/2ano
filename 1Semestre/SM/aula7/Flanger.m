function y=Flanger(x,fs,MaxDelay,Freq)

    N=length(x);
    y=zeros(N,1);

    for n=1:N
        dn=round((MaxDelay/2*cos(2*pi*Freq*(n-1)/fs)- MaxDelay/2)*fs);
        y(n)=x(max([1 n+dn]));

    end
    y=x+y;
    Px=x'*x/N;
    Py=y'*y/N;
    y=y*sqrt(Px/Py);
end