
def check_slope(start_index, filename, skip=False):
    current_index = start_index
    num_trees = 0
    with open(filename) as f:
        skip_first = f.readline()
        if skip:
            skip_second = f.readline()

        for line in f:
            treeline = list(line.strip())
            if current_index >= len(treeline):
                current_index = current_index - (len(treeline) - 1) - 1
            path = treeline[current_index]
            print(path)
            if path == '#':
                num_trees += 1
            current_index += start_index
            if skip:
                skip_every_other = f.readline()
    return num_trees

filename = 'input.txt'
s1 = check_slope(3, filename)
s2 = check_slope(1, filename)
s3 = check_slope(5, filename)
s4 = check_slope(7, filename)
s5 = check_slope(1, filename, skip=True)

tot = s1*s2*s3*s4*s5
print(tot)

#1161705600 to low