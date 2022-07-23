def les_input(filnavn):
    alle_jolt = []
    with open(filnavn) as fil:
        for line in fil:
            jolt = int(line.strip())
            alle_jolt.append(jolt)
    alle_jolt.sort()
    return alle_jolt

def puzzle_one(adapters):
    used_adapters = []
    not_used_adapters = []
    last_adapter = 0
    one_in_difference = 0
    three_in_difference = 0
    
    for adapter in adapters:
        if last_adapter + 3 >= adapter:
            if last_adapter + 1 == adapter:
                one_in_difference += 1
            if last_adapter + 3 == adapter:
                three_in_difference += 1
            used_adapters.append(adapter)
            last_adapter = adapter
        else:
            not_used_adapters.append(adapter)
    # Device difference of 3
    three_in_difference += 1
    print(one_in_difference * three_in_difference)

def find_possibel_jumps(adapters):
    options = {}
    i = 0
    for adapter in adapters:
        j = i + 1
        connections = []
        neste = False
        while j < len(adapters) and not neste:
            next_adapter = adapters[j]
            if next_adapter > adapter and next_adapter <= (adapter + 3):
                connections.append(next_adapter)
            else:
                neste = True
            j += 1
        options[adapter] = connections
        i += 1
    return options

   

def puzzle_two(adapters):
    options = find_possibel_jumps(adapters)
    antall_muligheter = {'1': 0, '2': 0, '3': 0}
    for k,v in options.items():
        if len(v) == 1:
            antall_muligheter['1'] = antall_muligheter['1'] + 1
        if len(v) == 2:
            antall_muligheter['2'] = antall_muligheter['2'] + 1            
        if len(v) == 3:
            antall_muligheter['3'] = antall_muligheter['3'] + 1
    return antall_muligheter
    
    


filnavn = 'input_test.txt'
jolt_list = les_input(filnavn)
#puzzle_one(jolt_list)
#print(jolt_list)
print(puzzle_two(jolt_list))