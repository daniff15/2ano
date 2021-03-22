function [x ,t] = GeraSinal(N , Ta)
    
    t = (0 : N-1)*Ta;

    phil = Ta*cumsum(pi*randn(1, N));
    phil2 = Ta*cumsum(pi*randn(1, N));
    
    x = sin(2 * pi * t) + 0.5*sin(20*pi*t + 10*phil) + 0.5*sin(23*pi*t + 10*phil2);
    
    if nargout < 1
        plot(t,x); grid on; zoom on;
    end
end