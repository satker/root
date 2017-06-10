import copy

def table(num, resf):
    # num - число элементов,  например num = "20"
    # resf - значения функции, например resf = [1, 1, 0, 0]
    i = 2 ** int(num)
    assert (len(resf) == i), "result function must be same length with 2^n"
    ttable = []
    p = 1
    for r in range(int(num)):  # создаем n строк
        m = 0
        ttable.append([])  # создаем пустую строку
        for c in range(i):  # в каждой строке - i элементов
            l = int(i / 2 ** p)
            while len(ttable[r]) != i:  # заполняем таблицу истинности
                if m < (l):
                    ttable[r].append(0)
                    m += 1
                elif ttable[r].count(1) == ttable[r].count(0):
                    m = 0
                else:
                    ttable[r].append(1)
                    m += 1
        p += 1
    ttable.append(resf)
    print("ok")
    return ttable


def step1(num, resf):  # шаг создания таблицы при 1 значения функции из таблицы истинности
    ttable = table(num, resf)
    count = ttable[int(num)].count(1)  # подсчет количества 1
    step = []
    i = 2 ** int(num)
    xy = -1
    for count_ttable1 in range(int(num) + 1):  # count_ttable1 - индекс столбцов таблицы истинности
        for count_ttable2 in range(i):  # count_ttable2 - индекс строк таблицы истинности
            if count_ttable1 == int(num) and ttable[count_ttable1][
                count_ttable2] == 1:  # ищем в значениях функции (мы добавили resf последним столбцом) которые равны 1
                if xy < count:
                    xy += 1
                ips = 0
                for x_step in range(count):  # x_step - индекс столбцов таблицы 2 шага
                    if len(step) < count:
                        step.append([])
                    for y_ in range(int(num)):  # y_step - индекс строк таблицы 2 шага
                        if x_step == xy and ips < int(num):
                            step[x_step].append(int(ttable[ips][count_ttable2]))
                            ips += 1
                            ttable[int(num)][count_ttable2] = 0
    print("ok")
    return step


def sortByCount1(inputStr):
    return (inputStr.count(1))


def tableSortByCount1(num, resf):  # группируем элементы по кол-ву единиц
    t_step2 = step1(num, resf)
    t_step2.sort(key=sortByCount1)
    return t_step2


def step2(num, resf):  # Склейка
    t_step2 = tableSortByCount1(num, resf)
    stepm = []
    t_bool = [[]]
    lol = 0
    ech = 0
    for x in range(len(t_step2)):  # count_ttable1 - индекс столбцов таблицы истинности
        count = t_step2[x].count(1)
        if t_step2[x].count(1) == count:
            for y in range(len(t_step2)):
                coun = count + 1
                if t_step2[y].count(1) == coun:
                    for x_bool in range(1):
                        del t_bool[lol]
                        t_bool.append([])
                        # lol += 1
                        for z in range(int(num)):
                            if t_step2[x][z] == t_step2[y][z]:
                                t_bool[lol].append("t")
                            else:
                                t_bool[lol].append("f")
                    if t_bool[lol].count("f") == 1:
                        for v in range(1):
                            stepm.append(copy.deepcopy(t_step2[x]))
                        stepm[ech].insert((t_bool[lol].index("f")), "x")
                        del stepm[ech][(t_bool[lol].index("f")) + 1]
                        ech += 1
    print("ok")
    return stepm


def sortByX(inputStr):
    return (inputStr.index("x"))


def tableSortByX(num, resf):  # группируем элементы по кол-ву единиц
    t_step3 = step2(num, resf)
    t_step3.sort(key=sortByX)
    print("ok")
    return t_step3


def step3(num, t_step3):  # Склейка между элементами с n иксами
    t_bool = [[]]
    lol = -1
    stepm = []
    ipp = -1
    iii = 4
    iip = 1
    while ipp < 1:
        ipp += 1
        for ik in range(len(t_step3)):
            if iii == iip:
                for v in range(1):
                    stepm.append(copy.deepcopy(t_step3[ik - 1]))
            iip = 0
            iii = 0
            for i in range(len(t_step3)):
                if ik != i:
                    for y, k in enumerate(t_step3[ik]):
                        if t_step3[ik].count("x") == t_step3[i].count("x") and t_step3[ik][y] == t_step3[i][y] and k == "x":
                            iip += 1
                            for x_bool in range(1):
                                del t_bool[lol]
                                t_bool.append([])
                                # lol += 1
                                for z in range(int(num)):
                                    if t_step3[ik][z] == t_step3[i][z]:
                                        t_bool[lol].append("t")
                                    else:
                                        t_bool[lol].append("f")
                            if t_bool[lol].count("f") == 1:
                                ech = len(stepm)
                                for v in range(1):
                                    stepm.append(copy.deepcopy(t_step3[ik]))
                                stepm[ech].insert((t_bool[lol].index("f")), "x")
                                del stepm[ech][(t_bool[lol].index("f")) + 1]
                                break
                            else:
                                iii += 1
                                break

    stepm = [em for im, em in enumerate(stepm) if em not in stepm[:im]]
    print("ok")
    return stepm


def step4(num, resf):
    table4 = tableSortByX(num, resf)
    #table4 = [ ['x', 0, 1, 0, 1], ['x', 1, 1, 0, 1], ['x', 0, 0, 0, 1], ['x', 1, 0, 0, 1], ['x', 1, 1, 1, 1], ['x', 0, 1, 1, 1], ['x', 0, 0, 0, 0]]
    i = 0
    tttable = []
    t_table4 = [0]
    while i < int(num):
        if tttable == t_table4:
            break
        if len(tttable) == 0:
            tttable = table4
        else:
            tttable = t_table4
        t_table4 = step3(num, tttable)
        i += 1
    #print(t_table4)
    print("ok")
    return t_table4

def t_step5(num, resf):
    res = copy.deepcopy(resf)
    xt = step4(num, resf)
    yt = tableSortByCount1(num, res)
    t = []
    t_bool = [[]]
    count = -1
    for i in range(len(yt)+1):

        t.append([])
        if i == 0:
            t[i].append(0)
            for it in range(len(xt)):
                t[i].append(xt[it])

        else:
            count += 1
            #t[i].append([])
            for c in range(len(xt)+1):
                if c == 0:
                    t[i].append(yt[count])
                else:
                    t[i].append(0)
            del t_bool[0]
            t_bool.append([])
    l = -1
    for ill in range(len(yt) + 1):

        if ill!= 0:
            #del t_bool[0]
            for zx in range (len(xt)+1):
                #l += 1
                if zx != 0:
                    for z in range(int(num)):
                        if t[0][zx][z] == t[ill][0][z]:
                            t_bool[0].append("t")
                        elif t[0][zx][z] == "x":
                            t_bool[0].append("t")
                        else:
                            t_bool[0].append("f")
                    if t_bool[l].count("t") == int(num):
                        t[ill].insert(zx, "V")
                        del t[ill][zx + 1]

                    del t_bool[0]
                    t_bool.append([])
    return t

def sortByN(inputStr):
    return (len(inputStr))


def tableSortByN(table):  # группируем элементы по кол-ву единиц
    table.sort(key=sortByN, reverse=True)
    #print("ok")
    return table


def t_step6dop(tab):
    table6 = []
    c = 0
    x_t = []
    for x in range(len(tab)):
        for i in range(len(tab[0])):
            if tab[x][i] == "V" and i != 0:
                coun = i
                x_t.append(x)
                table6.append([])
                x_t = [em for im, em in enumerate(x_t) if em not in x_t[:im]]
                table6[c].append(coun)
                table6[c].append(x_t)
                del x_t
                x_t = []
                c += 1
    dtable6 = []
    for xi in range (len(tab[0])):
        dtable6.append([])
        if xi != 0:
            for ii in range(len(table6)):
                if table6[ii][0] == xi:
                    dtable6[xi].append(table6[ii])
    dtable6 = tableSortByN(dtable6)
    dtable6_f = []
    dtable6_f.append(dtable6[0])
    return dtable6_f

def t_step6(num, resf):
    tab = t_step5(num, resf)
    t_i_ind = []
    t_ind = []
    res = []
    for i in range(len(tab)):
        if tab[i].count("V") == 1:
            res.append(tab[0][tab[i].index("V")])
            t_ind.append(tab[i].index("V"))
            t_i_ind.append(i)
    for pii in range(len(t_ind)):
        for poo in range(len(tab)):
            if tab[poo][t_ind[pii]] == "V":
                t_i_ind.append(poo)
    t_ind = [em for im, em in enumerate(t_ind) if em not in t_ind[:im]]
    t_i_ind = [em for im, em in enumerate(t_i_ind) if em not in t_i_ind[:im]]
    t_i_ind.sort(reverse=True)
    t_ind.sort(reverse=True)
    for inn in range(len(t_i_ind)):
        del tab[t_i_ind[inn]]
    for it in range(len(t_ind)):
        for itk in range(len(tab)):
            del tab[itk][t_ind[it]]
    if len(tab) == 0 and len(tab) == 1:
        res = res
    else:
        while len(tab) != 1 and len(tab) != 0:
            matr = t_step6dop(tab)
            if len(matr) == 1 and len(matr) == 0:
                break
            kv = len(matr)
            res.append(tab[0][matr[0][0][0]])
            for inr in range(len(matr[0])):
                del tab[matr[0][len(matr[0])-1-inr][1][0]]
            for inrf in range(len(tab)):
                del tab[inrf][matr[0][0][0]]
    res = [em for im, em in enumerate(res) if em not in res[:im]]
    return res
