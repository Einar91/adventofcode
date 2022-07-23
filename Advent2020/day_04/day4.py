def read_file(filename):
    alle_pass = []
    with open(filename) as f:
        linje = f.readline()
        neste_pass = True
        while linje:
            if neste_pass == True:
                nytt_passport = {}
                neste_pass = False
            if linje != '\n':
                innhold = linje.strip().split()
                for elem in innhold:
                    a,b = elem.strip().split(':')
                    nytt_passport[a] = b
            if linje == '\n':
                alle_pass.append(nytt_passport)
                neste_pass = True
            linje = f.readline()
    return alle_pass

def sjekk_hoyde(hoyde):
    valid = True
    if 'cm' in hoyde or 'in' in hoyde:        
        if 'cm' in hoyde:
            hoyde = hoyde[:-2]
            hoyde = int(hoyde)
            if hoyde > 193 or hoyde < 150:
                valid = False
        elif 'in' in hoyde:
            hoyde = hoyde[:-2]
            hoyde = int(hoyde)
            if hoyde > 76 or hoyde < 59:
                valid = False        
    else:
        valid = False
    return valid

def sjekk_harfarge(farge):
    valid = True
    if farge[0] != '#':
        valid = False
    if len(farge) < 7:
        valid = False
    return valid

def sjekk_pass(passport):
    valid = True
    byr = int(passport['byr'])
    iyr = int(passport['iyr'])
    eyr = int(passport['eyr'])
    hgt = passport['hgt']
    hcl = passport['hcl']
    ecl = passport['ecl']
    pid = passport['pid']

    if byr > 2002 or byr < 1920:
        #print('Byr:', byr)
        valid = False
    if iyr > 2020 or iyr < 2010:
        #print('Iyr:', iyr)
        valid = False
    if eyr > 2030 or eyr < 2020:
        #print('Eyr:', eyr)
        valid = False
    if not sjekk_hoyde(hgt):
        #print('Hgt:', hgt)
        valid = False
    if not sjekk_harfarge(hcl):
        #print('Hcl:', hcl)
        valid = False
    if ecl not in ['amb', 'blu', 'brn', 'gry', 'grn', 'hzl', 'oth']:
        #print('Ecl:', ecl)
        valid = False
    if len(pid) != 9:
        print('Pid:', pid)
        valid = False
    
    return valid


    

filename = 'input.txt'
liste_med_pass = read_file(filename)

teller = 0
for item in liste_med_pass:
    if len(item) == 8:
        if sjekk_pass(item):
            teller += 1
    if len(item) == 7 and 'cid' not in item:
        if sjekk_pass(item):
            teller += 1
print(teller)

