import copy

def les_input(filnavn):
    all_operations = []
    with open(filnavn) as fil:
        for line in fil:
            content = line.strip().split()
            operation = content[0].strip()
            code = content[1].strip()
            all_operations.append([operation, int(code)])
    return all_operations

def puzzel_part_one(op_codes):
    visited = []
    accumulator = 0
    index = 0
    while index not in visited:
        visited.append(index)
        instruction, code = op_codes[index]
        if instruction == "acc":
            accumulator += code
            index += 1
        if instruction == 'jmp':
            index = index + code
        if instruction == 'nop':
            index += 1
    print(accumulator)

def puzzel_part_two(op_codes):
    terminator_index = 642
    for k,op in enumerate(op_codes):
        if op[0] == 'nop' or op[0] == 'jmp':
            temp_list = copy.deepcopy(op_codes)
            instruction, operation = temp_list[k]
            if instruction == 'nop':
                temp_list[k] = ['jmp', operation]
            if instruction == 'jmp':
                temp_list[k] = ['nop', operation]

            visited = []
            accumulator = 0
            prev_index = 0
            index = 0
            while index not in visited and index < terminator_index:
                prev_index = index
                visited.append(index)
                temp_ins, temp_code = temp_list[index]
                if temp_ins == "acc":
                    accumulator += temp_code
                    index += 1
                if temp_ins == 'jmp':
                    index = index + temp_code
                if temp_ins == 'nop':
                    index += 1
            
            if index == terminator_index:
                print(index, accumulator)

if __name__ == '__main__':
    filnavn = 'input.txt'
    op = les_input(filnavn)
    #puzzel_part_one(op)
    index_to_change = puzzel_part_two(op)

