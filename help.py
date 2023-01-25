def main():
    arr = input("What's the ar? ")
    list_1 = (arr.rstrip()).split(' ')
    array = list(map(int, list_1))
    for a in analyze(array)[0]:
        if len(a) == analyze(array)[1]:
            print(a, end = "\n")


def analyze(ar: list) -> list:
    hashmap = {}
    index = 1
    if len(ar) == 1:
        hashmap[str(index)] = ar
    for i in range(len(ar)):
        if i != len(ar) - 1:
            if ar[i] >= ar[i+1]:
                hashmap[str(index)] = list()
                if len(hashmap.keys()) == 1:
                    x = 0
                    hashmap[str(index)] = ar[x:i+1]
                    index += 1
                else:
                    x = x + len(hashmap[str(index-1)])
                    hashmap[str(index)] = ar[x:i+1]
                    index += 1
        else:
            if index == 1:
                hashmap[str(index)] = ar
            else:
                hashmap[str(index)] = ar[x + len(hashmap[str(index-1)]):]
    length = 0
    for val in hashmap.values():
        if len(val) > length:
            length = len(val)
    return list(hashmap.values()), length


if __name__ == "__main__":
    main()
