%% Exercício 2

load keys.mat

for i = 1 : length(keys)
   word = keys{i};
   hash = string2hash(word);
   disp(hash)
end

