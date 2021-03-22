% imagem

img = imread('Parede.jpg');
%whos;
figure(1);
imshow(img);
img2 = img(1:2:end , 1:2:end, :);
figure(2)
imshow(img2);
%imshow(1:4:end , 1:4:end, :)
%imshow(1:8:end , 1:8:end, :)
%imshow(1:16:end , 1:16:end, :)

for k =2:2:16;
    imshow(img(1:k:end , 1:k:end , :));
    pause(2);
end