# Finn de to tallene som summert blir 2020
alle_tall = []
with open('input.txt') as f:
    for num in f:
        alle_tall.append(int(num.strip()))
    
for tall in alle_tall:
    for tall_2 in alle_tall:
        if tall + tall_2 == 2020:
            print(tall, tall_2)
            print('Ganget:', tall*tall_2)

for tall in alle_tall:
    for tall_2 in alle_tall:
        for tall_3 in alle_tall:
            if tall + tall_2 + tall_3 == 2020:
                print(tall, tall_2, tall_3)
                print('Ganget:', tall*tall_2*tall_3)