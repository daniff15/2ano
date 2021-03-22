% perido de 10 periodos - 
Ta = 0.01;
N = 1000;
t = (0:N-1) * Ta;
x = sin(2*pi*t); %f = 1
f = zeros(1,N);
X2 = zeros(1,N);
[X2 , f]=Espectro(x , Ta , 5);

figure(34)
stem(f, abs(X2))


function [X,f] = Espectro(x,Ta,win)
    
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
    
    plot(f,abs(X));
end
