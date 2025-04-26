import sys
input = sys.stdin.readline
n = int(input())
vertical = [0] * 1000001
horizontal = [0] * 1000001
fx, fy = list(map(int, input().split()))
px, py = fx, fy 
for j in range(n):
    if j < n - 1:   nx, ny = map(int, input().split())
    else:   nx, ny = fx, fy
    if nx == px:
        for i in range(min(ny, py), max(ny, py)):
            horizontal[i + 500000] += 1
    else:
        for i in range(min(nx, px), max(nx, px)):
            vertical[i + 500000] += 1
    px, py = nx, ny
print(max(max(horizontal), max(vertical)))