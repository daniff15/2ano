%% 1
clear all;
close all;
clc;
load Guitar03.mat;
sound(x , fa);

% 2 
[X , f] = Espectro(x , 1/fa);
 
stem(f , abs(X));

%% 3
idx = find(abs(f) < 100 | abs(f) > 400);
X3 = X;
X3(idx) = 0;

W = Reconstroi(X3);

%stem(f , abs(X3));

sound(W , fa);

%% 3.2

idx = find(abs(f) < 400 | abs(f) > 600);
X3 = X;
X3(idx) = 0;

W = Reconstroi(X3);

%stem(f , abs(X3));

sound(W , fa);

%% 3.3

idx = find(abs(f) < 600 | abs(f) > 1200);
X3 = X;
X3(idx) = 0;

W = Reconstroi(X3);

%stem(f , abs(X3));

sound(W , fa);
%% 4
MaxDelay = 0.5;
numComp = 5;
y = Chorus(x , fa , MaxDelay , numComp);

sound(y , fa);

[y , fy] = Espectro(y , 1/fa);
figure(400);
stem(fy , abs(y));
xlim([0 1500]);

[x , f] = Espectro(x , 1/fa);
figure(401);
stem(f , abs(x));
xlim([0 1500]);
%% Exercício 5

MaxDelay = 0.05;
Freq = 0.6;
y = Flanger(x , fa , MaxDelay , Freq);
sound(y , fa);

[y , fy] = Espectro(y , 1/fa);
figure(500);
stem(fy , abs(y));
xlim([0 1500]);

[x , f] = Espectro(x , 1/fa);
figure(501);
stem(f , abs(x));
xlim([0 1500]);

%% Exercício 6

Delay = 0.5;
Gain = 0.8;
y = Reverb(x , fa , Delay , Gain);
sound(y , fa);

[y , fy] = Espectro(y , 1/fa);
figure(600);
stem(fy , abs(y));
xlim([0 1500]);

[x , f] = Espectro(x , 1/fa);
figure(601);
stem(f , abs(x));
xlim([0 1500]);


%% TOS 1 

garca = imread('Garca.jpg');

P07_img1(garca);
