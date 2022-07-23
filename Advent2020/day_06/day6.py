def hent_ant_ulike(streng):
    return len(set(list(streng)))

def los_opp1(filnavn):
    alle_svar_antall = []
    with open(filnavn) as fil:
        gruppe = ''
        ant = 0
        for line in fil:
            if line != '\n':
                ny_linje = line.strip()
                gruppe += ny_linje
            elif line == '\n':
                num = hent_ant_ulike(gruppe)
                alle_svar_antall.append(num)
                print(gruppe)
                gruppe = ''
        num = hent_ant_ulike(gruppe)
        alle_svar_antall.append(num)
    print(ant)
    return alle_svar_antall

def hent_ant_like(liste_med_svar):
    snitt = set.intersection(*liste_med_svar)
    return len(snitt)

def los_opp2(filnavn):
    alle_svar_antall = []
    with open(filnavn) as fil:
        gruppe = []
        ant = 0
        for line in fil:
            if line != '\n':
                ny_linje = line.strip()
                gruppe.append(set(ny_linje))
            elif line == '\n':
                num = hent_ant_like(gruppe)
                alle_svar_antall.append(num)
                gruppe = []
        num = hent_ant_like(gruppe)
        alle_svar_antall.append(num)
    return alle_svar_antall    

if __name__ == '__main__':
    filnavn = 'input_org.txt'
    print(sum(los_opp2(filnavn)))