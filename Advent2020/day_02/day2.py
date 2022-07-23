counter = 0
with open('input.txt') as f:
    for line in f:
        content = line.strip().split()
        numbers = content[0].split('-')
        min_char = int(numbers[0])
        max_char = int(numbers[1])
        char = content[1][0]
        password = content[2]
        
        occurrences = list(password).count(char)
        if occurrences <= max_char and occurrences >= min_char:
            counter += 1

print(counter)

counter = 0
with open('input.txt') as f:
    for line in f:
        content = line.strip().split()
        numbers = content[0].split('-')
        index_one = int(numbers[0]) - 1
        index_two = int(numbers[1]) - 1
        char = content[1][0]
        password = content[2]
        
        num_letters = 0
        if password[index_one] == char:
            num_letters += 1
        if password[index_two] == char:
            num_letters += 1
        
        if num_letters == 1:
            counter += 1
print(counter)
            
        