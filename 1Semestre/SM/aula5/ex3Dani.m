clear all;
close all;

img = imread('Parede.jpg');


figure(1);
imshow(img);

img2 = img(1:2:end , 1:2:end , :);
figure(2);
imshow(img2);

img4 = img(1:4:end , 1:4:end , :);
figure(3);
imshow(img4);

img8 = img(1:8:end , 1:8:end , :);
figure(4);
imshow(img8);

img16 = img(1:16:end , 1:16:end , :);
figure(5);
imshow(img16);