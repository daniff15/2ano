function [x , t] = geraSinalTOS(N , Ta)
    if nargin < 1 ; N=1000 ; end
    if nargin < 2; Ta = 0.01; end
    t = (0 : N-1)*Ta;
    phil = Ta*cumsum(pi*randn(1, N));
    phil2 = Ta*cumsum(pi*randn(1, N));

    x = sin(2 * pi * t) + 0.5*sin(20*pi*t + 10*phil) + 0.5 * sin(21*pi*t + 10*phil2);

    if nargout <1 ; plot(t,x); grid on; zoom on; end
end