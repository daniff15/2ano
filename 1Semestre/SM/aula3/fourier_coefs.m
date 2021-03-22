function [x,t]  = fourier_coefs(Ta, f0 , Np, ak , bk)
    T0 = 1/f0;
    n = T0/Ta ; % numero de apostas num periodo
    N = Np * n; % numero de amostras totais;
    t = (0 : N-1) * Ta;
%     AK = 0;
%     BK = 0;
    x = zeros(size(t));
    for k = 1 : length(ak)
        x = x + ak(k)*cos(2*pi*k*f0*t) + bk(k)*sin(2*pi*k*f0*t);
%         AK = AK + ak(k)*cos(2*pi*k*f0*t);
%         BK = BK + bk(k)*sin(2*pi*k*f0*t); %da bues valores pk ta sempre a multiplicar pelo t
        %q sao 10000 valores e as matrizes vao somando em x
    end
      
%     x = AK + BK;
end