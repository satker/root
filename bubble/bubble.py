class Sort():
    def __init__(self, m):
        count = 1
        while self.control(m) != 0:
            i = 0
            while i < (len(m) - count):
                if m[i] > m[i+1]:
                    m[i], m[i+1] = m[i+1], m[i]
                i += 1
            count += 1

        self.m = m

    def control(self, m):
        count = 0
        i = 0
        while i < (len(m) - 1):
            if m[i] > m[i+1]:
                count = count+1
            i += 1
        return count
