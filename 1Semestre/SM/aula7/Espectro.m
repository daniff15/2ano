function [X,f] = Espetro(x,Ta,win)
    
    if nargin < 3
       win = 0; 
    end
    fa = 1/Ta;
    N = length(x); 
    if(nargin > 2)
    if(win ~= 0)
        win = blackman(N);
        win = reshape(win, size(x));
        x= x.*win;
    end
    end
    
    
    df = fa/N ;
    f = -fa/2 : df : (fa/2-df);
    X = fft(x);
    X = fftshift(X);
    X = X/N;
    
    stem(f,abs(X));
end
