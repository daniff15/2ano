clear all;
close all;
%%
ta=0.01;
%%
t5=0:ta:5;
tp5=0:ta:5;
x=2*sin(4*pi*t5);
y=cos(10*pi*t5);
z=x.*y;
t10=0:ta:10;
w=3*sin(pi*t10)+2*sin(6*pi*t10);

%%

subplot(4,1,1);
plot(t5,x)
title('x');
xlabel('tempo (s)');
ylabel('Amplitude');
subplot(4,1,2);
plot (t5,y)
title('y');
xlabel('tempo (s)');
ylabel('Amplitude');
subplot(4,1,3);
plot(t5,z)
title('z');
xlabel('tempo (s)');
ylabel('Amplitude');
subplot(4,1,4);
plot(t10,w)
title('w');
xlabel('tempo (s)');
ylabel('Amplitude');
% função whos para mostrar todos os detalhes das variaveis e tamanho que
% x2=x.^2 Faz o quadrado de todos os membros
%ver o comando subplot
% x=zeros(1,100) 1*100 matriz
% ocupam
%Conclusao:  Maior tempo de amostragem: Representacao menos accurate do sinal
%  mas ocupa menos memoria e e mais rapido
%%
figure;
p=plot(t5,x,t5,y,t5,z,'.-',t10,w)
p(1).Color='red';
p(2).Color='blue';
p(2).LineStyle='--';
p(2).LineWidth=2;
p(3).Color='green';
p(4).Color='yellow';
p(4).LineWidth=2;
xlabel('TEMPO (s)')
title('Exercicio 3')
ylabel('Amplitude')
legend('x','y','z','w')
%%
figure;
t=0:ta:5;
q=zeros(length(t),length(t));
for i=1:length(t)
    for j=1:length(t)
        q(i,j)= 2*sin(2*pi*(2*t(i)+t(j)));
    end
end
mesh(t,t,q);
colormap('gray');
colorbar;


%%
figure;
Ta=1/25;
%usar t5

x1=-5:ta:5;
x2=-5:ta:5;
r = zeros(length(x1),length(x2));
t=0:ta:5;
for i=1:length(t)
    tic
    for j=1:length(x1)
        r(j,:)=2*sin(2*pi*sqrt(x1(j)^2+x2.^2)-2*pi*t(i));   
    end
    mesh(x1,x2,r);
    view(2);
    drawnow() 
    pause(Ta-toc);
end