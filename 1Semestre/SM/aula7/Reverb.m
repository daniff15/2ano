function y=Reverb(x,fa,Delay,Gain)

    N=length(x);
    y=zeros(N,1); 
    D=round(Delay*fa); %transformar o delay de y num numero de amostras (segundos p amostras)
    %(Delay)/Ta = , round para int, amostras sempre inteiras

    %implementar o diagrama de blocos (caderno)
    %percorremos todas as amostras. 
    %Vai ser y- (n-D) o que aconteceu de amostras atrasadas. Adicionamos ao y a
    %amostra atrasada, confuso ver video min 33.
    %Mas pq max? 
    for n=1:N
        y(n)=x(n) + Gain*y(max([1 n-D]));

    end
     Px=x'*x/N;
     Py=y'*y/N;
     y=y*sqrt(Px/Py);
end