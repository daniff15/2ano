clear all;
close all;
%% a1
Ta = 0.01;
t5 = 0 : Ta : 5;
t10 = 0 : Ta : 10;
x = 2 * sin(4 * pi * t5);

y = cos(10 * pi * t5);

z = x .* y;

w = 3 * sin(pi * t10) + 2 * sin(6 * pi *t10);

q = zeros(length(t5) , length(t5));

for i= 1: length(t5)
    for j= 1: length(t5)
        q(i,j) = 2 * sin(2 * pi * (2 * t5(i) + t5(j)));
    end
end

%% graf
figure;
plot(t5,x)
title('Grafico')
xlabel('t')
ylabel('Amp')
legend('x(t)')


%% plot all the graphics
plot(t5 ,x ,"r-")
hold on
plot(t5 , y , "b--")
plot(t5 , z , "g-.")
plot(t10, w , "y-")
hold off
legend("Grafico x" , "Grafico y" , "Grafico z" , "Grafico w")


figure(40);
mesh(t5, t5, q)
colorbar;
xlabel('t_1'),
ylabel('t_2'),
zlabel('amplitude')
zoom on;


%% 5
% 5 do stor
Ta =1/25;
Tx = 0.1;
x1 = (-5:Tx : 5)'; 
x2 = -5:Tx : 5;
a = 2*pi*sqrt(x1.^2 + x2.^2 );
figure
for t =0:Ta:5
    tic;
    mesh(x1 , x2 , 2*sin(a-2*pi*t))
    axis("equal");
    view(2);
    drawnow()
    pause(max(0.001, min(0.1, toc-Ta)));
end
% figure(15)
% ta = 0.01;
% Taa = 1/25; 
% t = 0: ta :5;
% x1 = -5 : ta:5;
% x2 = -5 : ta:5;
% r = zeros(length(x1),length(x2));
% 
% for i=1:length(t)
%     tic
%     for j=1:length(x1)
%         r(j,:)=2*sin(2*pi*sqrt(x1(j)^2+x2.^2)-2*pi*t(i)); 
%     end
%     
%     mesh(x1, x2, r);
%     view(2);
%     drawnow() 
%     pause(Ta-toc);
% end


