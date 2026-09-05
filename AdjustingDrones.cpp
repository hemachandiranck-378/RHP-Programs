#include <bits/stdc++.h>
#define ll long long int
using namespace std;

void solve() {
    int n, k;
    cin >> n >> k;

    vector<ll> a(n);
    for (auto &x : a) cin >> x;

    sort(a.begin(), a.end());

    vector<ll> b(n);
    set<ll> used;

    for (int i = n - 1; i >= 0; --i) {
        auto it = used.lower_bound(a[i]);

        if (it == used.end() || *it > a[i]) {
            b[i] = a[i];
        } else {
            b[i] = *it + 1;
            while (used.count(b[i])) {
                b[i]++;
            }
        }

        used.insert(b[i]);
    }

    auto check = [&](ll m) -> bool {
        map<ll, int> cnt;

        for (int i = 0; i < n; ++i) {
            ll value = min(a[i] + m, b[i]);
            cnt[value]++;

            if (cnt[value] > k)
                return false;
        }

        return true;
    };

    ll lo = 0, hi = n;

    while (lo < hi) {
        ll mid = lo + (hi - lo) / 2;

        if (check(mid))
            hi = mid;
        else
            lo = mid + 1;
    }

    cout << lo << endl;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--) {
        solve();
    }

    return 0;
}