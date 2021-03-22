function img2 = P07_img1(img,Np)
  if nargin < 2
    Np = 3;
  end
  Np2 = floor(Np/2); % -Np2:Np2
  s = size(img);
  img2 = img; % img2 = uint8(zeros(s));
  for y=1+Np2:s(1)-Np2
    for x=1+Np2:s(2)-Np2
      for z=1:s(3)
          if(uint8(x) < 200 & uint8(y) < 200 & uint8(z) < 200)
        tmp=img(y-Np2:y+Np2,x-Np2:x+Np2,z);
        tmp = [0 0 0];
        img2(y,x,z) = uint8(02);
          end
      end
    end
  end
  if nargout == 0
    figure
    subplot(1,2,1);
    imshow(img);
    subplot(1,2,2);
    imshow(img2);
  end
end