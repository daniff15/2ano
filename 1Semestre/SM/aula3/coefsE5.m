%% funcao da 5

function [a,b] = coefsE5(x , k , T0, Ta)
    if nargin < 4
        Ta = 0.001;
    end
    if nargin < 3 
        T0 = 1;
    end
    if nargin < 2
        k = 8;
    end
    N = round(T0/Ta);
    t = (0 : N-1) * Ta;
    a = zeros(1 , k);
    b = zeros(1 , k);
    for K = 1:k
        a(K) = (2/N)*sum(x.*cos(K*t));
        b(K) = (2/N)*sum(x.*sin(K*t));
    end
end
