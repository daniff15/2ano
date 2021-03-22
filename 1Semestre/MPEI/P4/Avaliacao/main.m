%% Aplication
clearvars
load uitem.mat;
load filmesPorUser.mat


n = input('Insert User ID (1 to 943)');

while n < 1 || n > 943
    fprintf('Invalid inserted ID.\n')
    n = input('Insert User ID (1 to 943)');
end

if n > 0 || n < 944
    opt = input('1 - Your Movies\n2 - Get Suggestions\n3 - Search Title\n4 - Exit\nSelect choice: ');
end

optSelected(opt , n , Set , uitem)

function optSelected(opt , n , Set , uitem)
    switch opt
        case 1
            for i=1:length(Set{n})
                id = Set{n}(i);
                fprintf('(ID: %d) %s\n' , id , uitem{id,1});
            end
            pause()
            clc
            opt = input('1 - Your Movies\n2 - Get Suggestions\n3 - Search Title\n4 - Exit\nSelect choice: ');
            optSelected(opt , n , Set , uitem)

        case 2
            option = input('1- Action, 2- Adventure, 3- Animation, 4- Children´s\n5- Comedy, 6- Crime, 7- Documentary, 8- Drama\n9- Fantasy, 10- Film-Noir, 11- Horror, 12- Musical\n13- Mystery, 14- Romance, 15- Sci-Fi, 16- Thriller\n17- War, 18- Western\nSelect one: ')
            
            pause()
            clc
            opt = input('1 - Your Movies\n2 - Get Suggestions\n3 - Search Title\n4 - Exit\nSelect choice: ');
            optSelected(opt , n , Set , uitem)
        case 3
            fprintf '3\n' %Insert your code below here
            
            pause()
            clc
            opt = input('1 - Your Movies\n2 - Get Suggestions\n3 - Search Title\n4 - Exit\nSelect choice: ');
            optSelected(opt , n , Set , uitem)
        case 4
            fprintf '4\n' %Insert your code below here
        otherwise 
            fprintf 'Invalid option\n'
    end
end

%Meter no relatorio que justifiquem a nossa decisao final sobre os valores
%para o shingles e colocar os testes que fizemos com estes valores
