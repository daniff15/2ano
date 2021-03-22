


%% Clear
close all;
clear all;
clc;

%% Ex2a
Ta = 1/20;
ta = 0:Ta:10;
x = sin(2*pi*ta);
Espetro(x,Ta);

%% Ex2b
Ta = 1/100;
tb = 0:Ta:5;
y = sin(10*pi*tb) + cos(12*pi*tb) + cos(14*pi*tb - pi/4);
Espetro(y,Ta);

%% Ex2c
Ta = 0.01;
T = 2;
N = 100;
t = (0 : 1000-1) * Ta;
Z = [ones(1 , N) zeros(1 , N)];
Z = repmat(Z , 1 , 5);
figure(23)
plot(t ,Z);
figure(5345)
Espetro(Z,Ta);
xlim([-3 3])

%% Ex2d
N = 100;
w = [0 : (N/2)-1 (N/2) : -1 : 1 0: -1 :1-(N/2 - 1) 1-(N/2) : 0]/N;
w = repmat(w, 1 , 5);
Espetro(w , Ta , 5);
N = length(w);
t = (0 : N-1) *Ta;
Reconstroi(w);
figure(432)
plot(t , w);

Reconstroi(w)

%% Ex3/4

fr = rand(20,1)*19 +1; %frequencias random
phir = rand(20,1)*2*pi -pi; %fases random
Ta = 0.001;
N = 500;
t = (0:N-1)*Ta;
x = zeros(size(t));

for k=1:20
    x = x + sin(2*pi*fr(k)*t + phir(k));
end
figure(234)
plot(t, x);
title("Funcao x");
figure(4)
Espetro(x,Ta);
title("Espetro sem Windowing");
figure(2345)
Espetro(x , Ta , 4);
title("Espetro com windowing");
figure(25)
Reconstroi(x);
title("Reconstroi");
plot(t, x);

%% Exercicio 6
clear all
x=(-5:0.1:5);
y=(-5:0.1:5);
z=zeros(length(x),length(y));
for ix=1:length(x)
  for iy=1:length(y)
    z(ix,iy)=sin(2*pi*(2*x(ix)+y(iy)));
  end
end
Z=fft2(z);
% figure(13);mesh(x,y,z)
% figure(14);plot(z(:,1))
% figure(15);plot(z(1,:))
% figure(16);mesh(abs(Z))
% figure(17);mesh(abs(fftshift(Z)))

w = zeros(length(x) , length(y));
for ix2=1:length(x)
  for iy2=1:length(y)
    w(ix2,iy2)=sin(2*pi*(sqrt(x(ix2)^2+y(iy2)^2)));
  end
end

W=fft2(w);
%figure(1);mesh(x,y,w)
%figure(2);plot(w(:,1))
%figure(3);plot(w(1,:))
figure(4);mesh(abs(W))
figure(5);mesh(abs(fftshift(W)))

%% Exercicio da funcao do teste 3

Ta = 0.01;
t = (0:N-1)*Ta;
y = tanh(t);

Espetro(y , Ta);
xlim([-1 1])


%% Entropia 

P = [0.14 0.65 0.1 0.07 0.04];
ans = 1./P;

H = sum(P .* log2(1./P));
Some = sum(P .* (-log2(P)));
    
%% Funções
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


function x = Reconstroi(X)
  X = X * length(X);
  X = fftshift(X);
  x = real(ifft(X));
  
%   function [x,t] = Reconstroi(X,fa)
% 
%     Ta = 1/fa;
%     N = length(X);
%     t = (0:N-1)*Ta;
%     
%     X = X*N;
%     X = ifftshift(X);
%     x = ifft(X);
     %if nargout==0
     %    plot(t,abs(X));
     %end
%     % nao sei se é suposto meter o plot
% end
% 


end
