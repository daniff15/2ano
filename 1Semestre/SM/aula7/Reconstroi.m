function x = Reconstroi(X)
  X = fftshift(X);
  x = real(ifft(X) * length(X));
  
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