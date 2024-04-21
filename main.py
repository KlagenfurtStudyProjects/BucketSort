import matplotlib.pyplot as plt

y_10 = [0.049012401, 4.331176000, 720.387903300]
y_100 = [0.019520800, 0.293791600, 54.976325100]
y_1000 = [0.006171799, 0.057735400, 4.304269099]
x = [10000, 100000, 1000000]

plt.figure(figsize=(8, 6))
plt.plot(x, y_10, label='10 buckets', color='blue', linestyle='-', marker='o')
plt.plot(x, y_100, label='100 buckets', color='red', linestyle='--', marker='o')
plt.plot(x, y_1000, label='1000 buckets', color='brown', linestyle='dotted', marker='o')
plt.yscale('log')
plt.xscale('log')
plt.title('Time / Arrays')
plt.xlabel('Array size')
plt.ylabel('Time, s')
plt.legend()
plt.grid(True)

plt.show()