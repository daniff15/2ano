clear all;
close all;
clc;

%%
N = 100;
Ta = 0.01;

y = [-N:N-1 N:-N+1 -N:N-1 N:-N+1]/100;

t = (0:400-1)*Ta;
figure
plot(t,y);

figure
Espetro(y,Ta);
xlim([-3 3]);


%% 
Ta = 0.01;
t =  [0 : Ta : 5];
x = 2*sin(pi*t) + cos(2*pi*t);
plot(t , x);
%% Func

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
    
    plot(f,abs(X));
end