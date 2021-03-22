%% ex1
clear all;
close all;


T = 0.5;
Ta = 5 * (T/1000);
t = 0: Ta : 5*(T-Ta);
x = 2 * sin(4*pi*t);

T = 1/5;
Ta = 5 * (T/1000);
ty = 0: Ta : 5*(T-Ta);
y = sin(10*pi*ty + pi/2);

T = 1;
Ta = 5 * (T/1000);
tz = 0: Ta : 5*(T-Ta);
z = sin(6*pi*tz) + sin(8*pi*tz);

T = 1;
Ta = 5 * (T/1000);
tw = 0: Ta : 5*(T-Ta);
w = sin(6*pi*tw) + sin((8*pi*tw) + 0.1);

T = 2;
Ta = 5 * (T/1000);
tq = 0: Ta : 5*(T-Ta);
q = sin(6*pi*tq) + sin(7*pi*tq) + sin(8*pi*tq);

figure(1);
plot(t , x ,"-r","Linewidth" ,2)
hold on;
zoom on;
plot(ty , y ,"-y" ,"Linewidth" , 3)
plot(tz , z , "-b" , "Linewidth" , 1)
plot(tw , w ,"g-." ,"Linewidth" , 1)
plot(tq , q , "b--" , "Linewidth" , 2)
hold off
xlabel("Time (s)");
ylabel("Amplitude");
title("x signal");
legend("x","y","z","w","q");



%% ex3

%x = 2 * sin(4*pi*t);
y = sin(10*pi*ty + pi/2);
z = sin(6*pi*tz) + sin(8*pi*tz);
w = sin(6*pi*tw) + sin((8*pi*tw) + 0.1);
q = sin(6*pi*tq) + sin(7*pi*tq) + sin(8*pi*tq);
y2 = sin(2*pi*t + pi/3) + 2*cos(5*pi*t - pi/4);
%pot = potencia(x, t)
pot = potencia(y , ty)
pot = potencia(z, tz)
pot = potencia(w , tw)
pot = potencia(q, tq)
pot = potencia(y2, t)

%potencia em teoria = lim t tende para infinito 1/2T * primitiva de -T a T
%de f(t) ao quadrado em modulo
%stor
%ta = 0.01;
%tc = 0.5 ;
%t = 0: ta : Tx - ta;
%x = 2 * sin(4*pi*t);
%Px = sum(x.^2)/length(x)

%% Exercicio 4
clear all;
close all;

min = -pi;
max = pi;
N = 3;
T = 1/N;
Ta = 5 * T /1000;
t = 0:Ta:(5*T-Ta);

f1 = 3;
f2 = 3/1.1;
f3 = 3/1.2;

figure(1);
xlabel('time (s)');
ylabel('amplitude');
title('Ex4');
grid;
hold on
potX2 = zeros(1 , 3);
for i=0:2
    r = (max - min)*rand(1,3) + min;
    x = sin(2*pi*f1*t + r(1)) + sin(2* pi * f2 *t + r(2)) + sin(2* pi * f3 * t + r(3));
    plot(t,x);
    pot = potencia(x , t)

end
hold off

function pot = potencia(x , t)
    pot = (x * x') / length(x);
end