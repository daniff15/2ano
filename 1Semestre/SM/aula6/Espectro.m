function [X , f] = Espectro(x,Ta,w)
    if nargin < 3
        w=0;
    end
    x = x(:)';
    N = length(x);
    if w == 0
        w = ones(1, N);
    else
        w = blackman(N);
    end
    
    fa = 1/Ta;
    f = -fa/2 : fa/N : (fa/2-fa/N);
    X = fft(w.*x)/N;
    X = fftshift(X);
    
    if nargout == 0
        stem(f, abs(X));
    end
end