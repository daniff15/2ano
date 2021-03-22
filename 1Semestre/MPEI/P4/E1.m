%% Exercício 1a
N = 1e5;
alpha =  ['a':'z' 'A':'Z'];
tic 
keys = geraChaves(N , 6 , 20 ,alpha);
fprintf("1a) No. keys: %d\n" , length(keys));
fprintf("    No. unique: %d\n" , length(unique(keys)));
fprintf("    Running time: %f seconds \n" , toc);
save 'keys' 'keys'

%% Exercício 1b
N = 1e5;
load prob_pt.txt;
alpha =  ['a':'z'];
tic
kB = geraChaves(N , 6 , 20 ,alpha, prob_pt);
fprintf("1a) No. keys: %d\n" , length(keys));
fprintf("    No. unique: %d\n" , length(unique(keys)));
fprintf("    Running time: %f seconds \n" , toc);
save 'kB' 'kB'