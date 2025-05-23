function isMatch(user, banned) {
    if (user.length !== banned.length) return false;
    for (let i = 0; i < user.length; i++) {
        if (banned[i] !== '*' && banned[i] !== user[i]) return false;
    }
    return true;
}

function solution(user_id, banned_id) {
    const matches = banned_id.map(ban =>
        user_id.filter(user => isMatch(user, ban))
    );

    const result = new Set();

    function dfs(level, path, used) {
        if (level === banned_id.length) {
            const sorted = [...path].sort().join(',');
            result.add(sorted);
            return;
        }

        for (const user of matches[level]) {
            if (!used.has(user)) {
                used.add(user);
                path.push(user);
                dfs(level + 1, path, used);
                path.pop();
                used.delete(user);
            }
        }
    }

    dfs(0, [], new Set());
    return result.size;
}
