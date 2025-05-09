#include <iostream>
#include <queue>

using namespace std;

int Time[100001];
int Move[3];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int SubinPos, SisPos;
    cin >> SubinPos >> SisPos;

    if (SubinPos == SisPos) {
        cout << 0;
        return 0;
    }

    queue<int> Q;
    Time[SisPos] = -1;
    Time[SubinPos] = 1;

    Q.push(SubinPos);

    while (1)
    {
        auto Cur = Q.front(); Q.pop();
        Move[0] = Cur + 1;
        Move[1] = Cur - 1;
        Move[2] = Cur * 2;

        for (int i{ 0 }; i < 3; ++i)
        {
            if (Move[i] < 0 || Move[i] > 100000) continue;
            if (Time[Move[i]] == -1)
            {
                cout << Time[Cur] ;
                return 0;
            }
            if (Time[Move[i]] != 0) continue;
            Time[Move[i]] = Time[Cur] + 1;
            Q.push(Move[i]);
        }
    }

    return 0;
}