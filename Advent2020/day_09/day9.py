def les_input(filnavn):
    all_numbers = []
    with open(filnavn) as fil:
        for line in fil:
            number = int(line.strip())
            all_numbers.append(number)
    return all_numbers

def puzzel_one(number_list, pre=25):
    preamble = number_list[:pre]
    
    for current_number in number_list[pre:]:
        found_sum = False

        i = 0
        while found_sum == False and i < pre:
            j = 0
            while found_sum == False and j < pre:
                #print(preamble[i], preamble[j], current_number)
                num_i = preamble[i]
                num_j = preamble[j]
                if num_i != num_j and num_i+num_j == current_number:
                    found_sum = True
                j += 1
            i += 1    
        if not found_sum:
            print(current_number)
            #print(preamble)
        
        preamble.append(current_number)
        preamble = preamble[1:]        

def puzzel_two(number_list, sum_num=466456641):
    i = 0
    j = 0
    result = None
    contiguous_numbers = []
    found_contigouse = False
    while i < len(number_list) and not found_contigouse:
        current_number = number_list[j]
        contiguous_numbers.append(current_number)            
        if len(contiguous_numbers) > 1 and sum(contiguous_numbers) == sum_num:
            found_contigouse = True
            result = contiguous_numbers[:]
        j += 1
        #print(i, j, len(number_list))
        if j >= len(number_list):
            i += 1
            j = i
            contiguous_numbers = []

    if result is not None:
        result.sort()
        print(result)
        print(result[0], result[-1])
        print(result[0] + result[-1])


filnavn = 'input.txt'
tall = les_input(filnavn)
#puzzel_one(tall)
puzzel_two(tall)