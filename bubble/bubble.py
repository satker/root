class Sort():
    def __init__(self, m):
        while self.control(m) != 0:
            i = 0
            while i < (len(m) - 1):
                if m[i] > m[i+1]:
                    m[i], m[i+1] = m[i+1], m[i]
                i = i + 1
        print(m)

    def control(self, m):
        count = 0
        i = 0
        while i < (len(m) - 1):
            if m[i] > m[i+1]:
                count = count+1
            i = i+1
        return count

