def read_puzzle_input(filnavn):
    rules = {}
    with open(filnavn) as fil:
        for line in fil:
            contains = {}
            content = line.strip().split(',')
            key, first_bag = content[0].split('contain')
            key = key.strip()
            key = key[:-1]
            
            first_bag = first_bag.strip()
            if '.' in first_bag:
                first_bag = first_bag[:-1]
            if 'bags' in first_bag:
                first_bag = first_bag[:-1]      
            if first_bag[0] == 'n':      
                pass
                #no bags
            else:
                contains[first_bag[2:]] = int(first_bag[0])
            for bag in content[1:]:
                bag = bag.strip()
                if '.' in bag:
                    bag = bag[:-1]
                if 'bags' in bag:
                    bag = bag[:-1]
                contains[bag[2:]] = bag[0]
            rules[key] = contains
    return rules

def check_for_bag_in_other_bags(reslist, bagname='shiny gold bag'):
    diff_bags = []
    for bag in reslist:
        if bagname in reslist[bag]:
            #print(bag, '-', bagname, reslist[bag])
            diff_bags.append(bag)
            diff_bags = diff_bags + check_for_bag_in_other_bags(reslist, bag)
    return diff_bags

def bags_in_bag(reslist, bagname='shiny gold bag'):
    tot = 0
    for bag in reslist[bagname]:
        num_bags = int(reslist[bagname][bag])
        #print(num_bags, '-', bagname, '-', bag, '-', reslist[bagname], '-', tot)
        tot += num_bags
        tot += bags_in_bag(reslist, bag) * num_bags
    return tot

def part_two(reslist, bagname='shiny gold bag'):
    gold_bag = reslist['shiny gold bag']
    bags_inside = 0
    for bag in gold_bag:
        bags_inside += int(gold_bag[bag])
        bags_inside += bags_in_bag(reslist, bag)
        print(bag, gold_bag[bag])

    print(bags_inside)



filnavn = 'input.txt'
result = read_puzzle_input(filnavn)
#r = check_for_bag_in_other_bags(result)
#r = part_two(result)
p = bags_in_bag(result)
print(p)

# part two 354 tolow
# teller = 0
# for bag in result:
#     contains = result[bag]
#     if 'shiny gold bag' in contains:
#         teller += 1

# print(teller)