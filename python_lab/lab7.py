# функція котра створює масив заданої довжини
def sublist(size):
    list = []
    for i in range(size):
        list.append(fillerChar)
    return list
#основний блок коду який обробляє одну єдину помилку
try:
    #створення матриці та ввід даних
    matrix = []
    matrixSize = int(input("Введіть розмір матриці: "))
    fillerChar = input("Введіть символ заповнювач: ")
    #перевірка на запис (не обов'язково, це суто для галочки в методичці)
    if len(fillerChar) != 1:
        raise ValueError
    #заповнення матриці
    matrix = [sublist(i) for i in range(1, matrixSize+1)]
    #вивід матриці
    x = 0
    space = ""
    matrix.reverse()
    for i in matrix:
        print(f"{space}{str(i)}")
        space = f"{space}" + (len(fillerChar) * " ") + "    "
    # а це був дебаг, потім видалю
    print("hello" + "a")
#ловимо вийняток і перериваємо роботу
except ValueError:
    print("Filler char should be 1 char long or else")