def finn_alle_id(filnavn):
    alle_seter = []
    
    with open(filnavn) as fil:
        for line in fil:
            topp = 127
            bunn = 0
            t_row = 7
            b_row = 0     
            print(line)
            if line != '\n':
                for bokstav in line.strip():
                    if bokstav == 'F':
                        topp = (topp + bunn) // 2
                    elif bokstav == 'B':
                        add = ((topp - bunn) // 2) + 1
                        bunn += add 
                    
                    if bokstav == 'L':
                        t_row = (t_row + b_row) // 2
                    elif bokstav == 'R':
                        add = ((t_row - b_row) // 2) + 1
                        b_row += add 
                alle_seter.append([topp, t_row])

    alle_id = []
    for sete in alle_seter:
        bid = (sete[0] * 8) + sete[1]
        alle_id.append(bid)
    return alle_id


filnavn = 'input.txt'
ider = finn_alle_id(filnavn)

hoyest = ider[0]
for i in ider[1:]:
    if i > hoyest:
        hoyest = i

lavest = ider[0]
for i in ider[1:]:
    if i < lavest:
        lavest = i

alle_seter = set(range(lavest, hoyest + 1))
mangler = alle_seter - set(ider)
print(mangler)




# for i in range(hoyest + 1):
#     if i not in ider:
#         print(i)



