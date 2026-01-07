import math
import struct

def calculate(x):
    # y = sin(3x - 5) / ctg(2x) = sin(3x - 5) * tan(2x)
    return math.sin(3 * x - 5) * math.tan(2 * x)

def write_text(filename, result):
    with open(filename, 'w', encoding='utf-8') as f:
        f.write(str(result))

def read_text(filename):
    with open(filename, 'r', encoding='utf-8') as f:
        return f.read()

def write_bin(filename, result):
    with open(filename, 'wb') as f:
        f.write(struct.pack('d', result))  # 'd' = double precision float

def read_bin(filename):
    with open(filename, 'rb') as f:
        return struct.unpack('d', f.read())[0]

# --- Виконання ---
x = float(input("Введіть x: "))
y = calculate(x)

print("Результат:", y)

write_text("result.txt", y)
write_bin("result.bin", y)

print("З текстового файлу:", read_text("result.txt"))
print("З бінарного файлу:", read_bin("result.bin"))